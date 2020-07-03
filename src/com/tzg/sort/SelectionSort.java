package com.tzg.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] selectionSortArray = {3,2,4,6,5,9,-1,7,1,8};
        selectionSortReview(selectionSortArray);
        System.out.println(Arrays.toString(selectionSortArray));
    }
    public static void selectionSort(int[] ssa){
        int minValue = 0;
        int minIndex = 0;
        for (int j = 0; j < ssa.length-1; j++) {
            minValue = ssa[j];
            minIndex = j;
            for (int i = j+1; i < ssa.length; i++) {
                if (minValue>ssa[i]){
                    minIndex =  i;
                    minValue = ssa[i];
                }
            }
            if (minIndex!=j){
                ssa[minIndex] = ssa[j];
                ssa[j]= minValue;
            }
        }

    }

    public  static  void selectionSortReview(int[] ssa){
        for (int i = 0; i < ssa.length; i++) {
            int minVal = ssa[i];
            int minIndex = i;
            for (int j = 1+i; j <ssa.length ; j++) {
                if (minVal>ssa[j]){
                    minVal = ssa[j];
                    minIndex = j;
                }
            }
            ssa[minIndex] = ssa[i];
            ssa[i] = minVal;
        }

    }
}
