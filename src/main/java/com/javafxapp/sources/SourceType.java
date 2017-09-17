package com.javafxapp.sources;

import org.jsoup.nodes.Document;

public interface SourceType {
    Document getDocumentFromSource() throws NullPointerException;
}
