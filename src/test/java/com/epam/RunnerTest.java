package com.epam;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RunnerTest {
    public static void main(String[] args) {
        int pass = 0;
        int fail = 0;
        Class<TestWithCustomAnnotation> obj = TestWithCustomAnnotation.class;
        getInfoAboutClass(obj);
        for (Method method : obj.getMethods()) {
            Action annotation = method.getAnnotation(Action.class);
            if (method.isAnnotationPresent(Action.class) && annotation.action().equals(Action.TypeAction.ADD)) {
                System.out.println("Running test " + method.getName() + ", return type of method: " + method.getReturnType());
                System.out.println("Annotation: " + annotation.annotationType());
                try {
                    method.invoke(obj.newInstance());
                    System.out.println("test " + method.getName() + " is SUCCESS");
                    pass++;
                } catch (Exception e) {
                    System.out.println("FAILED:  actual and expected parameters are different");
                    fail++;
                }
            }
        }
        System.out.println("Result: " + pass + " test - success and " + fail + " test - fail.");
    }

    private static void getInfoAboutClass (Class<TestWithCustomAnnotation> obj) {
        Field[] declaredFields = obj.getDeclaredFields();
        System.out.println("Class name: " + obj.getName());
        for (Field field : declaredFields) {
            Class fieldType = field.getType();
            System.out.println("Field name: " + field.getName() + "; type of field: " +fieldType.getName());
        }
    }
}
