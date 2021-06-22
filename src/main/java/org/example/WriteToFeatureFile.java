package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFeatureFile {

    public WriteToFeatureFile(String name, String endpoint, String userId, Query[] query, String method) {
        try {

            FileWriter myWriter = new FileWriter("C:\\dev\\automate-feature-files\\src\\main\\java\\features\\"+name.replaceAll("\\s","") + ".feature");
            writeFeatureName(name, myWriter);
            writeBackground(myWriter, endpoint, userId);
            writeScenarioTitle(myWriter, name, endpoint, userId, query, method);
            myWriter.close();
            System.out.println("Feature Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    void writeFeatureName(String name, FileWriter fileWriter) {
        try {
            fileWriter.append("Feature: " + name);
        }
        catch (IOException e) {

        }
    }


    void writeBackground(FileWriter fileWriter, String endpoint, String userId) {
        try {
            fileWriter.append("\n\n" + "Background:" + "\n");
            fileWriter.append("\n" + "* def url = " + endpoint);
            fileWriter.append("\n" + "* configure headers = read('classpath:corejs/header.js')");
            fileWriter.append("\n" + "* header PREAUTH_USER_ID = " + userId);
            fileWriter.append("\n" + "Then status 200");
        }
        catch (IOException e) {

        }
    }

    void writeScenarioTitle(FileWriter fileWriter, String name, String endpoint, String userId, Query[] query, String method) {
        try {
            fileWriter.append("\n\n" + "Scenario: Validate " + name);
            fileWriter.append("\n" + "Given url " + endpoint);
            for (Query s : query) {
                fileWriter.append("\n" + "And param " + s.getKey() + " = " + s.getValue());
            }
            fileWriter.append("\n" + "When method " + method);

        }
        catch (IOException e) {

        }
    }


}



