package ru.voronov.dataprocessor;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class FileSerializer implements Serializer {

    private final ObjectMapper mapper = new ObjectMapper();
    private final File file;

    public FileSerializer(String fileName) {
        file = new File(fileName);
    }

    @Override
    public void serialize(Map<String, Double> data) throws IOException {
        //формирует результирующий json и сохраняет его в файл
        mapper.writeValue(file, data);
    }
}
