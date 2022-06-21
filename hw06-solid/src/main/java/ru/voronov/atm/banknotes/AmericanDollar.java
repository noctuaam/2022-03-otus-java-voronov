package ru.voronov.atm.banknotes;

/**
 * @author Aleksandr Voronov
 */
public enum AmericanDollar implements Banknote {
    FIVE(5),
    TEN(10),
    TWENTY_FIVE(25),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000);

    private final int value;

    AmericanDollar(int value) {
        this.value = value;
    }

    @Override
    public int nominal() {
        return value;
    }

    @Override
    public Banknote[] valuesList(){
        return AmericanDollar.values();
    }
}