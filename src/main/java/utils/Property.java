package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
    public static String getProperty(String propKey) throws IOException {
        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/resources/login.properties");
        property.load(fis);
        return property.getProperty(propKey);
    }
}
