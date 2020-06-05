package com.tzg.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] quickSortArray = {-9,78,0,23,-567,70, -1,900, 4561};
        quickSort(quickSortArray,0,quickSortArray.length-1);
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
        while (l!=r){
            System.out.println("l="+l+"r="+r);
            while (qsa[r]>=base&&l<r){
                r--;
            }
            while (qsa[l]<=base&&l<r){
                l++;
            }
            if (l<r){
                temp = qsa[l];
                qsa[l]=qsa[r];
                qsa[r]=temp;
            }
        }
        qsa[left]=qsa[l];
        qsa[l]= base;
        quickSort(qsa,left,l-1);
        quickSort(qsa,r+1,right);
    }

    public static void quickSort1(int[] qsa,int left,int right){
        int l = left;
        int r = right;
        int temp = 0;
        int pivot = qsa[(left+right)/2];
        while(l<r){
            while ( qsa[l] < pivot ){
                l+=1;
            }
            while ( qsa[r] > pivot ){
                r-=1;
            }
            if (l>=r){
                break;
            }
            temp = qsa[l];
            qsa[l] = qsa[r];
            qsa[r]= temp;

            //此处是为了处理一边完成有序 ，另一边仍未完成的情况
            if (qsa[l]==pivot){
                r-=1;
            }
            if (qsa[r]==pivot){
                l+=1;
            }
        }
        if (l == r){
            l+=1;
            r-=1;
        }
        if (left<r){
            quickSort(qsa,left,r);
        }
        if (right>l){
            quickSort(qsa,l,right);
        }
    }
}


