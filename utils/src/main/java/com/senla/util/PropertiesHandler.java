package com.senla.util;


import com.senla.exceptions.ServiceExceptions;
import lombok.extern.log4j.Log4j;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
@Log4j
public class PropertiesHandler {


    private static final String FAILED_READ_PROPERTIES_ERROR_MESSAGE = "Failed to read properties";
    private static Properties properties;
    private static final String PROPERTIES_FILE_PATH = "/Hotel/config.properties";

    private PropertiesHandler() {
    }

    public static Optional<String> getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        return Optional.ofNullable(properties.getProperty(key));
    }


    private static void loadProperties() {
        try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            log.warn(FAILED_READ_PROPERTIES_ERROR_MESSAGE + e.getMessage());
            throw new ServiceExceptions(FAILED_READ_PROPERTIES_ERROR_MESSAGE, e);
        }
    }
}


