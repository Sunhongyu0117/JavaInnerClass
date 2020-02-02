package com.javaInnerClass.innerClass;

import org.testng.annotations.Test;

/**
 * 静态内部类
 */
public class CalcMaxMin {

    public Pair cacl(int ... nums){
        int min = nums[0];
        int max = nums[0];
        for(int i : nums){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }
        return new Pair(min,max);
    }

    public static class Pair{
        private int min;
        private int max;

        public Pair(int min,int max){
            this.max = max;
            this.min = min;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

    @Test
    public void testStaticInnerClass() {
        int[] numbs ={-22,2,5,8,76,30};
        CalcMaxMin mm = new CalcMaxMin();
        Pair pair = mm.cacl(numbs);
        System.out.println(String.format("最大值为：%d ,最小值为：%d",pair.getMax(),pair.getMin() ));
    }
}
