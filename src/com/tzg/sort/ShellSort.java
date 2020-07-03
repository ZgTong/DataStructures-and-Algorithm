package com.tzg.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] shellSortArray  = {3,2,4,6,5,9,-1,7,1,8};
//        shellSortExchangeReview(shellSortArray);
        shellSortDisplaceReview(shellSortArray);
        System.out.println(Arrays.toString(shellSortArray));
    }
    public static void shellSortExchange(int[] ssa){
        int temp = 0;
        for (int gap = ssa.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i < ssa.length; i++) {
                for (int j = i-gap; j >=0; j-=gap) {
                    if (ssa[j]>ssa[j+gap]){
                        temp = ssa[j];
                        ssa[j] = ssa[j+gap];
                        ssa[j+gap]=temp;
                    }
                }
            }
        }
    }

    public static void shellSortExchangeReview(int[] ssa){
        int temp = 0;
        for (int gap = ssa.length/2; gap >0 ; gap/=2) {
            for (int i = gap; i <ssa.length ; i++) {
                for (int j = i-gap; j >=0 ; j-=gap) {
                    if (ssa[j]>ssa[j+gap]){
                        temp = ssa[j];
                        ssa[j] = ssa[j+gap];
                        ssa[j+gap]= temp;
                    }
                }
            }
        }

    }

    public static void shellSortDisplace(int[] ssa){
        for (int gap = ssa.length/2 ; gap >0 ; gap/=2) {
            for (int i = gap; i < ssa.length; i++) {

                int insertIndex = i;
                int insertVal = ssa[insertIndex];
                if (ssa[insertIndex]<ssa[insertIndex-gap]){
                    while (insertIndex-gap>=0&&insertVal<ssa[insertIndex-gap]){
                        ssa[insertIndex] = ssa[insertIndex-gap];
                        insertIndex-=gap;
                    }
                    ssa[insertIndex] = insertVal;
                }
            }
        }
    }

    public static void shellSortDisplaceReview(int[] ssa){
        for (int gap = ssa.length/2; gap >0; gap/=2) {
            for (int i = gap; i <ssa.length ; i++) {
                int insertIndex = i;
                int insertVal = ssa[insertIndex];
                if (ssa[insertIndex]<ssa[insertIndex-gap]){
                    while (insertIndex-gap>=0&&insertVal<ssa[insertIndex-gap]){
                        ssa[insertIndex]=ssa[insertIndex-gap];
                        insertIndex-=gap;
                    }
                    ssa[insertIndex] = insertVal;
                }
            }
        }
    }
}
