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

    public CVLineUI(final Application application, final CVListUI parent, CV cv) {
        this.application = application;
        this.cv = cv;

        CVNameTextPane.setText(cv.getFirstname() + " "+ cv.getName().getName());
        CVHashTextPane.setText(cv.getId());

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
