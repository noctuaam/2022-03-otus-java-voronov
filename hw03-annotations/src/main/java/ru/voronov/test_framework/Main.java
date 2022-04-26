package ru.voronov.test_framework;

/**
 * @author Aleksandr Voronov
 */
public class Main {

     public static void main(String[] args) throws ClassNotFoundException {
          new ClassAnalyzer("ru.voronov.test_framework.test_classes.TestClass").test();
          new ClassAnalyzer("ru.voronov.test_framework.test_classes.TestClassWithError").test();
          new ClassAnalyzer("ru.voronov.test_framework.test_classes.TestClassWithBeforeError").test();
     }
}
