package ru.voronov.atm.basket;

import ru.voronov.atm.banknotes.Banknote;

import java.util.Collection;
import java.util.List;

/**
 * @author Aleksandr Voronov
 * корзина с ячейками
 */
public interface CellsBasket {

    /**
     * Добавить купюры в банкомат
     * @return купюры, которые не удлалось включить в банкомат
     */
    List<Banknote> addBanknotes(Collection<Banknote> banknotes);

    /**
     * Получить купюрами указанную сумму, если возможно
     */
    List<Banknote> getAmount(int amount) throws IllegalArgumentException;

    /**
     * Узнать остаток
     */
    int balance();
}
