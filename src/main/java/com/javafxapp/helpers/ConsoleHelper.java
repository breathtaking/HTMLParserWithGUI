package com.javafxapp.helpers;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private BufferedReader reader;
    private int sourceTypeId;
    private String sourcePath;
    private boolean isCommandFound = false;

    public void openStream() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void closeStream() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getSourceTypeId() {
        while (!isCommandFound) {
            try {
                System.out.println("Please, select a type of HTML source");
                System.out.println("Press 1 to read HTML from an URL");
                System.out.println("Press 2 to read HTML from a File");
                System.out.println("Press 3 to read HTML from a String");
                System.out.println("Press 0 to exit");

                sourceTypeId = Integer.parseInt(reader.readLine());

                if(sourceTypeId > 0 && sourceTypeId < 4) isCommandFound = true;
                else if (sourceTypeId == 0) System.exit(1);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("You have typed a kind of Source that doesn't exists. Try another one");
            }
        }

        return sourceTypeId > 0 && sourceTypeId < 4 ? sourceTypeId : 4;
    }

    public String getSourcePath(int sourceTypeId) {
        try {
            switch (sourceTypeId) {
                case 1: {
                    System.out.println("Submit an URL to a web page you're going to parse");
                    sourcePath = reader.readLine();
                    return sourcePath;
                }
                case 2: {
                    System.out.println("Submit a path to a file you're going to parse");
                    sourcePath = reader.readLine();
                    return sourcePath;
                }
                case 3: {
                    System.out.println("Submit a String you're going to parse");
                    sourcePath = reader.readLine();
                    return sourcePath;
                }
                case 4: {
                    System.out.println("There is no command you've typed");
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sourcePath;
    }

    public String getSourcePath(){
        String path = null;
        try {
            path = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}

