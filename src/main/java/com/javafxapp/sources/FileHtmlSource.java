package com.javafxapp.sources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;

public class FileHtmlSource implements SourceType {
    private Document document;
    private String filePath;
    private File file;
    private boolean isFileExists = false;

    public FileHtmlSource(String filePath) {
        this.filePath = filePath;
    }

    public boolean isFileExists() {
        file = new File(filePath);
        if (file.exists() && file.isFile()) {
            isFileExists = true;
        }
        return isFileExists;
    }

    public Document getDocumentFromSource() throws NullPointerException {
        try {
            document = Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
