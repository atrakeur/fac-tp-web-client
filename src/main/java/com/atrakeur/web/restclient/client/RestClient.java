package com.atrakeur.web.restclient.client;


import com.atrakeur.web.restclient.model.CV;
import com.atrakeur.web.restclient.model.CVList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestClient {

    private String baseUrl = "http://cv-atrakeur.rhcloud.com/resume";

    public RestClient() {
    }

    public RestClient(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public CVList getAll() throws IOException, JAXBException {
        String uri = baseUrl;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        //Read objects returned by service
        JAXBContext jc = JAXBContext.newInstance(CVList.class);
        InputStream xml = connection.getInputStream();
        CVList list = (CVList) jc.createUnmarshaller().unmarshal(xml);

        connection.disconnect();

        return list;
    }

    public CV get(String hash) throws IOException, JAXBException {
        String uri = baseUrl+"/"+hash;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");

        //Read object returned by service
        JAXBContext jc = JAXBContext.newInstance(CV.class);
        InputStream xml = connection.getInputStream();
        CV cv = (CV) jc.createUnmarshaller().unmarshal(xml);

        connection.disconnect();

        return cv;
    }

    public CV add(CV cv) throws IOException, JAXBException {
        String uri = baseUrl;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/xml");

        //Write object to post data
        OutputStream os = connection.getOutputStream();
        JAXBContext jc = JAXBContext.newInstance(CV.class);
        jc.createMarshaller().marshal(cv, os);

        //Read object returned by service
        jc = JAXBContext.newInstance(CV.class);
        InputStream xml = connection.getInputStream();
        cv = (CV) jc.createUnmarshaller().unmarshal(xml);

        connection.disconnect();

        return cv;
    }

    public CV delete(String hash) throws IOException, JAXBException {
        String uri = baseUrl + "/" + hash;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");
        connection.setRequestProperty("Accept", "application/xml");

        //Read object returned by service
        JAXBContext jc = JAXBContext.newInstance(CV.class);
        InputStream xml = connection.getInputStream();
        CV cv = (CV) jc.createUnmarshaller().unmarshal(xml);

        connection.disconnect();

        return cv;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        String oldBaseUrl = this.baseUrl;
        this.baseUrl = baseUrl;
    }
}
