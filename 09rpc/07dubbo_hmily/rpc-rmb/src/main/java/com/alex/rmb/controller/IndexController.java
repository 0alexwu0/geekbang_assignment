package com.alex.rmb.controller;

import com.alex.rmb.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @ResponseBody
    public String index(@RequestParam("m") double m) {
        transferService.transfer(1,m,m/7);
        return "OK";
    }
}
