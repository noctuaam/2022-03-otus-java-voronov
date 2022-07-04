package ru.voronov.dataprocessor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.voronov.model.Measurement;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResourcesFileLoader implements Loader {

    private final ObjectMapper mapper = new ObjectMapper();
    //String json;
    private File file;

    public ResourcesFileLoader(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        //json = getResourceFileAsString(fileName);
        file = new File(classLoader.getResource(fileName).getFile());
    }

    @Override
    public List<Measurement> load() throws IOException {
        //читает файл, парсит и возвращает результат
        //return mapper.readValue(json, new TypeReference<List<Measurement>>() {});
        return mapper.readValue(
                file,
                new TypeReference<List<Measurement>>(){});
        //return Arrays.asList(mapper.readValue(json, Measurement[].class));
        //return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, Measurement.class));
        /*Measurement[] myObjects = mapper.readValue(file, Measurement[].class);


        /*JsonNode jsonNode = mapper.readTree(file);
        jsonNode.
        String arrayString = jsonNode.get("name").toString();
        return mapper.readValue(arrayString, new TypeReference<List<Measurement>>() {});*/
        //return Arrays.asList(mapper.readValue(json, Measurement[].class));
        //return mapper.readerForListOf(Measurement.class).readValue(file);
        ///return mapper.readValue(json, new TypeReference<List<Measurement>>(){});

    }

    public String getResourceFileAsString(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }
}
