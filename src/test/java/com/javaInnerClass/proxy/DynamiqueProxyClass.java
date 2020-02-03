package com.javaInnerClass.proxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamiqueProxyClass implements InvocationHandler {
    private Object object;

    public DynamiqueProxyClass(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = method.invoke(this.object,args);
        return object;
    }
}
