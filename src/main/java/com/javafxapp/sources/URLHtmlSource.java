package com.javafxapp.sources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class URLHtmlSource implements SourceType {
    private Document document;
    private String url;
    private boolean isUrlExists = false;

    public URLHtmlSource(String url) {
        this.url = url.trim();
    }

    public boolean isUrlExists() {
        if (url != null) {
            try {
                URL url = new URL(this.url);
                String host = url.getHost();
                InetAddress.getByName(host);
                isUrlExists = true;
            } catch (MalformedURLException ex) {
                isUrlExists = false;
            } catch (UnknownHostException ex) {
                isUrlExists = false;
            }
        }
        return isUrlExists;
    }

    public Document getDocumentFromSource() throws NullPointerException {
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
