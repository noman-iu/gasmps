package com.gasmps.utils;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

/**
 *
 * @author akhtar
 *
 */

@Component
public class ReflectionUtility {

    /**
     * This Method is created to remove white space from all String field of any
     * Beans
     */
    public static void trimClassFields(Object inputObject) {
        try {
            Class<?> cls = inputObject.getClass();
            Field field[] = cls.getDeclaredFields();
            for (Field f : field) {
                f.setAccessible(true);
                if (f.getType().getSimpleName().equals("String")) {
                    if (f.get(inputObject) != null) {
                        f.set(inputObject, f.get(inputObject).toString().trim());
                    }
                }
            }
            System.err.println("Final " + inputObject);
        } catch (IllegalArgumentException | IllegalAccessException x) {
        }
    }
}
