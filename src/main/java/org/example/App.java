package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
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

        data = data.replaceAll(("[\\s]"), "");
        return data;
    }


    public static void main(String[] args) {
        App a = new App();
        System.out.println(a.readFile());

        FeatureFiles[] targetArray = new GsonBuilder().setLenient().create().fromJson(a.readFile(), FeatureFiles[].class);

    }
}
