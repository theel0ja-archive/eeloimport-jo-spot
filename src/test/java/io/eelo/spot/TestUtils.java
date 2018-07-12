package io.eelo.spot;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestUtils {


    public static Object accessToPrivateMethod(Object object, String methodName, Object... params) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                try {
                    method.setAccessible(true);
                    return method.invoke(object, params);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new RuntimeException();
    }

    public static Object accessToPrivateField(Object from, String name, Object newValue) throws Exception {
        final Field field = from.getClass().getDeclaredField(name);
        field.setAccessible(true);
        final Object oldValue = field.get(from);
        if (newValue != null) {
            field.set(from, newValue);
        }
        return oldValue;
    }

}
