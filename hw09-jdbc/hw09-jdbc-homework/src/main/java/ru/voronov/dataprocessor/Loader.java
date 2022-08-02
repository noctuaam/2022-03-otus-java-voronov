package ru.voronov.dataprocessor;

import ru.voronov.model.Measurement;

import java.util.List;

public interface Loader {

    List<Measurement> load();
}
