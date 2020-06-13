package com.tzg.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
//        int[] heapSortArr = {4, 6, 8, 5, 9};
//        heapSort(heapSortArr);
//        System.out.println(Arrays.toString(heapSortArr));

        // ����Ҫ��80000�������������
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
        }

        System.out.println("����ǰ");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("����ǰ��ʱ����=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("����ǰ��ʱ����=" + date2Str);
    }

    public static void swap(int[] arr ,int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * ������
     * @param arr
     */
    public static void heapSort(int[] arr){

        for (int i =arr.length/2-1; i>=0; i--){
            adjustHeap(arr,i,arr.length);
        }

        for (int j = arr.length-1; j >=0 ; j--) {
            swap(arr,j,0);
            adjustHeap(arr,0,j);
        }
    }

    /**
     * ����i��Ӧ�ķ�Ҷ�ӽڵ��������Ϊ�󶥶�
     * ���� int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => �õ� {4, 9, 8, 5, 6}
     * @param i ��Ҷ�ӽڵ��������е�����
     * @param arr ������������
     * @param length  ��ʾ�Զ��ٸ�Ԫ�ؽ��е���
     */
    public static void adjustHeap(int[] arr,int i ,int length){
        int temp = arr[i];
        for (int k = 2*i+1; k < length; k = 2*k+1){
            //˵�����ӽ���ֵС�����ӽ���ֵ,k ָ�����ӽ��
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //����ӽ����ڸ����,�ѽϴ��ֵ������ǰ��㣬i ָ�� k,����ѭ���Ƚ�
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        //����i Ϊ�������������ֵ�������� �(�ֲ�),��tempֵ�ŵ��������λ��
        arr[i] = temp;
    }
}


