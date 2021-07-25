package alex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Class cls;
    private InvocationHandler handle;

    public ProxyFactory(String className, InvocationHandler handle) {
        try {
            cls = Class.forName(className);
            this.handle = handle;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Object createProxyObject() {
        return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handle);
    }
}
