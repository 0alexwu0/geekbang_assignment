package com.alex.demo.service;

import com.alex.demo.vo.OrderVo;
import redis.clients.jedis.Jedis;

public interface RedisService {

    Jedis getRedisClient();

    boolean addStock(int stock);

    boolean useStock(int stock);

    String getStock();

    boolean publishOrder(OrderVo vo);

    boolean subscribeOrder();
}
