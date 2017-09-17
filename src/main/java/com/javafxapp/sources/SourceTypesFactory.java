package com.javafxapp.sources;

public class SourceTypesFactory {
    public static SourceType getInstance(String htmlPath, int sourceTypeId) {
        switch (sourceTypeId) {
            case 1: return new URLHtmlSource(htmlPath);
            case 2: return new FileHtmlSource(htmlPath);
            case 3: return new StringHtmlSource(htmlPath);
            default: return null;
        }
    }
}
