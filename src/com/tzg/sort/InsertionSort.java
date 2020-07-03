package com.tzg.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] insertionSortArray = {3,2,4,6,5,9,-1,7,1,8};
        insertionSortReview(insertionSortArray);
        System.out.println(Arrays.toString(insertionSortArray));

    }

    public static void insertionSort(int[] ssa){
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < ssa.length; i++) {
            insertIndex = i-1;
            insertValue = ssa[i];
            while(insertIndex>=0 && insertValue<ssa[insertIndex]){
                ssa[insertIndex+1] = ssa[insertIndex];
                insertIndex--;
            }
            if (insertIndex+1!=i){
                ssa[insertIndex+1] = insertValue;
            }

        }
    }

    public static void insertionSortReview(int[] isa){
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < isa.length-1; i++) {
            insertValue = isa[i];
            insertIndex = i-1;
            while (insertIndex>=0 && insertValue<isa[insertIndex]){
                isa[insertIndex+1] = isa[insertIndex];
                insertIndex--;
            }
        if (insertIndex+1!=i){
            isa[insertIndex+1] = insertValue;
        }

        }
    }
}
