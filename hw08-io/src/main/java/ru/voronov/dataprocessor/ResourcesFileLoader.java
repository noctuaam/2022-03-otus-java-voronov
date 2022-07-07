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

    public ResourcesFileLoader(String fileName) throws IOException {
        json = getResourceFileAsString(fileName);
    }

    @Override
    public List<Measurement> load(){
        //читает файл, парсит и возвращает результат
        return new Gson().fromJson(json, new TypeToken<ArrayList<Measurement>>(){}.getType());
    }

    public String getResourceFileAsString(String fileName) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        try{
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                return reader.lines().collect(Collectors.joining(System.lineSeparator()));
            }
        }finally {
            is.close();
        }
        return null;
    }
}
