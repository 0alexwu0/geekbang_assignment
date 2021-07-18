package mythread;

public class MainRunnable {
    private static int result;

    public static void main(String[] args) throws InterruptedException {
        final long start=System.currentTimeMillis();

        //利用回调的方式拿到异步线程的结果，适用于主线程需要执行下去的情况
        new MyRunnable(){
            @Override
            public void callback(int result) {
                System.out.println("异步计算结果为："+result);
                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
            }
        }.run();
    }
}

abstract class MyRunnable implements Runnable {
    int result;

    @Override
    public void run() {
        result = sum();
        callback(result);
    }

    public abstract void callback(int result);


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