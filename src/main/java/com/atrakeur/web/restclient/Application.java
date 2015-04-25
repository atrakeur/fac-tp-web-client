package com.atrakeur.web.restclient;

import com.atrakeur.web.restclient.client.RestClient;
import com.atrakeur.web.restclient.ui.CVListUI;

import javax.swing.*;
import java.awt.*;

public class Application {

    private RestClient client;
    private JFrame frame;

    public Application() {
        this.client = new RestClient();

        frame = new JFrame("CVList");
        frame.setContentPane(new CVListUI(this).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(
                (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getSize().width) / 2,
                (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getSize().height) / 2
        );
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Application();
    }

    public RestClient getClient() {
        return client;
    }

    public JFrame getFrame() {
        return frame;
    }
}
