package com.tzg.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        //(f[k]-1) = (f[k-1]-1)+(f[k-2]-1)+1
        int[] fibonacciSearchArr={1,8, 10, 89, 1000, 1234};
        int res = fibonacciSearch(fibonacciSearchArr,1);
        System.out.println("Ë÷ÒýÎª£º"+res);
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
        int f[] = fibonacci();
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
                //×ó
                high = mid-1;
                k--;
            }else if (findVal>temp[mid]){
                //ÓÒ
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
}
