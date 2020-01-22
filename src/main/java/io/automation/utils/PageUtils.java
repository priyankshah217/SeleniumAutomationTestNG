package io.automation.utils;

import io.automation.base.BasePage;

import java.lang.reflect.InvocationTargetException;


public class PageUtils {
    public static <T extends BasePage> T getPage(Class<? extends BasePage> page) {
        T t = null;
        try {
            t = (T) page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return t;
    }
}
