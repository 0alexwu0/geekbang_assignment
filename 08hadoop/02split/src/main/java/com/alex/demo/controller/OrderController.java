package com.alex.demo.controller;

import com.alex.demo.dto.OrderDto;
import com.alex.demo.service.OrderService;
import com.alex.demo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Random rand = new Random();

        for(int i=0;i<1000;i++){
            OrderVo vo = new OrderVo();
            vo.setUserId(rand.nextInt(100));
            vo.setOrderSn(rand.nextInt(100)+"");
            vo.setAmount(rand.nextInt(100)+"");
            vo.setRemark(rand.nextInt(100)+"");
            vo.setCreatedAt(new Date());
            vo.setUpdatedAt(new Date());

            orderService.insertOrder(vo);
        }

        return "OK";
    }

    @RequestMapping("/lists")
    @ResponseBody
    public List<OrderDto> lists(@RequestBody OrderVo vo) {
        return orderService.queryOrderByUserId(vo.getUserId());
    }
}
