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
     * �ϲ�����
     * @param msa  ԭʼ����
     * @param left ����������еĳ�ʼ����
     * @param mid �м�����
     * @param right �ұ�����
     * @param temp ��ת����
     */
    public static void merge(int[] msa,int left,int mid ,int right,int[] temp){
        int l = left; //����������г�ʼ����
        int r = mid+1; //�ұ��������г�ʼ����
        int t = 0; //temp���鵱ǰ����
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
