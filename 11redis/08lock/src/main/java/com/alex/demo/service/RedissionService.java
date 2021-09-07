package com.alex.demo.service;

public interface RedissionService {

    boolean lock(String lockName);

    boolean unlock(String lockName);

    boolean checkLock(String lockName);
}
