package ru.voronov.dataprocessor;

import ru.voronov.model.Measurement;

import java.util.*;
import java.util.stream.Collectors;

public class ProcessorAggregator implements Processor {

    @Override
    public Map<String, Double> process(List<Measurement> data) {
        //группирует выходящий список по name, при этом суммирует поля value
        return data.stream()
                .collect(Collectors.toMap(
                // ключ - строка
                e -> e.getName(),
                // значение - число,
                // суммируем два поля
                e -> e.getValue(),
                // суммируем значения
                // повторяющихся элементов
                Double::sum,
                // имплементация карты
                // с сортировкой элементов
                // в порядке добавления
                LinkedHashMap::new));
    }
}
