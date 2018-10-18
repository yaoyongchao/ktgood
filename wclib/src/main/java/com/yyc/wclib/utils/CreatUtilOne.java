package com.yyc.wclib.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Author: Austin
 * Time: 2018/7/18
 * Description:
 */

public class CreatUtilOne {
    /**
     * 获取T类型然后自动new出对象
     * @param o
     * @param i
     * @param <T>
     * @return
     */
    public static <T> T getT(Object o, int i) {

        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
