package com.tzg.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] insertValueSearch =  {1, 8, 10, 89,1000,1000, 1234};
        int res = insertValueSearch(insertValueSearch, 0, insertValueSearch.length - 1, 1234);
        System.out.println("查找到的索引为："+res);
    }

    public static int insertValueSearch(int[] ivs, int left, int right, int findVal){
        if (left>right || findVal<ivs[0] || findVal>ivs[ivs.length-1]){
            return -1;
        }

        int mid = left+(right-left)*(findVal-ivs[left])/(ivs[right]-ivs[left]);
        int midVal = ivs[mid];

        if (findVal>midVal){
            //向右递归
            return insertValueSearch(ivs, left, mid-1, findVal);
        }else if (findVal<midVal){
            //向左递归
            return insertValueSearch(ivs, mid + 1, right, findVal);
        }else{
            //找到了
            return mid;
        }
    }
}
