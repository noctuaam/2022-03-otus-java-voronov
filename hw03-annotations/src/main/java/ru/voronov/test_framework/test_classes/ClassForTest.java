package ru.voronov.test_framework.test_classes;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;

/**
 * @author Aleksandr Voronov
 */
public class ClassForTest {

    private int i = 0;

    @Before
    public void beforeMethod(){
        System.out.println("beforeMethod");
        i++;
    }


    @Test
    public void testMethod(){
        System.out.println("testMethod");
        assert (i==1);
    }

    @After
    public void afterMethod(){
        System.out.println("afterMethod");
        i = 0;
    }

}
