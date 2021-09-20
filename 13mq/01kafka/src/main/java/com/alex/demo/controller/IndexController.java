package com.alex.demo.controller;

import com.alex.demo.service.ConsumerService;
import com.alex.demo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/producer",method = RequestMethod.GET)
    @ResponseBody
    public String producer(@RequestParam("msg") String msg) {
        producerService.send(msg);
        return "OK";
    }

    @RequestMapping(value = "/consumer",method = RequestMethod.GET)
    @ResponseBody
    public String consumer(@RequestParam("msg") String msg) {

        return "OK";
    }
}
