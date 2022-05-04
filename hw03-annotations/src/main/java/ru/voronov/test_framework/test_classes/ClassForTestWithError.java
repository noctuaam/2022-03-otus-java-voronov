package ru.voronov.test_framework.test_classes;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;

/**
 * @author Aleksandr Voronov
 */
public class ClassForTestWithError {

    private int i = 1;

    @Before
    public void beforeMethod(){
        System.out.println("beforeMethod");
        i--;
    }

    @Test
    public void testMethod(){
        double divideByZero = 6 / i;
        System.out.println("testMethod");
    }

    @After
    public void afterMethod(){
        System.out.println("afterMethod");
    }

}
