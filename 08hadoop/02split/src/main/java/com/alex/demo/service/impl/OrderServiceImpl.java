package com.alex.demo.service.impl;

import com.alex.demo.dto.OrderDto;
import com.alex.demo.mapping.OrderMapper;
import com.alex.demo.service.OrderService;
import com.alex.demo.utils.BeanConvertUtils;
import com.alex.demo.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> queryOrderByUserId(String userId){
        if(StringUtils.isBlank(userId)){
            return new ArrayList<>();
        }

        return orderMapper.queryOrderByUserId(userId);
    }

    @Override
    public int insertOrder(OrderVo vo){
        if(vo == null){
            return 0;
        }

        OrderDto dto = BeanConvertUtils.beanToBean(vo,OrderDto.class);
        return orderMapper.insertOrder(dto);
    }

    @Override
    public int insertOrderBatch(List<OrderVo> list){
        if(list == null || list.size() == 0){
            return 0;
        }

        List<OrderDto> dtoList = new ArrayList<>();
        for(OrderVo vo : list){
            dtoList.add(BeanConvertUtils.beanToBean(vo,OrderDto.class));
        }

        return orderMapper.insertOrderBatch(dtoList);
    }
}
