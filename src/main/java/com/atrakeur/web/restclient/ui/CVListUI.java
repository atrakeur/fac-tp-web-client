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


public class CVListUI {
    private final Application application;

    private JPanel panel1;
    private JButton createButton;
    private JButton refreshButton;
    private JPanel cvListPanel;
    private JTextField urlTextField;

    public CVListUI(final Application application) {
        this.application = application;

        urlTextField.setText(application.getClient().getBaseUrl());

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                application.getClient().setBaseUrl(urlTextField.getText());
                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            application.getClient().setBaseUrl(urlTextField.getText());
                            final CVList list = application.getClient().getAll();
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    setCVList(list);
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

    public Container getPanel() {
        return panel1;
    }

    public void setCVList(CVList list) {
        cvListPanel.removeAll();

        for (CV cv :list.getListCV()) {
            CVLineUI line = new CVLineUI(application, this, cv);
            cvListPanel.add(line.getPanel());
        }

        cvListPanel.invalidate();
        cvListPanel.revalidate();
    }
}
