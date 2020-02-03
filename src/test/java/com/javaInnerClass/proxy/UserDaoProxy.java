package com.javaInnerClass.proxy;

public class UserDaoProxy implements UserDao {
    private UserDao target;

    public UserDaoProxy(UserDao target) {
        this.target = target;
    }

    @Override
    public boolean save(User user) {
        if(user.getName()==null||user.getName().length()==0){
            System.out.println("姓名为空，不保存");
        }
        if(user.getAge()<0||user.getAge()>150){
            System.out.println("年龄不再范围内，不保存");
        }
        return this.target.save(user);
    }

    @Override
    public boolean delete() {
        return false;
    }
}
