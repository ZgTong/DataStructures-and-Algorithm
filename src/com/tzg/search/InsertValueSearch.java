package com.tzg.search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] insertValueSearch =  {1, 8, 10, 89,1000,1000, 1234};
        int res = insertValueSearch(insertValueSearch, 0, insertValueSearch.length - 1, 1234);
        System.out.println("���ҵ�������Ϊ��"+res);
    }

    public static int insertValueSearch(int[] ivs, int left, int right, int findVal){
        if (left>right || findVal<ivs[0] || findVal>ivs[ivs.length-1]){
            return -1;
        }

        int mid = left+(right-left)*(findVal-ivs[left])/(ivs[right]-ivs[left]);
        int midVal = ivs[mid];

        if (findVal>midVal){
            //���ҵݹ�
            return insertValueSearch(ivs, left, mid-1, findVal);
        }else if (findVal<midVal){
            //����ݹ�
            return insertValueSearch(ivs, mid + 1, right, findVal);
        }else{
            //�ҵ���
            return mid;
        }
    }
}
