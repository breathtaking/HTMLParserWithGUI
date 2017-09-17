package com.javafxapp.controller;

import com.javafxapp.parsers.ImagesParser;
import com.javafxapp.parsers.LinksParser;
import com.javafxapp.parsers.TagsParser;
import com.javafxapp.sources.FileHtmlSource;
import com.javafxapp.sources.StringHtmlSource;
import com.javafxapp.sources.URLHtmlSource;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class MainController {
    @FXML
    private TextArea textArea;

    @FXML
    private TextField urlField;
    @FXML
    private Button urlButton;

    @FXML
    private TextField filePathField;
    @FXML
    private Button filePathButton;

    @FXML
    private TextField stringField;
    @FXML
    private Button stringButton;

    @FXML
    public void initialize() {
        urlButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                parseUrl();
            }
        });

        filePathButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                parseFile();
            }
        });

        stringButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                parseString();
            }
        });
    }

    @FXML
    public void parseUrl() {
        if (!urlField.getText().equals("")) {
            String url = urlField.getText();
            URLHtmlSource urlHtmlSource = new URLHtmlSource(url);
            if (urlHtmlSource.isUrlExists()) {
                Document document = urlHtmlSource.getDocumentFromSource();
                parseAndShow(document, textArea);
            }
            else textArea.setText("The URL is incorrect. Please, check it");

        } else textArea.setText("You've not pasted a link to the web page");
    }

    @FXML
    public void parseFile() {
        if (!filePathField.getText().equals("")) {
            String filePath = filePathField.getText();
            FileHtmlSource fileHtmlSource = new FileHtmlSource(filePath);
            if (fileHtmlSource.isFileExists()) {
                Document document = fileHtmlSource.getDocumentFromSource();
                parseAndShow(document, textArea);
            }
            else textArea.setText("You've pasted a wrong path to file");

        } else textArea.setText("You've not pasted a path to file");
    }

    @FXML
    public void parseString() {
        if (!stringField.getText().equals("")) {
            String htmlAsString = stringField.getText();
            StringHtmlSource stringHtmlSource = new StringHtmlSource(htmlAsString);
            Document document = stringHtmlSource.getDocumentFromSource();
            parseAndShow(document, textArea);

        } else textArea.setText("You've not paste a text you are going to parse");
    }


    public void parseAndShow(Document document, TextArea textArea) {
        LinksParser linksParser = new LinksParser(document);
        ArrayList<String> listOfLinks = (ArrayList<String>) linksParser.parse();

        ImagesParser imagesParser = new ImagesParser(document);
        ArrayList<String> listOfImages = (ArrayList<String>) imagesParser.parse();

        TagsParser tagsParser = new TagsParser(document);
        ArrayList<String> listOfTags = (ArrayList<String>) tagsParser.parse();

        if (textArea.getText().length() == 0) {
            for (String link : listOfLinks) {
                textArea.appendText(link);
            }
            for (String link : listOfImages) {
                textArea.appendText(link);
            }
            for (String link : listOfTags) {
                textArea.appendText(link);
            }
        }
        else {
            textArea.setText("");
            for (String link : listOfLinks) {
                textArea.appendText(link);
            }
            for (String link : listOfImages) {
                textArea.appendText(link);
            }
            for (String link : listOfTags) {
                textArea.appendText(link);
            }
        }
    }
}
