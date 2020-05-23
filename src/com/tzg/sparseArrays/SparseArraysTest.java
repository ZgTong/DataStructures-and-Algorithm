package com.tzg.sparseArrays;


public class SparseArraysTest {

    public static void main(String[] args) {

        // 创建一个原始的二维数组11*11；
        // 0表示没有棋子 1表示黑子 2表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] =1;
        chessArr1[2][3] =2;
        chessArr1[3][3] =2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        // 1 遍历二维数组 得到非零个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0) {
                    sum++;
                }
            }
        }
        System.out.println("非零个数"+sum);

        //2. 创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //3.遍历二维数组，将非零的数字存入稀疏数组
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];

                }
            }
        }
        //得到的稀疏数组
        System.out.println("得到的稀疏数组");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();




        //		稀疏数组转为二维数组
        //1.先读取第一行，创建原始数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        System.out.println("创建的二维数组 空的");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        System.out.println("恢复过的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
