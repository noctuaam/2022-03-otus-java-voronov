package ru.voronov.test_framework.test_classes;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;

/**
 * @author Aleksandr Voronov
 */
public class TestClassWithBeforeError {

    @Before
    public void beforeMethod(){
        if(true){
            throw new RuntimeException("Ошибка в @Before методе!!");
        }
        System.out.println("beforeMethod");
    }

    @Test
    public void testMethod(){
        System.out.println("testMethod");
    }

    @After
    public void afterMethod(){
        System.out.println("afterMethod");
    }

}
