package com.alex.demo.service;

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    @JmsListener(destination = "test.topic",containerFactory = "topicListenerContainerFactory")
    public void receiveTopic(String text) {
        System.out.println("topic收到的报文为:"+text);
    }

    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }
}
