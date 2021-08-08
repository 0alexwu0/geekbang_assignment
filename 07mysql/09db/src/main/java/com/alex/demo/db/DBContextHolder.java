package com.alex.demo.db;

import java.util.concurrent.atomic.AtomicInteger;

public class DBContextHolder {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void write() {
        set(DBTypeEnum.WRITE);
        System.out.println("切换到WRITE");
    }

    public static void read() {
        set(DBTypeEnum.READ);
        System.out.println("切换到READ");
    }
}
