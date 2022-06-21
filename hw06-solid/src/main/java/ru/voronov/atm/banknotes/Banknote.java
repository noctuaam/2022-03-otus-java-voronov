package ru.voronov.atm.banknotes;

/**
 * @author Aleksandr Voronov
 */
public interface Banknote {
    Banknote[] valuesList();

    int nominal();

}
