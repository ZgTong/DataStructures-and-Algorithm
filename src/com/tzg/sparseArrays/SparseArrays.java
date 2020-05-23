package com.tzg.sparseArrays;

public class SparseArrays {
	public static void main(String[] args) {
		//������ά����
		int chessArr[][] = new int[11][11];
		chessArr[1][2]= 1;
		chessArr[2][3]= 2;
		chessArr[3][3]= 2;
		for (int[] arr:chessArr) {
			for (int item:arr) {
				System.out.printf("%d\t",item);
			}
			System.out.println();
		}

		//������ά���� �õ��������
		int sum = 0;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr[i][j]!=0){
					sum++;
				}
			}
		}
		System.out.println("�������Ϊ"+sum);

		//������Ӧ��ϡ������
		int sparseArray[][] = new int[sum+1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;

		//������ά���飬���������ݴ���ϡ������
		int count = 0;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr[i][j]!=0){
					count++;
					sparseArray[count][0]=i;
					sparseArray[count][1]=j;
					sparseArray[count][2]=chessArr[i][j];
				}
			}
		}

		// �õ���ϡ������
		System.out.println("�õ���ϡ������");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
			System.out.println();
		}

		//����ϡ�������һ�д���ԭʼ����
		int chessArrRestore[][]  = new int[sparseArray[0][0]][sparseArray[0][1]];
		// ��1��ʼѭ��������µĶ�ά����
		for (int i = 1; i < sparseArray.length; i++) {
			chessArrRestore[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}

		System.out.println("�ָ��Ķ�ά����");
		for (int[] row:chessArrRestore) {
			for (int item :row) {
				System.out.printf("%d\t",item);
			}
			System.out.println();
		}

	}
}
