package com.atrakeur.web.restclient.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CVRawDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JEditorPane experienceBegin201311EditorPane;

    public CVRawDialog(Frame parent) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void show(Frame parent) {
        final CVRawDialog dialog = new CVRawDialog(parent);
        dialog.pack();
        dialog.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width - dialog.getSize().width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - dialog.getSize().height) / 2
        );
        dialog.setVisible(true);
    }
}
