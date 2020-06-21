package com.tzg.algorithm4;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";

        int[] matchTable = kmpMatchTable("ABCDABD"); //[0, 1, 2, 0]
        System.out.println("matchTable=" + Arrays.toString(matchTable));

        int index = kmpSearch(str1, str2, matchTable);
        System.out.println("index=" + index); // 15了
    }


    public static int kmpSearch(String s1,String s2,int[] matchTable){
        for (int i = 0,j=0; i < s1.length(); i++) {
            while( j>0 && s1.charAt(i)!=s2.charAt(j) ){
                j=matchTable[j-1];
            }
            if (s1.charAt(i)==s2.charAt(j)){
                j++;
            }
            if (j==s2.length()){
                return i-j+1;
            }
        }
        return -1;
    }


    public static int[] kmpMatchTable(String dest){
        int[] matchTable = new int[dest.length()];
        matchTable[0] = 0;
        for (int i = 1,j=0; i < dest.length(); i++) {
            //核心matchTable[j-1]获取新的j
            while (j>0&&dest.charAt(i)!=dest.charAt(j)){
                j = matchTable[j-1];
            }

            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            matchTable[i] = j;
        }
        return matchTable;
    }
}
