package com.alex.demo.service;

import com.alex.demo.dto.OrderDto;
import com.alex.demo.vo.OrderVo;

import java.util.List;

public interface OrderService {

    List<OrderDto> queryOrderByUserId(int userId);

    int insertOrder(OrderVo vo);

    int insertOrderBatch(List<OrderVo> list) throws Exception;
}
