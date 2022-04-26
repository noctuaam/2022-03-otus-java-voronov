package ru.voronov.test_framework;

import ru.voronov.test_framework.annotations.After;
import ru.voronov.test_framework.annotations.Before;
import ru.voronov.test_framework.annotations.Test;
import ru.voronov.test_framework.helpers.ClassResult;
import ru.voronov.test_framework.helpers.MethodResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ru.voronov.test_framework.helpers.ReflectionHelper.instantiate;

/**
 * @author Aleksandr Voronov
 */
public class ClassAnalyzer {

    private Class<?> clazz;

    public ClassAnalyzer(String className) throws ClassNotFoundException {
        clazz = Class.forName(className);
    }

    private List<MethodResult> invokeMethods(Class<? extends Annotation> annotation){
        Method[] methods = clazz.getDeclaredMethods();
        return Arrays.stream(methods).filter(method -> method.isAnnotationPresent(annotation))
                .map(method -> {
                    method.setAccessible(true);
                    try {
                        method.invoke(instantiate(clazz));
                        return new MethodResult(
                                MethodResult.State.SUCCESS,
                                method.getName());
                    } catch (IllegalAccessException e) {
                        return new MethodResult(MethodResult.State.ERROR, e.getMessage());
                    } catch (InvocationTargetException e) {
                        return new MethodResult(MethodResult.State.ERROR, e.getMessage());
                    }
                }
                ).collect(Collectors.toList());
    }

    public void test(){
        invokeMethods(Before.class);
        List<MethodResult> testResults = invokeMethods(Test.class);
        invokeMethods(After.class);
        System.out.println(new ClassResult(clazz,testResults));
    }
}
