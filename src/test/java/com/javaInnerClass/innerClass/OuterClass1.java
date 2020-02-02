package com.javaInnerClass.innerClass;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 局部内部类
 */
public class OuterClass1 {
    private String name;
    private Integer index;

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    //局部内部类打印方法
    public void printName(){
        //定义局部内部类
         class InnerClass{
            private String name ;
            public void setName(String name) {
                this.name = name;
            }
            public void printName(){
                System.out.println(name);
                System.out.println("我是外围类Name:"+ OuterClass1.this.name);
                System.out.println("我是外围类Index:"+ OuterClass1.this.index);
            }
        }
       //直接在方法中实例化内部类，并赋值和调用。
       InnerClass ic= new InnerClass();
       ic.setName("我是内部类");
       ic.printName();
    }

    //实现接口的匿名内部类打印
    public void anonymousPrintInfo(){
        new PrintInterface(){
            private String name="我是实现接口的匿名内部类";
            @Override
            public void printInfo() {
                System.out.println("我是外围类Name："+OuterClass1.this.name);
                System.out.println("我是外围类Index:"+OuterClass1.this.index);
                System.out.println(name);
            }
        }.printInfo();

    }

    // 实现抽象类的匿名内部类打印
    public void abstractClassPrintInfo(){
        new PrintAbstractClass("我是构造器参数"){
            private String name="我是继承抽象类的匿名内部类";
            @Override
            public void printInfo() {
                System.out.println("我是外围类Name："+OuterClass1.this.name);
                System.out.println("我是外围类Index:"+OuterClass1.this.index);
                System.out.println(name);
                System.out.println(super.flName);
            }
        }.printInfo();
    }



    @Test
    public void testNewInnerClass() {
        OuterClass1 oc = new OuterClass1();
        oc.setIndex(1);
        oc.setName("我是外围类");
        //局部内部类打印
        oc.printName();
        System.out.println("=================================");
        //实现接口的匿名内部类打印
        oc.anonymousPrintInfo();
        System.out.println("=================================");
        //继承抽象类的匿名内部类打印
        oc.abstractClassPrintInfo();
    }

    //双括号初始化--原理：初始化代码块
    @Test
    public void testTwoBracketsInit() {
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };

        System.out.println("list"+list);
    }
}
