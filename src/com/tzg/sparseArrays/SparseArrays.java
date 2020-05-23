package com.tzg.sparseArrays;

public class SparseArrays {
	public static void main(String[] args) {
		//创建二维数组
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

		//遍历二维数组 得到非零个数
		int sum = 0;
		for (int i = 0; i < chessArr.length; i++) {
			for (int j = 0; j < 11; j++) {
				if (chessArr[i][j]!=0){
					sum++;
				}
			}
		}
		System.out.println("非零个数为"+sum);

		//创建对应的稀疏数组
		int sparseArray[][] = new int[sum+1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;

		//遍历二维数组，将非零数据存入稀疏数组
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

		// 得到的稀疏数组
		System.out.println("得到的稀疏数组");
		for (int i = 0; i < sparseArray.length; i++) {
			System.out.printf("%d\t%d\t%d\t\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
			System.out.println();
		}

		//根据稀疏数组第一行创建原始数组
		int chessArrRestore[][]  = new int[sparseArray[0][0]][sparseArray[0][1]];
		// 从1开始循环，填充新的二维数组
		for (int i = 1; i < sparseArray.length; i++) {
			chessArrRestore[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
		}

		System.out.println("恢复的二维数组");
		for (int[] row:chessArrRestore) {
			for (int item :row) {
				System.out.printf("%d\t",item);
			}
			System.out.println();
		}

	}
}
