package com.alex.demo.service.impl;

import com.alex.demo.service.RedissionService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedissionServiceImpl implements RedissionService {

    private RedissonClient client;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    private void init(){
        if(client == null){
            Config config = new Config();
            config.useSingleServer().setAddress("redis://"+host+":"+port);
            client = Redisson.create(config);
        }
    }

    @Override
    public boolean lock(String lockName) {
        if(checkLock(lockName)){
            return false;
        }
        RLock lock = client.getLock(lockName);
        lock.lock();

        return true;
    }

    @Override
    public boolean unlock(String lockName) {
        if(!checkLock(lockName)) {
            return false;
        }
        RLock lock = client.getLock(lockName);
        lock.unlock();

        return true;
    }

    @Override
    public boolean checkLock(String lockName) {
        init();
        RLock lock = client.getLock(lockName);
        if(lock.isLocked()){
            return true;
        }
        return false;
    }
}
