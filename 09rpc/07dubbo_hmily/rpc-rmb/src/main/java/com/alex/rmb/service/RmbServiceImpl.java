package com.alex.rmb.service;

import com.alex.core.dto.WalletRmbDto;
import com.alex.core.dto.WalletRmbLogsDto;
import com.alex.core.service.RmbService;
import com.alex.core.vo.DollarVo;
import com.alex.core.vo.RmbVo;
import com.alex.rmb.mapper.WalletRmbLogsMapper;
import com.alex.rmb.mapper.WalletRmbMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.transaction.annotation.Transactional;

@Service
@DubboService(version = "1.0.0", tag = "red", weight = 100)
public class RmbServiceImpl implements RmbService {

    @Autowired
    private WalletRmbMapper walletRmbMapper;

    @Autowired
    private WalletRmbLogsMapper walletRmbLogsMapper;

    @Override
    public WalletRmbDto subMoney(RmbVo vo) {
        if(vo == null){
            return null;
        }

        WalletRmbDto dto = walletRmbMapper.findWalletByUserId(vo.getUserId());
        dto.setMoney(dto.getMoney() - vo.getMoney());
        dto.setUpdatedAt(new Date());

        WalletRmbLogsDto logDto = new WalletRmbLogsDto();
        logDto.setUserId(dto.getUserId());
        logDto.setMoney(dto.getMoney());
        logDto.setCreatedAt(new Date());
        walletRmbLogsMapper.insertLog(logDto);

        walletRmbMapper.updateWallet(dto);
        return dto;
    }

    @Override
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="subMoney")
    public WalletRmbDto addMoney(RmbVo vo) {
        if(vo == null){
            return null;
        }

        WalletRmbDto dto = walletRmbMapper.findWalletByUserId(vo.getUserId());
        dto.setMoney(dto.getMoney() + vo.getMoney());
        dto.setUpdatedAt(new Date());

        WalletRmbLogsDto logDto = new WalletRmbLogsDto();
        logDto.setUserId(dto.getUserId());
        logDto.setMoney(dto.getMoney());
        logDto.setCreatedAt(new Date());
        walletRmbLogsMapper.insertLog(logDto);

        walletRmbMapper.updateWallet(dto);
        return dto;
    }
}
