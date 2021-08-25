package com.alex.dollar.service;

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
public class TransferServiceImpl implements TransferService {

    @DubboReference(version = "1.0.0")
    private RmbService rmbService;

    @Autowired
    private DollarService dollarService;

    @Override
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="rollback")
    public boolean transfer(int userId, double dollar, double rmb) {
        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(userId);
        dollarVo.setMoney(dollar);
        dollarService.subMoney(dollarVo);

        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(userId);
        rmbVo.setMoney(rmb);
        rmbService.addMoney(rmbVo);

        return true;
    }

    @Transactional
    public void commit(int userId, double dollar, double rmb){
        System.out.println("OK:"+rmb);
    }

    private void rollback(int userId, double dollar, double rmb){
        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(userId);
        dollarVo.setMoney(dollar);
        dollarService.addMoney(dollarVo);

        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(userId);
        rmbVo.setMoney(rmb);
        rmbService.subMoney(rmbVo);
    }
}
