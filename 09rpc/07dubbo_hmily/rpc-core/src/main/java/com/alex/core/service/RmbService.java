package com.alex.core.service;

import com.alex.core.dto.WalletRmbDto;
import com.alex.core.vo.RmbVo;

public interface RmbService {

    WalletRmbDto subMoney(RmbVo vo);

    WalletRmbDto addMoney(RmbVo vo);
}
