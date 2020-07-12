package com.tzg.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        //(f[k]-1) = (f[k-1]-1)+(f[k-2]-1)+1
        int[] fibonacciSearchArr={1,8, 10, 89, 1000, 1234};
        int res = fibonacciSearchReview(fibonacciSearchArr,1);
        System.out.println("索引为："+res);
    }

    public static  int[] fibonacci(){
        int[] f = new int[maxSize];
        f[0]=1;
        f[1]=2;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }

    public  static int fibonacciSearch(int[] fsa,int findVal){
        int low = 0;
        int high = fsa.length-1; //5
        int f[] = fibonacci();// [1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765]
        int mid =0;
        int k =0;

        while (high>f[k]-1){ //k=5 f[k]=8
            k++;
        }

        int temp[] = Arrays.copyOf(fsa,f[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i]=fsa[high]; //{1,8, 10, 89, 1000, 1234,1234,1234}
        }


        while (low<=high){
            mid = low+f[k-1]-1;
            if (findVal<temp[mid]){
                //左
                high = mid-1;
                k--;
            }else if (findVal>temp[mid]){
                //右
                low = mid+1;
                k-=2;
            }else{
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

    public static  int[] fibonacciReview(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    public static int fibonacciSearchReview(int[] fsa, int findVal){
        int low = 0;
        int high = fsa.length-1;
        int mid = 0;
        int[] f = fibonacciReview();
        int k = 0; //斐波那契数列下标指针
        while (high > f[k]-1){
            k++;
        }
        int[] temp = Arrays.copyOf(fsa,f[k]);
        for (int i = high+1; i < temp.length; i++) {
            temp[i]=fsa[high];
        }

        while(low<=high){
            mid = low+f[k-1]-1;
            if (findVal<temp[mid]){
                high = mid-1;
                k--;
            }else if (findVal>temp[mid]){
                low = mid+1;
                k-=2;
            }else{
                if (mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
