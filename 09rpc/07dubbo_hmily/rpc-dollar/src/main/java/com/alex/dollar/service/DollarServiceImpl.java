package com.alex.dollar.service;

import com.alex.core.dto.WalletDollarDto;
import com.alex.core.dto.WalletDollarLogsDto;
import com.alex.core.service.DollarService;
import com.alex.core.vo.DollarVo;
import com.alex.dollar.mapper.WalletDollarLogsMapper;
import com.alex.dollar.mapper.WalletDollarMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@DubboService(version = "1.0.0", tag = "red", weight = 100)
public class DollarServiceImpl implements DollarService {

    @Autowired
    private WalletDollarMapper walletDollarMapper;

    @Autowired
    private WalletDollarLogsMapper walletDollarLogsMapper;

    @Transactional
    public void commit(DollarVo vo){
        System.out.println("OK:"+vo.getMoney());
    }

    @Override
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="addMoney")
    public WalletDollarDto subMoney(DollarVo vo){
        if(vo == null){
            return null;
        }

        WalletDollarDto dto = walletDollarMapper.findWalletByUserId(vo.getUserId());
        dto.setMoney(dto.getMoney() - vo.getMoney());
        dto.setUpdatedAt(new Date());

        WalletDollarLogsDto logDto = new WalletDollarLogsDto();
        logDto.setUserId(dto.getUserId());
        logDto.setMoney(dto.getMoney());
        logDto.setCreatedAt(new Date());
        walletDollarLogsMapper.insertLog(logDto);

        walletDollarMapper.updateWallet(dto);
        return dto;
    }

    @Override
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="subMoney")
    public WalletDollarDto addMoney(DollarVo vo){
        if(vo == null){
            return null;
        }

        WalletDollarDto dto = walletDollarMapper.findWalletByUserId(vo.getUserId());
        dto.setMoney(dto.getMoney() + vo.getMoney());
        dto.setUpdatedAt(new Date());

        WalletDollarLogsDto logDto = new WalletDollarLogsDto();
        logDto.setUserId(dto.getUserId());
        logDto.setMoney(dto.getMoney());
        logDto.setCreatedAt(new Date());
        walletDollarLogsMapper.insertLog(logDto);

        walletDollarMapper.updateWallet(dto);
        return dto;
    }
}
