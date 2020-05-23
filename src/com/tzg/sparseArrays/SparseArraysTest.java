package com.tzg.sparseArrays;


public class SparseArraysTest {

    public static void main(String[] args) {

        // ����һ��ԭʼ�Ķ�ά����11*11��
        // 0��ʾû������ 1��ʾ���� 2��ʾ����
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


        // 1 ������ά���� �õ��������
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0) {
                    sum++;
                }
            }
        }
        System.out.println("�������"+sum);

        //2. ������Ӧ��ϡ������
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //3.������ά���飬����������ִ���ϡ������
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
        //�õ���ϡ������
        System.out.println("�õ���ϡ������");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        System.out.println();




        //		ϡ������תΪ��ά����
        //1.�ȶ�ȡ��һ�У�����ԭʼ����
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        System.out.println("�����Ķ�ά���� �յ�");
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
        System.out.println("�ָ����Ķ�ά����");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
