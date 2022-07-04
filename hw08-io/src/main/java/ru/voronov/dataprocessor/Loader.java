package ru.voronov.dataprocessor;

import ru.voronov.model.Measurement;

import java.io.IOException;
import java.util.List;

public interface Loader {

    List<Measurement> load() throws IOException;
}
