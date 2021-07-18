package mythread;

import java.util.concurrent.CountDownLatch;

public class MainCountDownLatch {
    private static int result;

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        //使用计数器阻塞方式，适用于多线程处理但是后续代码必须等线程处理完毕的情况

        final CountDownLatch count = new CountDownLatch(1);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                result = sum();
                count.countDown();
            }
        };
        myThread.start();

        count.await();

        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
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