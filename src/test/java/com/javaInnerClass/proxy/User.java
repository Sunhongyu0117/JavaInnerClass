package com.javaInnerClass.proxy;


public class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：");
        if(name!=null&&name.length()>0){
            sb.append(name);
        }
        sb.append(",年龄：");
        if(age>0&&age<150){
            sb.append(age);
        }
        return sb.toString();
    }
}
