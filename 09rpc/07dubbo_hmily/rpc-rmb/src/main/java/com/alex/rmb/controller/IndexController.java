package com.alex.rmb.controller;

import com.alex.core.service.DollarService;
import com.alex.core.service.RmbService;
import com.alex.core.vo.DollarVo;
import com.alex.core.vo.RmbVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RmbService rmbService;

    @DubboReference(version = "1.0.0")
    private DollarService dollarService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="addMoney")
    public String index(@RequestParam("m") double m) {

        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(1);
        rmbVo.setMoney(m);
        rmbService.subMoney(rmbVo);

        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(1);
        dollarVo.setMoney(m/7);
        dollarService.addMoney(dollarVo);

        return "OK";
    }

    @Transactional
    public void commit(DollarVo vo){
        System.out.println("OK:"+vo.getMoney());
    }

    public void rollback(double m) {
        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(1);
        rmbVo.setMoney(m);
        rmbService.addMoney(rmbVo);

        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(1);
        dollarVo.setMoney(m/7);
        dollarService.subMoney(dollarVo);
    }
}
