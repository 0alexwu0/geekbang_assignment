package com.alex.demo.controller;

import com.alex.demo.dto.OrderDto;
import com.alex.demo.service.OrderService;
import com.alex.demo.service.RedisService;
import com.alex.demo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    public String save(@RequestParam("num") int num) {
        Random rand = new Random();
        List<OrderVo> list = new ArrayList<>();

        if(!redisService.lock("m_save")){
            return "lock error";
        }

        for(int i=0;i<num;i++){
            OrderVo vo = new OrderVo();
            vo.setUserId(rand.nextInt(100));
            vo.setOrderSn(rand.nextInt(100)+"");
            vo.setAmount(rand.nextInt(100)+"");
            vo.setRemark(rand.nextInt(100)+"");
            vo.setCreatedAt(new Date());
            vo.setUpdatedAt(new Date());
            list.add(vo);
        }

        try {
            orderService.insertOrderBatch(list);
        } catch (Exception e) {
            return "rollback";
        }

        redisService.unlock("m_save");

        return "OK";
    }

    @RequestMapping("/lists")
    @ResponseBody
    public List<OrderDto> lists(@RequestBody OrderVo vo) {
        return orderService.queryOrderByUserId(vo.getUserId());
    }

    @RequestMapping("/lock")
    @ResponseBody
    public String lock(@RequestParam("lock") String name) {
        if(!redisService.lock(name)){
            return "lock error";
        }

        return "lock OK";
    }

    @RequestMapping("/unlock")
    @ResponseBody
    public String unlock(@RequestParam("lock") String name) {
        if(!redisService.unlock(name)){
            return "unlock error";
        }

        return "unlock OK";
    }
}
