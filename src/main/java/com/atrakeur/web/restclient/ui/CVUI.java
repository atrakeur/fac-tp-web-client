package com.atrakeur.web.restclient.ui;

import com.atrakeur.web.restclient.Application;
import com.atrakeur.web.restclient.model.CV;
import com.atrakeur.web.restclient.model.CV_Name;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CVUI {
    private Application application;
    private JFrame frame;
    private CV cv;

    private JPanel panel;
    private JTextField nameField;
    private JTextField firstNameField;
    private JComboBox maidenField;
    private JTextField objectiveField;
    private JButton experiencesButton;
    private JTextField skillsField;
    private JButton langButton;
    private JButton otherInfoButton;
    private JButton ajouterButton;
    private JButton annulerButton;
    private JButton editerButton;

    public CVUI(final Application application, final JFrame frame, final CVListUI listUI) {
        this.application = application;
        this.frame = frame;
        this.cv = new CV();

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cv.setName(new CV_Name());
                cv.getName().setName(nameField.getText());
                if (maidenField.getSelectedIndex() == 0) {
                    cv.getName().setMaiden(true);
                } else {
                    cv.getName().setMaiden(true);
                }
                cv.setFirstname(firstNameField.getText());
                cv.setObjective(objectiveField.getText());
                cv.setSkill(skillsField.getText());
                //TODO experience
                //TODO school
                //TODO lang
                //TODO computer_sciences_skill

                Runnable task = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            final CV returnCv = application.getClient().add(cv);
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    CVUI.this.frame.setVisible(false);
                                    listUI.refresh();
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
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CVUI.this.frame.setVisible(false);
            }
        });
    }

    public CVUI(Application application, JFrame frame, CV cv) {
        this.frame = frame;
        this.cv = cv;

        nameField.setText(cv.getName().getName());
        nameField.setEditable(false);
        firstNameField.setText(cv.getFirstname());
        firstNameField.setEditable(false);
        maidenField.setSelectedIndex((cv.getName().isMaiden() ? 0 : 1));
        maidenField.setEnabled(false);
        objectiveField.setText(cv.getObjective());
        objectiveField.setEditable(false);
        skillsField.setText(cv.getSkill());
        skillsField.setEditable(false);

        ajouterButton.setVisible(false);
        annulerButton.setText("Retour");
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CVUI.this.frame.setVisible(false);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
