package com.javaInnerClass.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }
    public Object getProxyInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 拦截--START");
        boolean flag = true;
        if(target instanceof UserDao2 && method.getName().indexOf("save")!=-1){
            User user = (User) objects[0];
            if(user.getName()==null||user.getName().length()==0){
                System.out.println("姓名为空，不能保存");
                flag=false;
            }
            if(user.getAge()<0||user.getAge()>150){
                System.out.println("年龄不在范围内，不能保存");
                flag=false;
            }
        }
        Object object = null;
        if(flag){
            object = method.invoke(target,objects);
        }
        System.out.println("cglib 拦截--END");
        return object;
    }
}
