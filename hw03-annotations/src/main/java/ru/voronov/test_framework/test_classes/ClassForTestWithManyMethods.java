package ru.voronov.test_framework.test_classes;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;

/**
 * @author Aleksandr Voronov
 */
public class ClassForTestWithManyMethods {

    private int i = 0;

    @Before
    public void beforeMethod(){
        System.out.println("beforeMethod");
        i++;
    }

    @Before
    public void beforeMethod2(){
        System.out.println("beforeMethod");
        i++;
    }


    @Test
    public void testMethod(){
        System.out.println("testMethod");
        assert(i==2);
    }

    @Test
    public void testMethod2(){
        System.out.println("testMethod2");
        assert(i==2);
    }

    @After
    public void afterMethod(){
        System.out.println("afterMethod");
    }

}
