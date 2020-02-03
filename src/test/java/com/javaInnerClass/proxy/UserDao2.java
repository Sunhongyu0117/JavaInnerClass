package com.javaInnerClass.proxy;

public class UserDao2 {
    public boolean save(User user) {
        System.out.println("UserDao2--save()..."+user.getName());
        return false;
    }

    public  boolean delete() {
        System.out.println("UserDao2--delete()...删除用户");
        return false;
    }
}
