package com.tzg.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] seqSearchArray = { 1, 9, 11, -1, 34, 89 };
        int res = seqSearch(seqSearchArray,89);
        if (res!=-1){
            System.out.println("�±�Ϊ��"+res);
        }else{
            System.out.println("û��");
        }

    }

    public static int seqSearch(int[] ssa,int findVal){
        for (int i = 0; i < ssa.length; i++) {
            if (ssa[i]==findVal){
                return i;
            }
        }
        return -1;
    }
}
