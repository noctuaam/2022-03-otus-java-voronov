package ru.voronov.dataprocessor;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import ru.voronov.model.Measurement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResourcesFileLoader implements Loader {

    private String json;

    public ResourcesFileLoader(String fileName) {
        json = getResourceFileAsString(fileName);
    }

    @Override
    public List<Measurement> load() {
        //читает файл, парсит и возвращает результат
        return new Gson().fromJson(json, new TypeToken<ArrayList<Measurement>>(){}.getType());
    }

    public String getResourceFileAsString(String fileName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
            if (is != null) {
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }catch (IOException ioException){
            throw new FileProcessException(ioException.getMessage());
        }
        return null;
    }
}
