package ru.voronov.test_framework;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Aleksandr Voronov
 */
public class Main {

     public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
          new TestClass("ru.voronov.test_framework.test_classes.ClassForTest").test().println();
          new TestClass("ru.voronov.test_framework.test_classes.ClassForTestWithManyMethods").test().println();
          new TestClass("ru.voronov.test_framework.test_classes.ClassForTestWithError").test().println();
     }
}
