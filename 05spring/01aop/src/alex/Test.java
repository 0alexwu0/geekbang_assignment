package alex;

import java.lang.reflect.InvocationHandler;

public class Test {

    public static void main(String args[]) {
        AopTest test = new AopTestImpl();
        InvocationHandler handler = new AopTestInvocationHandler(test);
        ProxyFactory proxyFactory = new ProxyFactory(AopTestImpl.class.getName(), handler);
        AopTest speakProxy = (AopTest) proxyFactory.createProxyObject();
        speakProxy.test();
    }
}
