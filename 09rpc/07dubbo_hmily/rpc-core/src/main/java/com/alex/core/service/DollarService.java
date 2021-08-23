package com.alex.core.service;

import com.alex.core.dto.WalletDollarDto;
import com.alex.core.vo.DollarVo;

public interface DollarService {

    WalletDollarDto subMoney(DollarVo vo);

    WalletDollarDto addMoney(DollarVo vo);
}
