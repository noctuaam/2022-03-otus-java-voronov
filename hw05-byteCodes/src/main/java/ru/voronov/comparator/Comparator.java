package ru.voronov.comparator;

/**
 * @author Aleksandr Voronov
 */
public interface Comparator {

    void compare(int number);

    void compare(int numberOne, int numberTwo);

    void compare(int numberOne, int numberTwo, String message);
}
