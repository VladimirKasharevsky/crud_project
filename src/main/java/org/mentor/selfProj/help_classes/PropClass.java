package org.mentor.selfProj.help_classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropClass {

    public static String getProp(String propName) throws IOException{
     Properties property = new Properties();

        try {
            FileInputStream fis =  fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return property.getProperty(propName);
    }
}
