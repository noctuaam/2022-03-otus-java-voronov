package ru.voronov.test_framework.helpers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksandr Voronov
 */
public record TestResult(Class<?> clazz,
                         List<MethodResult> results) {

    @Override
    public String toString() {

        String methodResults = results.stream().map(MethodResult::toString).collect(Collectors.joining());

        return String.format(
                "\n-----------------" +
                "\nРезультат тестирования:" +
                "\nКласс: %s" +
                "\nРезультат:" +
                "\nОбщее количество тестов: %s" +
                "\nКоличество тестов без ошибок: %s" +
                "\nКоличество тестов с ошибками: %s" +
                "\n %s" +
                "\n-----------------",
                clazz.getSimpleName(),getTestCount(),getTestSuccessCount(),getTestErrorsCount(),methodResults);
    }

    public void println(){
        System.out.println(this);
    }

    private int getTestCount(){
        return results.size();
    }

    private int getTestSuccessCount(){
        return (int) results.stream().filter(MethodResult::successState).count();
    }

    private int getTestErrorsCount(){
        return (int) results.stream().filter(MethodResult::errorState).count();
    }


}
