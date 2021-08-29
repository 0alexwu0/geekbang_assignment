package io.kimmking.rpcfx.client.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxyFactory {
    private Class cls;
    private InvocationHandler handle;

    public TestProxyFactory(Class cls, InvocationHandler handle) {
        this.cls = cls;
        this.handle = handle;
    }
    public Object createProxyObject(Class serviceClass) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{serviceClass}, handle);
    }
}
