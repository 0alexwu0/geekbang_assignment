package com.alex.dollar.controller;

import com.alex.core.service.DollarService;
import com.alex.core.service.RmbService;
import com.alex.core.vo.DollarVo;
import com.alex.core.vo.RmbVo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
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
}
