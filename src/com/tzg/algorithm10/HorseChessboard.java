package com.tzg.algorithm10;

import java.awt.*;
import java.util.ArrayList;

public class HorseChessboard {
    private static int X; //棋盘列数
    private static int Y; //棋盘行数
    private static boolean[] visited; //各个位置是否被访问
    private static boolean finished; //true表示成功
    public static void main(String[] args) {
        System.out.println("骑士周游");
        X = 8;
        Y = 8;
        //初始位置
        int row = 4;
        int column = 3;

        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
    }


    public static void CavalierTravel(int[][] chessboard,int row,int column,int step){
        chessboard[row][column] = step;
        visited[row*X+column] = true;
        ArrayList<Point> arrayList = nextStepList(new Point(row,column));

        if (step<X*Y&&!finished){

        }else{
            finished = true;
        }
    }

    /**
     * 功能： 根据当前位置(Point对象)，计算马儿还能走哪些位置(Point)，并放入到一个集合中(ArrayList), 最多有8个位置
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> nextStepList(Point curPoint){
        ArrayList<Point> al = new ArrayList<Point>();
        Point p1 = new Point();
        if ((p1.x = curPoint.x-2)>=0&&(p1.y = curPoint.y-1)>=0){
            al.add(p1);
        }
        if ((p1.x = curPoint.x-1)>=0&&(p1.y = curPoint.y-2)>=0){
            al.add(p1);
        }
        if ((p1.x = curPoint.x+1)<X&&(p1.y = curPoint.y-2)>=0){
            al.add(p1);
        }
        if ((p1.x = curPoint.x+2)<X&&(p1.y = curPoint.y-1)>=0){
            al.add(p1);
        }
        if ((p1.x = curPoint.x+2)<X&&(p1.y = curPoint.y+1)<Y){
            al.add(p1);
        }
        if ((p1.x = curPoint.x+1)<X&&(p1.y = curPoint.y+2)<Y){
            al.add(p1);
        }
        if ((p1.x = curPoint.x-1)>0&&(p1.y = curPoint.y+2)<Y){
            al.add(p1);
        }
        if ((p1.x = curPoint.x-2)>=0&&(p1.y = curPoint.y+1)<Y){
            al.add(p1);
        }
        return al;
    }
}
