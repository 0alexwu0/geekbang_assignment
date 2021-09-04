package com.alex.demo.service;

public interface RedisService {

    boolean lock(String lockName);

    boolean unlock(String lockName);

    boolean checkLock();
}
