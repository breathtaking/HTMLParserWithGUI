package com.javafxapp.parsers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ImagesParser implements HtmlParser {
    private Document document;
    private List<String> listOfLinks;

    public ImagesParser(Document document) {
        this.document = document;
    }

    public List<String> parse() {
        Elements images = document.select("[src]");
        listOfLinks = new ArrayList<String>();
        listOfLinks.add(String.format("\nImages: (%d)", images.size()));
        for (Element src : images) {
            if (src.tagName().equals("img"))
                listOfLinks.add(String.format("\n * %s path: %s", src.tagName(), src.attr("src")));
        }
        return listOfLinks;
    }

    public List<String> getListOfLinks() {
        return listOfLinks;
    }

}
