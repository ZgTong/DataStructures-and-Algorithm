package com.tzg.algorithm3;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1,4,3}; //��Ʒ������
        int[] value = {1500,3000,2000}; //��Ʒ�ļ�ֵ
        int m = 4; //��������
        int n = value.length; //��Ʒ�ĸ���
        //������ά���飬arr[i][j] ��ʾ��ǰi����Ʒ���ܹ�װ������Ϊj�ı����е����ֵ
        int[][] arr = new int[n+1][m+1];

        int[][] path = new int[n+1][m+1];
        for (int i = 0; i < value.length; i++) {
            arr[0][i]=0; //��һ������Ϊ��
        }
        for (int i = 0; i < value.length; i++) {
            arr[i][0]=0; //��һ������Ϊ��
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (weight[i-1]>j){  //��1��ʼ����weight ��valueҪ-1
                    arr[i][j] = arr[i-1][j];
                }else {
                    if ( arr[i-1][j] < value[i-1] + arr[i-1][j-weight[i-1]] ) {
                        arr[i][j] = value[i-1] + arr[i-1][j-weight[i-1]];
                        path[i][j]=1;
                    }else{
                        arr[i][j] = arr[i-1][j];
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j]==1){
//                    System.out.printf("��%d����Ʒ���뵽����\n", i);
//                }
//            }
//        }

        int i = path.length-1;
        int j = path[0].length-1;
        while (i>0 && j>0){
            if (path[i][j]==1){
                System.out.printf("��%d����Ʒ���뵽����\n", i);
                j-=weight[i-1];

            }
            i--;
        }
    }
}
