package com.alex.core.utils;

import org.springframework.beans.BeanUtils;

public class BeanConvertUtils {

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
