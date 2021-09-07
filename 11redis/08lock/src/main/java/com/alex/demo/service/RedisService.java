package com.alex.demo.service;

import redis.clients.jedis.Jedis;

public interface RedisService {

    Jedis getRedisClient();

    boolean addStock(int stock);

    boolean useStock(int stock);

    String getStock();
}
