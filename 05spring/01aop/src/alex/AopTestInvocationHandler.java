package alex;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class AopTestInvocationHandler implements InvocationHandler {
    private Object obj;

    public AopTestInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " AOP "+new Date());

        Object result = method.invoke(obj, args);
        return result;
    }
}
