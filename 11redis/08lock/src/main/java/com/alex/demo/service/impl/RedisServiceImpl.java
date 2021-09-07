package com.alex.demo.service.impl;

import com.alex.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisServiceImpl implements RedisService {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Override
    public Jedis getRedisClient() {
        Jedis jedis = new Jedis(host, Integer.parseInt(port));
        return jedis;
    }

    @Override
    public boolean addStock(int stock) {
        Jedis jedis = getRedisClient();
        jedis.incrBy("stock",stock);
        return true;
    }

    @Override
    public boolean useStock(int stock) {
        Jedis jedis = getRedisClient();
        if(Integer.parseInt(jedis.get("stock")) > stock){
            jedis.decrBy("stock",stock);
            return true;
        }
        return false;
    }

    @Override
    public String getStock() {
        Jedis jedis = getRedisClient();
        return jedis.get("stock");
    }
}
