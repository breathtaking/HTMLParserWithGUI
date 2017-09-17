package com.javafxapp.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class LinksParser implements HtmlParser {
    private Document document;
    private List<String> listOfLinks;

    public List<String> getListOfLinks() {
        return listOfLinks;
    }

    public LinksParser(Document document) {
        this.document = document;
    }

    public List<String> parse() {
        Elements links = document.select("a[href]");
        listOfLinks = new ArrayList<String>();
        listOfLinks.add(String.format("\nLinks: (%d)", links.size()));
        for (Element link : links) {
            listOfLinks.add(String.format("\n * link path: %s ", link.attr("abs:href")));
        }
        return listOfLinks;
    }

}
