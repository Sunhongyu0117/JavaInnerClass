package com.javaInnerClass.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User user) {
        System.out.println("UserDaoImpl--save()..."+user.getName());
        return false;
    }

    @Override
    public boolean delete() {
        System.out.println("UserDaoImpl--delete()...删除用户");
        return false;
    }
}
