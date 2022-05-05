package ru.voronov.test_framework;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;
import ru.voronov.test_framework.helpers.TestResult;
import ru.voronov.test_framework.helpers.MethodResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Aleksandr Voronov
 */
public class TestClass {

    private Class<?> clazz;
    private Object instance;


    public TestClass(String className) throws ClassNotFoundException {
        clazz = Class.forName(className);
    }

    public TestResult test() throws InvocationTargetException, IllegalAccessException {

        List<Method> beforeMethods = getMethodsWithAnnotation(Before.class);
        List<Method> afterMethods = getMethodsWithAnnotation(After.class);
        List<Method> testMethods = getMethodsWithAnnotation(Test.class);

        List<MethodResult> methodResults = new ArrayList<>();
        for(Method testMethod : testMethods){
            try {
                instance = getConstructor().newInstance();
                invokeMethods(beforeMethods);
                methodResults.add(invokeTestMethod(testMethod));
            } catch (Exception e) {
                methodResults.add(new MethodResult(MethodResult.State.ERROR,testMethod.getName())
                        .setMessage(e.getCause().getMessage()));
            } finally {
                invokeMethods(afterMethods);
            }
        }
       return new TestResult(clazz,methodResults);
    }


    private List<Method> getMethodsWithAnnotation(Class<? extends Annotation> annotation){
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods).filter(method -> method.isAnnotationPresent(annotation)).toList();
    }

    private void invokeMethods(List<Method> methods) throws InvocationTargetException, IllegalAccessException {
        for(Method method : methods){
            invokeMethod( method);
        }
    }

    private void invokeMethod(Method method) throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        method.invoke(instance);
    }

    private  MethodResult invokeTestMethod(Method testMethod){
        try {
            invokeMethod(testMethod);
            return new MethodResult(
                    MethodResult.State.SUCCESS,
                    testMethod.getName());
        } catch (IllegalAccessException | InvocationTargetException e) {
            return new MethodResult(MethodResult.State.ERROR,testMethod.getName())
                    .setMessage(e.getCause().getMessage());
        }
    }

    private Constructor<?> getConstructor() throws NoSuchMethodException {
        return clazz.getConstructor();
    }

}
