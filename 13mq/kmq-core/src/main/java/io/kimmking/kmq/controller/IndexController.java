package io.kimmking.kmq.controller;

import com.alibaba.fastjson.JSONArray;
import io.kimmking.kmq.core.*;
import io.kimmking.kmq.vo.KmqVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private KmqBroker broker;

    @RequestMapping(value = "/producer",method = RequestMethod.POST)
    @ResponseBody
    public String producer(@RequestBody KmqVo vo) {
        broker.createTopic(vo.getTopic());
        KmqProducer producer = broker.createProducer();
        producer.send(vo.getTopic(), new KmqMessage(null,vo.getMsg(),vo.getStart(),0));
        return "OK";
    }

    @RequestMapping(value = "/consumer",method = RequestMethod.POST)
    @ResponseBody
    public String consumer(@RequestBody KmqVo vo) {
        broker.createTopic(vo.getTopic());
        KmqConsumer consumer = broker.createConsumer();
        consumer.subscribe(vo.getTopic());
        JSONArray message = consumer.poll(new KmqMessage(null,null,vo.getStart(),vo.getSize()));
        return message.toString();
    }
}
