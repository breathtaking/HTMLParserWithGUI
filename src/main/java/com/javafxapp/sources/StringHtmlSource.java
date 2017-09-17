package com.javafxapp.sources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StringHtmlSource implements SourceType{
    private Document document;
    private String str;

    public Document getDocument() {
        return document;
    }

    public String getStr() {
        return str;
    }

    public StringHtmlSource(String str) {
        this.str = str;
    }

    public Document getDocumentFromSource() throws NullPointerException{
        document = Jsoup.parse(str);
        return document;
    }
}
