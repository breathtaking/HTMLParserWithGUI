package com.javafxapp.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class TagsParser implements HtmlParser {
    private Document document;
    private List<String> listOfLinks;

    public List<String> getListOfLinks() {
        return listOfLinks;
    }

    public TagsParser(Document document) {
        this.document = document;
    }

    public List<String> parse() {
        Elements tags = document.select("p");
        listOfLinks = new ArrayList<String>();
        listOfLinks.add(String.format("\nParagraphs: (%d)", tags.size()));
        return listOfLinks;
    }
}
