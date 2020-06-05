package com.tzg.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int radixSortArray[] = { 53, 3, 542, 748, 14, 214};
        radixSort(radixSortArray);
        System.out.println(Arrays.toString(radixSortArray));
    }

    public static void radixSort(int[] rsa){
        int max = rsa[0];
        for (int i = 0; i < rsa.length; i++) {
            if (rsa[i]>max){
                max = rsa[i];
            }
        }
        int maxLength = (max+"").length();

        int[][] bucket = new int[10][rsa.length];

        int[] bucketElementCount = new int[10];
        for (int i = 0, n =1; i < maxLength; i++,n*=10) {


            for (int j = 0; j <rsa.length ; j++) {
                int digitOfElement = rsa[j]/n%10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = rsa[j];
                bucketElementCount[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCount.length; k++) {
                if (bucketElementCount[k]!=0){
                    for (int l = 0; l < bucketElementCount[k]; l++) {
                         rsa[index++]=bucket[k][l];
                    }
                }
                bucketElementCount[k]=0;
            }
        }
    }
}
