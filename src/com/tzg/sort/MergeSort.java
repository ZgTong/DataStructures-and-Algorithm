package com.tzg.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int mergeSortArray[] = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int temp[] = new int[mergeSortArray.length];
        mergeSort(mergeSortArray,0,mergeSortArray.length-1,temp);
        System.out.println(Arrays.toString(mergeSortArray));
    }

    public static void mergeSort(int[] msa,int left, int right, int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            mergeSort(msa,left,mid,temp);
            mergeSort(msa,mid+1,right,temp);
            merge(msa,left,mid,right,temp);
        }
    }


    /**
     * 合并操作
     * @param msa  原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    public static void merge(int[] msa,int left,int mid ,int right,int[] temp){
        int l = left; //左边有序序列初始索引
        int r = mid+1; //右边有序序列初始索引
        int t = 0; //temp数组当前索引
        while(l<=mid&&r<=right){
            if (msa[l]<=msa[r]){
                temp[t]=msa[l];
                l++;
                t++;
            }else{
                temp[t]=msa[r];
                r++;
                t++;
            }
        }

        while(l<=mid){
            temp[t]= msa[l];
            l++;  
            t++;
        }
        while(r<=right){
            temp[t]= msa[r];
            r++;
            t++;
        }

        t= 0;
        int tempLeft = left;
        while(tempLeft<=right){
            msa[tempLeft]=temp[t];
            t++;
            tempLeft++;
        }
    }
}
