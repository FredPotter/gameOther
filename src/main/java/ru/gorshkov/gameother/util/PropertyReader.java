package ru.gorshkov.gameother.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;

    public PropertyReader(String relativePath) {
        properties = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream(relativePath);
        try (in) {
            if (in == null) {
                throw new FileNotFoundException("File not found: " + relativePath);
            }
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProperties(String relativePath) throws IOException {
        properties = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream(relativePath);
        try (in) {
            if (in == null) {
                throw new FileNotFoundException("File not found: " + relativePath);
            }
            properties.load(in);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
