package com.alex.demo.controller;

import com.alex.demo.service.QueueService;
import com.alex.demo.service.TopicService;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.Destination;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private QueueService queueService;

    @RequestMapping(value = "/topic",method = RequestMethod.GET)
    @ResponseBody
    public String topic(@RequestParam("msg") String msg) {
        Destination destination = new ActiveMQTopic("test.topic");
        topicService.sendMessage(destination,msg);
        return "OK";
    }

    @RequestMapping(value = "/queue",method = RequestMethod.GET)
    @ResponseBody
    public String queue(@RequestParam("msg") String msg) {
        Destination destination = new ActiveMQQueue("test.queue");
        queueService.sendMessage(destination,msg);
        return "OK";
    }
}
