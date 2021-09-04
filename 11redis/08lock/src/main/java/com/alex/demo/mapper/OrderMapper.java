package com.alex.demo.mapper;

import com.alex.demo.dto.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderDto> queryOrderByUserId(@Param("user_id") int userId);

    int insertOrder(OrderDto orderDto);

    int insertOrderBatch(List<OrderDto> list);
}
