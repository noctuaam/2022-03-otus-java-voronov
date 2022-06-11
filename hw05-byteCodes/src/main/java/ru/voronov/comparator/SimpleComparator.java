package ru.voronov.comparator;

import ru.voronov.proxy.Log;

/**
 * @author Aleksandr Voronov
 */
public class SimpleComparator implements Comparator {

    @Log
    @Override
    public void compare(int param1) {
        System.out.println("Выполнение SimpleComparator.compare(int param1)");
    }

    @Log
    @Override
    public void compare(int param1, int param2) {
        System.out.println("Выполнение SimpleComparator.compare(int param1, int param2)");
    }

    @Log
    @Override
    public void compare(int param1, int param2, String param3) {
        System.out.println("Выполнение SimpleComparator.compare(int param1, int param2, String param3)");
    }
}
