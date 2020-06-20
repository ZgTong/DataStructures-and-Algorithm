package com.tzg.algorithm3;

public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weight = {1,4,3}; //物品的重量
        int[] value = {1500,3000,2000}; //物品的价值
        int m = 4; //背包容量
        int n = value.length; //物品的个数
        //创建二维数组，arr[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大值
        int[][] arr = new int[n+1][m+1];

        int[][] path = new int[n+1][m+1];
        for (int i = 0; i < value.length; i++) {
            arr[0][i]=0; //第一行设置为零
        }
        for (int i = 0; i < value.length; i++) {
            arr[i][0]=0; //第一列设置为零
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (weight[i-1]>j){  //从1开始，用weight 和value要-1
                    arr[i][j] = arr[i-1][j];
                }else {
                    if ( arr[i-1][j] < value[i-1] + arr[i-1][j-weight[i-1]] ) {
                        arr[i][j] = value[i-1] + arr[i-1][j-weight[i-1]];
                        path[i][j]=1; //最优解
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

        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[i].length; j++) {
                System.out.print(path[i][j]+" ");
            }
            System.out.println();
        }


//        for (int i = 0; i < path.length; i++) {
//            for (int j = 0; j < path[i].length; j++) {
//                if (path[i][j]==1){
//                    System.out.printf("第%d个商品放入到背包\n", i);
//                }
//            }
//        }

        int i = path.length-1; //3
        int j = path[0].length-1; //4
        while (i>0 && j>0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入到背包\n", i);
                j-=weight[i-1]; //??

            }
            i--;
        }
    }
}
