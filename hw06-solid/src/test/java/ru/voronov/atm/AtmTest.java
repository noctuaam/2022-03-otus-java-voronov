package ru.voronov.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.voronov.atm.banknotes.Banknote;
import ru.voronov.atm.banknotes.AmericanDollar;
import ru.voronov.atm.banknotes.RussianRuble;
import ru.voronov.atm.exceptions.ImpossibleCashAmmountException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AtmTest {

    private Atm atm;
    private int initialBalance;
    private Banknote[] banknotesForTest = {AmericanDollar.ONE_HUNDRED,
                                        AmericanDollar.FIVE_HUNDRED,
                                        AmericanDollar.TWO_HUNDRED,
                                        AmericanDollar.ONE_THOUSAND,
                                        AmericanDollar.FIVE,
                                        AmericanDollar.ONE_HUNDRED,
                                        AmericanDollar.ONE_HUNDRED,
                                        AmericanDollar.ONE_THOUSAND,
                                        AmericanDollar.FIVE_HUNDRED,
                                        AmericanDollar.ONE_HUNDRED,
                                        AmericanDollar.ONE_HUNDRED,
                                        AmericanDollar.TWO_HUNDRED,
                                        AmericanDollar.ONE_THOUSAND,
                                        AmericanDollar.FIVE,
                                        AmericanDollar.TWO_HUNDRED,
                                        AmericanDollar.TWO_HUNDRED,
                                        AmericanDollar.ONE_HUNDRED,
                                        AmericanDollar.FIVE_HUNDRED,
                                        AmericanDollar.TWO_HUNDRED,
                                        AmericanDollar.ONE_THOUSAND,
                                        AmericanDollar.FIVE,
                                        AmericanDollar.TWENTY_FIVE,AmericanDollar.TWENTY_FIVE,
                                        AmericanDollar.TWENTY_FIVE,
                                        AmericanDollar.TEN,
                                        AmericanDollar.TEN,
                                        AmericanDollar.TEN,
                                        AmericanDollar.TEN,
                                        AmericanDollar.FIFTY,
                                        AmericanDollar.FIFTY,
                                        AmericanDollar.FIFTY,
                                        AmericanDollar.TWENTY_FIVE};

    @BeforeEach
    void before() {
        atm = new Atm();

        Collection<Banknote> banknotes = new ArrayList<>();
        for (Banknote banknote : this.banknotesForTest) {
            banknotes.add(banknote);
            initialBalance += banknote.nominal();
        }
        atm.addBanknotes(banknotes);
    }

    @DisplayName("Загрузка купюр")
    @Test
    void load() {
        List<Banknote> banknotes = List.of(AmericanDollar.FIVE_HUNDRED, AmericanDollar.ONE_HUNDRED);

        atm.addBanknotes(banknotes);

        assertEquals(initialBalance + 600, atm.getBalance());
    }

    @DisplayName("Загрузка купюр под которые не определено ячеек")
    @Test
    void loadUndefinedBanknote() {
        List<Banknote> banknotes = List.of(RussianRuble.FIVE_HUNDRED, RussianRuble.ONE_HUNDRED);

        List<Banknote> undefinedBanknotes = atm.addBanknotes(banknotes);

        assertEquals(undefinedBanknotes, banknotes);
    }

    @DisplayName("Выдача купюр - минимальная корректная сумма")
    @Test
    void cashOutMinCorrect() {
        int amount = 5;

        Collection<Banknote> b1 = atm.getCash(amount);

        assertEquals(1, b1.size());
        assertEquals(amount, (int) b1.stream().map(Banknote::nominal).reduce(Integer::sum).get());
    }

    @DisplayName("Выдача купюр - максимальная корректная сумма")
    @Test
    void cashOutMaxCorrect() {
        int amount  = initialBalance;

        Collection<Banknote> b2 = atm.getCash(amount);

        assertEquals(banknotesForTest.length, b2.size());
        assertEquals(amount, (int) b2.stream().map(Banknote::nominal).reduce(Integer::sum).get());
    }

    @DisplayName("Выдача купюр - корректная промежуточная сумма")
    @Test
    void cashCorrect() {
        int amount  = 80;

        Collection<Banknote> b2 = atm.getCash(amount);

        assertEquals(3, b2.size());
        assertEquals(amount, (int) b2.stream().map(Banknote::nominal).reduce(Integer::sum).get());
    }

    @DisplayName("Выдача купюр - отрицательная сумма")
    @Test
    void cashOutNegative() {
        int amount = -1;

        assertThrows(ImpossibleCashAmmountException.class, () -> atm.getCash(amount));
    }

    @DisplayName("Выдача купюр - некорректная сумма")
    @Test
    void cashIncorrect() {
        int amount  = 47;

        assertThrows(ImpossibleCashAmmountException.class, () -> atm.getCash(amount));
    }

    @DisplayName("Получение баланса")
    @Test
    void getBalance() {
        long balance = atm.getBalance();

        assertEquals(initialBalance, balance);
    }
}