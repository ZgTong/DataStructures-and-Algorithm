package com.tzg.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        test01(5);
        int res = factorial(5);
        System.out.println(res);
    }

    public static void test01(int val){
        if (val>2){
            test01(val-1);
        }
        System.out.println("当前值为："+val);
    }

    //阶乘
    public static int  factorial(int val){
        if (val == 1){
            return 1 ;
        }else {
            return  factorial(val-1)*val;
        }
    }
}
