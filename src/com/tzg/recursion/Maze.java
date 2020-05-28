package com.tzg.recursion;

public class Maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        //画地图  上下左右四面墙
        for (int i = 0; i < 7; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        //封路
//        map[1][2] = 1;
//        map[2][2] = 1;
        System.out.println("地图的情况:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        //测试一下
        findWay(map,1,1);
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯来给小球找路,约定0位未走过，1是墙，2是路通可以走，3是表示该点已经走过 但是走不通
     * @param map 传入迷宫
     * @param i 从哪个位置开始
     * @param j
     * @return
     */
    public static boolean findWay(int[][] map , int i, int j ){
        if (map[6][5]==2){
            //到达终点
            return true;
        }else {
            if (map[i][j]==0){ //当前的点还没有走过
                //该处可以走
                map[i][j] = 2;
                //策略定位下、右、上、左
                if (findWay(map,i+1,j)){
                    return  true;
                }else if (findWay(map,i,j+1)) {
                    return true;
                }else if (findWay(map,i-1,j)) {
                    return true;
                }else if (findWay(map,i,j-1)) {
                    return true;
                }else{
                    map[i][j] = 3;
                    return  false;
                }
            }else { // 如果map[i][j] != 0 , 可能是 1， 2， 3,均不可行
                return false;
            }
        }
    }
}
