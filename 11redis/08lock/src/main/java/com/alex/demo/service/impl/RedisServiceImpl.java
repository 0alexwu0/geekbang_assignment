package com.alex.demo.service.impl;

import com.alex.demo.service.OrderService;
import com.alex.demo.service.RedisService;
import com.alex.demo.vo.OrderVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.JedisPubSub;

@Service
public class RedisServiceImpl implements RedisService {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Autowired
    private OrderService orderService;

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

    @Override
    public boolean publishOrder(OrderVo vo) {
        Jedis jedis = getRedisClient();
        jedis.publish("order",JSON.toJSONString(vo));
        return true;
    }

    @Override
    public boolean subscribeOrder() {
        Jedis jedis = getRedisClient();
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                if(channel.equals("order")){
                    OrderVo vo = JSON.parseObject(message, OrderVo.class);
                    orderService.insertOrder(vo);
                }
            }
        },"order");

        return true;
    }
}
