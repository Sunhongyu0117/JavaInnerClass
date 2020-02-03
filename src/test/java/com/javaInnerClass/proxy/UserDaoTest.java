package com.javaInnerClass.proxy;

import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class UserDaoTest {
    @Test
    //静态代理
    public void testStaticProxy() {
        User user = new User("用户1",55);
        UserDao userDao = new UserDaoImpl();
        UserDaoProxy daoProxy = new UserDaoProxy(userDao);
        daoProxy.save(user);
    }

    //动态代理
    @Test
    public void testDynamiqueProxy() {
        User user = new User("用户2",33);
        UserDao userDao = new UserDaoImpl();
        DynamiqueProxyClass dyClass = new DynamiqueProxyClass(userDao);
        UserDao proxy=(UserDao) Proxy.newProxyInstance(
                userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                dyClass
        );
        proxy.save(user);
        proxy.delete();

    }

    @Test
    public void testCglibProxy() {
        User user = new User("用户3",24);
        UserDao2 userDao = new UserDao2();
        UserDao2 proxy = (UserDao2) new CglibProxy(userDao).getProxyInstance();
        proxy.save(user);
        proxy.delete();
    }
}
