package com.javaInnerClass.innerClass;

import org.testng.annotations.Test;

public class ArraySequence {
    private Object[] data;
    private int next=0;

    public ArraySequence(int size){
        data = new Object[size];
    }

    public void add (Object object){
        if(next<data.length){
            data[next++]=object;
        }
    }

    //正序
    class SequenceSelector implements Selector{
        private int index;
        @Override
        public boolean end() {
            return index==data.length;
        }

        @Override
        public Object current() {
            if(index<data.length){
                return data [index];
            }
            return null;
        }

        @Override
        public void next() {
            if(index<data.length){
                index++;
            }
        }
    }
    //倒序
    class ReverseSequenceSelector implements Selector{
        private int index=data.length-1;
        @Override
        public boolean end() {
            return index<0;
        }

        @Override
        public Object current() {
            if(index>=0){
                return data [index];
            }
            return null;
        }

        @Override
        public void next() {
            if(index>=0){
                index--;
            }
        }
    }

    @Test
    public void testArraySequence() {
        ArraySequence as = new ArraySequence(5);
        as.add(1);
        as.add(33);
        as.add(-10);
        as.add(6);
        as.add(800);

        Selector selector = null;
        boolean flag= true;
        if(flag){
            selector=as.new SequenceSelector();
        }else{
            selector=as. new ReverseSequenceSelector();
        }
        while(!selector.end()){
            System.out.println(">>"+selector.current());
            selector.next();
        }
    }

    public static void main(String[] args) {
        ArraySequence as = new ArraySequence(5);
        as.add(1);
        as.add(33);
        as.add(-10);
        as.add(6);
        as.add(800);

        Selector selector = null;
        boolean flag= false;
        if(flag){
            selector=as.new SequenceSelector();
        }else{
            selector=as. new ReverseSequenceSelector();
        }
        while(!selector.end()){
            System.out.println(">>"+selector.current());
            selector.next();
        }
    }
}
