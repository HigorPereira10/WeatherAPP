package com.projeto.weatherapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiKeyLoader {
    public static String loadApiKey() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = ApiKeyLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Arquivo config.properties não encontrado.");
            }
            properties.load(input);
        }
        return properties.getProperty("api_key");
    }
}
