package com.tzg.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int binarySearchArr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int res = binarySearch(binarySearchArr,0,binarySearchArr.length,8);
        List<Integer> resMulti = binarySearchMulti(binarySearchArr,0,binarySearchArr.length,8);
        System.out.println("查找到的索引为："+res);
        System.out.println("查找到的索引为："+resMulti);
    }

    public static int binarySearch(int[] bsa,int left,int right,int findVal){
        if (left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = bsa[mid];
        if (findVal<midVal){
            //向左递归
            return binarySearch(bsa, left,mid-1,findVal);
        }else if (findVal>midVal){
            //向右递归
            return binarySearch(bsa, mid+1,right,findVal);
        }else{
            return mid;
        }
    }

    public static List<Integer> binarySearchMulti(int[] bsa, int left, int right, int findVal){
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midVal = bsa[mid];
        if (findVal<midVal){
            //向左递归
            return binarySearchMulti(bsa, left,mid-1,findVal);
        }else if (findVal>midVal){
            //向右递归
            return binarySearchMulti(bsa, mid+1,right,findVal);
        }else{
            //找到后不要立即返回
            List<Integer> resList = new ArrayList<Integer>();
            int temp = mid-1;
            while (true){
                if (temp<0||bsa[temp]!=findVal){
                    break;
                }
                resList.add(temp);
                temp-=1;
            }
            resList.add(mid);
            temp = mid+1;
            while (true){
                if (temp>bsa.length-1 || bsa[temp]!=findVal){
                    break;
                }
                resList.add(temp);
                temp+=1;
            }

            return resList;
        }
    }
}
