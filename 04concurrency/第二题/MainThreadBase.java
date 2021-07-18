package mythread;

public class MainThreadBase {
    private static int result;
    private static boolean isResult;

    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();

        //最基础的阻塞方式
        Thread myThread = new Thread(){
            @Override
            public void run() {
                result = sum();
                isResult = true;
            }
        };
        myThread.start();

        while(true){
            if(isResult){
                System.out.println("异步计算结果为："+result);
                System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
                break;
            }
        }
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