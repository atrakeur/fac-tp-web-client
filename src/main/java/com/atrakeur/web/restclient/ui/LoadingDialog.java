package com.atrakeur.web.restclient.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoadingDialog extends JDialog {

    private JPanel contentPane;
    private JButton buttonCancel;
    private JLabel loadingLabel;

    public LoadingDialog(Frame parent, final Runnable task) {
        final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                task.run();
                dispose();
                return null;
            }
        };

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCancel);

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                worker.cancel(true);
                dispose();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                worker.cancel(true);
                dispose();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                worker.cancel(true);
                dispose();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        worker.execute();
    }

    public static void show(Frame parent, final Runnable task) {
        final LoadingDialog dialog = new LoadingDialog(parent, task);
        dialog.pack();
        dialog.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width - dialog.getSize().width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - dialog.getSize().height) / 2
        );
        dialog.setVisible(true);
    }
}
