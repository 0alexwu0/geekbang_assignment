package com.alex.rmb.mapper;

import com.alex.core.dto.WalletRmbDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WalletRmbMapper {

    WalletRmbDto findWalletByUserId(@Param("userId") int userId);

    int updateWallet(WalletRmbDto dto);
}
