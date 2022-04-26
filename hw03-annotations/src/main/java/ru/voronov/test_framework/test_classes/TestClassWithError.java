package ru.voronov.test_framework.test_classes;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;

/**
 * @author Aleksandr Voronov
 */
public class TestClassWithError {

    @Before
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @Test
    public void testMethod(){
        if(true){
            throw new RuntimeException("Ошибка в @Test методе!!");
        }
        System.out.println("testMethod");
    }

    @Test
    public void testMethod2(){
        System.out.println("testMethod2");
    }

    @After
    public void afterMethod(){
        System.out.println("afterMethod");
    }

}
