package ru.voronov;

import ru.voronov.comparator.Comparator;
import ru.voronov.comparator.SimpleComparator;
import ru.voronov.proxy.Ioc;

/**
 * @author Aleksandr Voronov
 */
public class Main {

    public static void main(String[] args) {

        final Class<Comparator> calculatorClass = Comparator.class;
        final Comparator engineeringCalculator = Ioc.createWithLogging(calculatorClass, new SimpleComparator());
        engineeringCalculator.compare(1);
        engineeringCalculator.compare(1, 2);
        engineeringCalculator.compare(10, 20, "Тестовое сообщение (engineeringCalculator)");

    }

}
