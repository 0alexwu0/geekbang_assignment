package com.alex.rmb.mapper;

import com.alex.core.dto.WalletRmbLogsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletRmbLogsMapper {

    int insertLog(WalletRmbLogsDto dto);
}
