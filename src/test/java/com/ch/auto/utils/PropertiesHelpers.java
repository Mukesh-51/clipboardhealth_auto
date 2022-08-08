package com.ch.auto.utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesHelpers {
    private static Properties appProperties;

    static {
        FileReader reader = null;
        try {
            reader = new FileReader("src/test/resources/config.properties");
            appProperties = new Properties();
            appProperties.load(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves properties from the resources package config.properties file
     *
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName) {
        return appProperties.getProperty(propertyName);
    }
}
