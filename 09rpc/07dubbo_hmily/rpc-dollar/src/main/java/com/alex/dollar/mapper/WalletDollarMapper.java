package com.alex.dollar.mapper;

import com.alex.core.dto.WalletDollarDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WalletDollarMapper {

    WalletDollarDto findWalletByUserId(@Param("user_id") int userId);

    int updateWallet(WalletDollarDto dto);
}
