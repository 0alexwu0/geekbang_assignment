package com.alex.rmb.service;

import com.alex.core.service.DollarService;
import com.alex.core.service.RmbService;
import com.alex.core.vo.DollarVo;
import com.alex.core.vo.RmbVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private RmbService rmbService;

    @DubboReference(version = "1.0.0")
    private DollarService dollarService;

    @Override
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="addMoney")
    public boolean transfer(int userId, double rmb, double dollar) {
        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(userId);
        rmbVo.setMoney(rmb);
        rmbService.subMoney(rmbVo);

        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(userId);
        dollarVo.setMoney(dollar);
        dollarService.addMoney(dollarVo);

        return true;
    }

    @Transactional
    public void commit(int userId, double rmb, double dollar){
        System.out.println("OK:"+dollar);
    }

    public void rollback(int userId, double rmb, double dollar) {
        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(userId);
        rmbVo.setMoney(rmb);
        rmbService.addMoney(rmbVo);

        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(userId);
        dollarVo.setMoney(dollar);
        dollarService.subMoney(dollarVo);
    }
}
