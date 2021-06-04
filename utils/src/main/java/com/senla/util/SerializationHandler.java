package com.senla.util;


import com.senla.exceptions.ServiceExceptions;
import com.senla.model.AEntity;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Collections;
import java.util.List;
@Log4j
public class SerializationHandler {

    private static final String PATH_TO_FILE = PropertiesHandler.getProperty("server.serialization.path_to_file")
            .orElseThrow(() -> new ServiceExceptions("Serialization file path not found"));

    @SafeVarargs
    public static void serialize(List<? extends AEntity>... entities) {
        List<List<? extends AEntity>> marshalingList = List.of(entities);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(PATH_TO_FILE))) {
            outputStream.writeObject(marshalingList);
        } catch (IOException e) {
            log.warn("Serialization to file failed" + e.getMessage());
            throw new ServiceExceptions(e);
        }
    }

    public static <T> List<T> deserialize(Class<T> clazz) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(PATH_TO_FILE))) {
            List<List<? extends AEntity>> list = (List<List<? extends AEntity>>) inputStream.readObject();
            for (List<? extends AEntity> entities : list) {
                if (!entities.isEmpty() && entities.get(0).getClass().equals(clazz)) {
                    return (List<T>) entities;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            log.warn("Deserialization failed:" + e.getLocalizedMessage());
            throw new ServiceExceptions(e);
        }
        return Collections.emptyList();
    }


}
