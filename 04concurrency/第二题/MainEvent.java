package mythread;


import java.util.ArrayList;
import java.util.EventListener;
import java.util.EventObject;
import java.util.List;

public class MainEvent {
    private static int result;
    final long start = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {
        final MyData data = new MyData();
        data.start = System.currentTimeMillis();

        //使用监听的方式异步拿到线程的结果，适用于异步的情况，并且需要通过监听的方式在指定的位置监听结果的情况

        final MyEventSource eventSource = new MyEventSource();
        MyListener listener = new MyListener();

        eventSource.addServerUpdateEventListener(listener);
        new Runnable(){

            @Override
            public void run() {
                data.result = sum();
                MyEvent event = new MyEvent(data);
                eventSource.sendEvent(event);
            }
        }.run();
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if( a < 2){
            return 1;
        }
        return fibo(a-1) + fibo(a-2);
    }
}

class MyListener implements MyEventListenerInterface {

    @Override
    public void handleEvent(MyEvent event) {
        System.out.println("异步计算结果为：" + event.getObj().result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - event.getObj().start) + " ms");
    }
}

class MyEvent extends EventObject {
    private MyData data;

    public MyEvent(MyData source) {
        super(source);
        data = source;
    }

    public MyData getObj() {
        return data;
    }
}

class MyData{
    public long start;
    public int result;
}

interface MyEventListenerInterface extends EventListener {
    void handleEvent(MyEvent serverUpdateEvent);
}

class MyEventSource {

    private static List<MyEventListenerInterface> listeners = new ArrayList<MyEventListenerInterface>();

    public MyEventSource() {

    }

    public void addServerUpdateEventListener(MyEventListenerInterface e) {
        listeners.add(e);
    }

    public void deleteServerUpdateEventListener(MyEventListenerInterface e) {
        listeners.remove(e);
    }

    public void sendEvent(MyEvent event) {
        for (MyEventListenerInterface listener : listeners) {
            listener.handleEvent(event);
        }
    }
}

