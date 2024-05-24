package interview.core_java_concept.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        Class<?> clazz = MyClass.class;

        // Get all declared methods
        System.out.println("Declared Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        // Invoke publicMethod dynamically
        Method publicMethod = clazz.getMethod("publicMethod");
        publicMethod.invoke(new MyClass());

        // Get and set privateField dynamically
        Field privateField = clazz.getDeclaredField("privateField");
        privateField.setAccessible(true);
        MyClass obj = new MyClass();
        privateField.setInt(obj, 42);
        System.out.println(STR."Private field value: \{privateField.getInt(obj)}");
    }
}
