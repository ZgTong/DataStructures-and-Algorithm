package com.tzg.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
//        int[] heapSortArr = {4, 6, 8, 5, 9};
//        heapSort(heapSortArr);
//        System.out.println(Arrays.toString(heapSortArr));

        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        heapSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
    }

    public static void swap(int[] arr ,int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    /**
     * 堆排序
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
     * 将以i对应的非叶子节点的树调整为大顶堆
     * 例： int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * @param i 非叶子节点在数组中的索引
     * @param arr 待调整的数组
     * @param length  表示对多少个元素进行调整
     */
    public static void adjustHeap(int[] arr,int i ,int length){
        int temp = arr[i];
        for (int k = 2*i+1; k < length; k = 2*k+1){
            //说明左子结点的值小于右子结点的值,k 指向右子结点
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子结点大于父结点,把较大的值赋给当前结点，i 指向 k,继续循环比较
            if (arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        //将以i 为父结点的树的最大值，放在了 最顶(局部),将temp值放到调整后的位置
        arr[i] = temp;
    }
}


