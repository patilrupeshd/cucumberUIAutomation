package cucumberPrac.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static Properties propertiesLoader(String filePath)
    {
        System.out.println("FILE PATH : " + filePath);
        Properties properties = new Properties();
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load properties file " + filePath);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Properties file is not found " + filePath);
        }
        return properties;
    }
}
