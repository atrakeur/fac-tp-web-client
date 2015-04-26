package com.atrakeur.web.restclient.ui;

import com.atrakeur.web.restclient.Application;
import com.atrakeur.web.restclient.model.CV;
import com.atrakeur.web.restclient.model.CVList;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class CVLineUI {
    private Application application;
    private CV cv;

    private JPanel panel;
    private JTextPane CVNameTextPane;
    private JTextPane CVHashTextPane;
    private JButton deleteButton;
    private JButton voirButton;

    public CVLineUI(final Application application, final CVListUI parent, CV cv) {
        this.application = application;
        this.cv = cv;

        CVNameTextPane.setText(cv.getFirstname() + " "+ cv.getName().getName());
        CVHashTextPane.setText(cv.getId());

        voirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Get cv linked to this hash
                            final CV cv = application.getClient().get(CVHashTextPane.getText());
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    final JFrame frame = new JFrame();
                                    frame.add(new CVUI(application, frame, cv).getPanel());
                                    frame.pack();
                                    frame.setLocationRelativeTo(application.getFrame());
                                    frame.setVisible(true);
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            frame.toFront();
                                            frame.revalidate();
                                        }
                                    });
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoadingDialog.show(application.getFrame(), task);
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //Delete it
                            application.getClient().delete(CVHashTextPane.getText());
                            //load new list
                            final CVList list = application.getClient().getAll();
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    parent.setCVList(list);
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JAXBException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoadingDialog.show(application.getFrame(), task);
            }
        });
    }

    public Component getPanel() {
        return panel;
    }
}
