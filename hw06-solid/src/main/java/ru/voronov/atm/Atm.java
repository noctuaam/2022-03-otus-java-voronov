package ru.voronov.atm;

import ru.voronov.atm.banknotes.Banknote;
import ru.voronov.atm.banknotes.AmericanDollar;
import ru.voronov.atm.basket.CellsBasket;
import ru.voronov.atm.basket.CellsBasketImpl;
import ru.voronov.atm.exceptions.ImpossibleCashAmmountException;

import java.util.Collection;
import java.util.List;

/**
 * @author Aleksandr Voronov
 */
public class Atm {

    private CellsBasket cellsBasket = new CellsBasketImpl(AmericanDollar.FIVE);

    /**
     * Добавление купюр
     * @param banknotes
     * @return если что-то не удалось включить - возвращаем обратно
     */
    public List<Banknote> addBanknotes(Collection<Banknote> banknotes){
        return cellsBasket.addBanknotes(banknotes);
    }

    /**
     * Получение наличных
     * @param amount
     * @return
     */
    public List<Banknote> getCash(int amount) {
        if (amount <= 0){
            throw new ImpossibleCashAmmountException("Запрошенная сумма должна быть больше нуля.",amount);
        }
        List<Banknote> banknotes = cellsBasket.getAmount(amount);
        if (banknotes.size() == 0) throw new ImpossibleCashAmmountException("Не удалось вернуть запрошенную сумму.",amount);
        return banknotes;
    }

    /**
     * Получение общего остатка
     * @return
     */
    public int getBalance(){
        return cellsBasket.balance();
    }



}
