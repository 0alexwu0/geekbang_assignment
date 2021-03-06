package com.alex.demo.service.impl;

import com.alex.demo.dto.OrderDto;
import com.alex.demo.mapping.OrderMapper;
import com.alex.demo.service.OrderService;
import com.alex.demo.utils.BeanConvertUtils;
import com.alex.demo.vo.OrderVo;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderDto> queryOrderByUserId(int userId){
        if(userId == 0){
            return new ArrayList<>();
        }

        return orderMapper.queryOrderByUserId(userId);
    }

    @ShardingTransactionType(value = TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertOrder(OrderVo vo){
        if(vo == null){
            return 0;
        }

        OrderDto dto = BeanConvertUtils.beanToBean(vo,OrderDto.class);
        return orderMapper.insertOrder(dto);
    }

    @ShardingTransactionType(value = TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insertOrderBatch(List<OrderVo> list) throws Exception {
        if(list == null || list.size() == 0){
            return 0;
        }

        List<OrderDto> dtoList = new ArrayList<>();
        for(OrderVo vo : list){
            dtoList.add(BeanConvertUtils.beanToBean(vo,OrderDto.class));
        }

        int ret = orderMapper.insertOrderBatch(dtoList);
        if(ret > 200){
            throw new Exception("rollback");
        }

        return ret;
    }
}
