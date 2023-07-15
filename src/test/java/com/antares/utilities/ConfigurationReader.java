package com.antares.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

            /*
    In this class we will create a reusable logic to read from configuration.properties file
     */

    //1- Create the Properties object (create object)
    private static Properties properties = new Properties();

    static {
        try {
            //2- Open file using FileInputStream (open file)
            FileInputStream file = new FileInputStream("configuration.properties");

            //3- Load the "properties" object with "file" (load properties)
            properties.load(file);

            //close the file in the memory (optional)
            file.close();

        } catch (IOException e) {
            System.out.println("File not found with given path");
            e.printStackTrace();
        }
    }

    // create a utility method to use the object to read
    public static String getProperty(String key){

        //4- Use "properties" object to read from file (read properties)
        return properties.getProperty(key);

    }


}
