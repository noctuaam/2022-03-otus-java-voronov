package ru.voronov.test_framework.helpers;

import java.util.List;

/**
 * @author Aleksandr Voronov
 */
public record ClassResult(Class<?> clazz,
                          List<MethodResult> results) {

    private int getTestCount(){
        return results.size();
    }

    private int getTestSuccessCount(){
        return (int) results.stream().filter(MethodResult::successState).count();
    }

    private int getTestErrorsCount(){
        return (int) results.stream().filter(MethodResult::errorState).count();
    }

    @Override
    public String toString() {
        return String.format(
                "\n-----------------" +
                "\nРезультат тестирования:" +
                "\nКласс: %s" +
                "\nРезультат:" +
                "\nОбщее количество тестов: %s" +
                "\nКоличество тестов без ошибок: %s" +
                "\nКоличество тестов с ошибками: %s" +
                "\n-----------------",
                clazz.getSimpleName(),getTestCount(),getTestSuccessCount(),getTestErrorsCount());
    }
}
