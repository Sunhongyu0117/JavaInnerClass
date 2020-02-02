package com.javaInnerClass.innerClass;

import org.testng.annotations.Test;

/**
 * 定义内部类
 */
public class OuterClass {
    private String name;
    private Integer index;

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void printName(){
        System.out.println(name);
    }

    public InnerClass createInnerClass(){
        return new InnerClass();
    }

    public class InnerClass{
        private String name ;

        public void setName(String name) {
            this.name = name;
        }

        public void printName(){
            System.out.println(name);
            System.out.println("我是外围类Name:"+OuterClass.this.name);
            System.out.println("我是外围类Index:"+OuterClass.this.index);
        }
    }

    @Test
    public void testNewInnerClass() {
        OuterClass oc = new OuterClass();
        oc.setIndex(1);
        oc.setName("我是外围类");
        oc.printName();
        //通过 外部类对象名.new 内部类名(); 格式创建内部类对象
        System.out.println("===================================");
        OuterClass.InnerClass innerClass = oc.new InnerClass();
        innerClass.setName("我是通过外部类直接New的内部类");
        innerClass.printName();
        System.out.println("===================================");
        // public InnerClass createInnerClass(){
        //  return new InnerClass();
        // }
        //通过在外部类中定义创建内部类方法后，调用方法创建内部类对象
        OuterClass.InnerClass innerClass1 = oc.createInnerClass();
        innerClass1.setName("我是通过外部类的方法创建的内部类");
        innerClass1.printName();
    }

}
