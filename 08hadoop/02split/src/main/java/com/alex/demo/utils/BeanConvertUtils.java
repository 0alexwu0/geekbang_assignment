package com.alex.demo.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * 集合对象转换
 */
public class BeanConvertUtils extends BeanUtils {

    public static <D, S> D beanToBean(S src, Class<D> distClass) {
        Object dist = null;

        try {
            dist = distClass.newInstance();
            BeanUtils.copyProperties(src, dist);
        } catch (IllegalAccessException | InstantiationException var4) {
            return null;
        }

        return (D) dist;
    }
}