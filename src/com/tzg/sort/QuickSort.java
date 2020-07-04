package com.tzg.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] quickSortArray = {9,78,0,23,567,70, 1,900, 4561};//9
        quickSortReview(quickSortArray,0,quickSortArray.length-1);
        System.out.println(Arrays.toString(quickSortArray));
    }

    public static void quickSort(int[] qsa,int left,int right){
        if(qsa==null||qsa.length==0||qsa.length==1){
            return;
        }
        if (left>right){
            return;
        }
        int base = qsa[left];
        int l = left;
        int r = right;
        int temp = 0;
        //{9,78,0,23,567,70, 1,900, 4561}
        //{9,1,0,23,567,70, 78,900, 4561}
        while (l!=r){
            while (qsa[r]>=base&&l<r){
                r--;//6 2
            }
            while (qsa[l]<=base&&l<r){
                l++;//2 2
            }
            if (l<r){
                temp = qsa[l];//==0 1
                qsa[l]=qsa[r];//==1 0
                qsa[r]=temp;//0
            }
        }
        qsa[left]=qsa[l];
        qsa[l]= base;
        quickSort(qsa,left,l-1);
        quickSort(qsa,r+1,right);
    }


    public static void quickSortReview(int[] qsa,int left,int right){
        if (qsa==null||qsa.length==0|qsa.length==1){ return; }
        if (left>right){return;}
        int l = left;
        int r = right;
        int base = qsa[left];
        int temp = 0;
        while (l!=r){
            while (qsa[r]>=base && l<r){
                r--;
            }
            while (qsa[l]<=base && l<r){
                l++;
            }
            if (l<r){
                temp = qsa[l];
                qsa[l] = qsa[r];
                qsa[r] = temp;
            }
        }
        qsa[left] = qsa[l];
        qsa[l]= base;
        quickSortReview(qsa,left,l-1);
        quickSortReview(qsa,r+1,right);
    }
}


