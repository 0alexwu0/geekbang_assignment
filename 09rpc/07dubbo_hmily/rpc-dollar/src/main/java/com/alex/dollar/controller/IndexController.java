package com.alex.dollar.controller;

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

    @DubboReference(version = "1.0.0")
    private RmbService rmbService;

    @Autowired
    private DollarService dollarService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    @Transactional
    @HmilyTCC(confirmMethod="commit",cancelMethod="rollback")
    public String index(@RequestParam("m") double m) {

        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(1);
        dollarVo.setMoney(m);
        dollarService.subMoney(dollarVo);

        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(1);
        rmbVo.setMoney(m*7);
        rmbService.addMoney(rmbVo);

        return "OK";
    }

    @Transactional
    public void commit(DollarVo vo){
        System.out.println("OK:"+vo.getMoney());
    }

    private void rollback(double m){
        DollarVo dollarVo = new DollarVo();
        dollarVo.setUserId(1);
        dollarVo.setMoney(m);
        dollarService.addMoney(dollarVo);

        RmbVo rmbVo = new RmbVo();
        rmbVo.setUserId(1);
        rmbVo.setMoney(m*7);
        rmbService.subMoney(rmbVo);
    }
}
