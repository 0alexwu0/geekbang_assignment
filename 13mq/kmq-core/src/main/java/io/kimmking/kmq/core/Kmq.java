package io.kimmking.kmq.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Kmq {

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        //this.queue = new LinkedBlockingQueue(capacity);
        queue = new ArrayList<>();
    }

    private String topic;

    private int capacity;

    //private LinkedBlockingQueue<KmqMessage> queue;

    private ArrayList<KmqQueueItem> queue;

    public boolean send(KmqMessage message) {
        if(message.getStart() == 0){
            message.setStart(queue.size());
        }
        JSONObject body = (JSONObject) JSONObject.parseObject(message.getBody().toString());
        queue.add(message.getStart(), new KmqQueueItem(body.toString(),false));
        return true;
    }

    public JSONArray poll(KmqMessage message) {
        if( message.getSize() == 0){
            message.setSize(1);
        }

        JSONArray resList = new JSONArray();

        int index = 0;
        for(int i=0;i<message.getSize();i++){
            //i变量表示返回值长度，index变量表示已读取的数据长度，保证有数据跳过时判定queue不够的算法依然正常
            index++;
            if(queue.size() <= message.getStart() + index){
                return resList;
            }

            //检查是否被读取过，如果读取过就跳过本条
            KmqQueueItem item = queue.get(message.getStart()+index);
            if(item.isRead() == true){
                i--;
                continue;
            }
            JSONObject json = JSONObject.parseObject(item.getBody());
            resList.add(json);
            item.setRead(true);
            queue.set(message.getStart()+index,item);
        }

        return resList;
    }
}
