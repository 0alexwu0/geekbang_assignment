package com.alex.demo.service.impl;

import com.alex.demo.service.RedisService;
import org.redisson.Redisson;
import org.redisson.RedissonMap;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    private RedissonClient client;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    private RMap<String, String> rmap;

    public RedisServiceImpl(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+host+":"+port);

        client = Redisson.create(config);

        rmap = client.getMap("demo");
    }

    @Override
    public boolean lock(String lockName) {
        if(checkLock()){
            if(rmap.get("lock").equals(lockName)){
                return true;
            }else{
                return false;
            }
        }

        rmap.put("lock",lockName);

        return true;
    }

    @Override
    public boolean unlock(String lockName) {
        if(!checkLock()) {
            return false;
        }
        if(!rmap.get("lock").equals(lockName)){
            return false;
        }
        rmap.remove("lock");

        return true;
    }

    @Override
    public boolean checkLock() {
        if(!rmap.containsKey("lock")){
            return false;
        }
        return true;
    }
}
