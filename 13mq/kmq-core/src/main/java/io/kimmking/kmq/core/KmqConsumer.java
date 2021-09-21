package io.kimmking.kmq.core;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;

public class KmqConsumer<T> {

    private final KmqBroker broker;

    private Kmq kmq;

    public KmqConsumer(KmqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public JSONArray poll(KmqMessage kmqMessage) {
        return kmq.poll(kmqMessage);
    }
}
