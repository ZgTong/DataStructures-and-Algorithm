package com.tzg.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] bubbleSortArray = {3,2,4,6,5,9,7,1,8};
        bubbleSort(bubbleSortArray);
        System.out.println(Arrays.toString(bubbleSortArray));
    }

    public static void bubbleSort(int[] arr){
        int temp = 0;
        boolean flag = false;
        for (int j = 0; j < arr.length-1; j++) {
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i]>arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            if (!flag){
                break;
            }else{
                flag = false;
            }
        }

    }
}
