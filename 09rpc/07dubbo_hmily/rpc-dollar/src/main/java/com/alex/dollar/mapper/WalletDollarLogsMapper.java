package com.alex.dollar.mapper;

import com.alex.core.dto.WalletDollarLogsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletDollarLogsMapper {

    int insertLog(WalletDollarLogsDto dto);
}
