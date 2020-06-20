package com.tzg.algorithm4;

public class ViolenceMatch {
    public static void main(String[] args) {
        //���Ա���ƥ���㷨
        String str1 = "ͯ�����������úù��������ú�ѧ�㷨��";
        String str2 = "�����ú�";
        int index = violenceMatch(str1, str2);
        System.out.println("index=" + index);
    }

    public static int violenceMatch(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int length1 = s1.length;
        int length2 = s2.length;
        int i =0;
        int j =0;
        while (i<length1 && j<length2){
            if (s1[i]==s2[j]){
                i++;
                j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }
        if (j==length2){
            return i-j;
        }else{
            return -1;
        }
    }
}
