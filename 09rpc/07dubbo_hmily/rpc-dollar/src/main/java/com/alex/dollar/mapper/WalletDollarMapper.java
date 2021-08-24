package com.alex.dollar.mapper;

import com.alex.core.dto.WalletDollarDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WalletDollarMapper {

    WalletDollarDto findWalletByUserId(@Param("userId") int userId);

    int updateWallet(WalletDollarDto dto);
}
