package ru.voronov.atm.banknotes;

/**
 * @author Aleksandr Voronov
 */
public enum RussianRuble  implements Banknote {
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000);

    private final int value;

    RussianRuble(int value) {
        this.value = value;
    }

    @Override
    public int nominal() {
        return value;
    }

    @Override
    public Banknote[] valuesList(){
        return RussianRuble.values();
    }
}