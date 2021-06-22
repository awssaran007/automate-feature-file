package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    String data;


    public String readFile() {

        try {
            System.getProperty("user.dir");
            File myObj = new File("xmedia_ox_postman_collection.json");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (data == null) {
                    data = myReader.nextLine();
                } else data = data.concat(myReader.nextLine());
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        data = data.replaceAll(("[\\s]"), "").trim();
        return data;
    }


    public static void main(String[] args) {
        App a = new App();
        System.out.println(a.readFile());
        final Reader reader = new StringReader(a.readFile());
        JsonReader jsonReader = new JsonReader(reader);
        FeatureFiles[] targetArray = new GsonBuilder().setLenient().create().fromJson(jsonReader, FeatureFiles[].class);


        for (FeatureFiles s : targetArray) {

            for (Header h : s.getRequest().getHeader()) {

                if (h.getKey().equals("PREAUTH_USER_ID")) {
                    String endpoint = s.getRequest().getUrl().getRaw();
                    endpoint = endpoint.substring(0, endpoint.indexOf('?'));
                    new WriteToFeatureFile(s.getName(), endpoint, h.getValue(), s.getRequest().getUrl().getQuery(), s.getRequest().getMethod());
                }
            }


        }
    }
}
