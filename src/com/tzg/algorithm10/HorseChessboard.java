package com.tzg.algorithm10;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

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
        int row = 5;
        int column = 5;

        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        long start = System.currentTimeMillis();
        cavalierTravel(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + " 毫秒");

        //输出棋盘的最后情况
        for(int[] rows : chessboard) {
            for(int step: rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
    }


    public static void cavalierTravel(int[][] chessboard,int row,int column,int step){
        chessboard[row][column] = step;
        visited[row*X+column] = true;
        ArrayList<Point> arrayList = nextStepList(new Point(column,row));
        sort(arrayList);
        while(!arrayList.isEmpty()){
            Point p = arrayList.remove(0);
            if (!visited[p.y*X+p.x]){
                cavalierTravel(chessboard,p.y,p.x,step+1);
            }
        }

        if (step<X*Y&&!finished){
            chessboard[row][column]=0;
            visited[row*X+column]=false;
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
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-1)>=0&&(p1.y = curPoint.y-2)>=0){
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+1)<X&&(p1.y = curPoint.y-2)>=0){
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+2)<X&&(p1.y = curPoint.y-1)>=0){
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+2)<X&&(p1.y = curPoint.y+1)<Y){
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x+1)<X&&(p1.y = curPoint.y+2)<Y){
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-1)>0&&(p1.y = curPoint.y+2)<Y){
            al.add(new Point(p1));
        }
        if ((p1.x = curPoint.x-2)>=0&&(p1.y = curPoint.y+1)<Y){
            al.add(new Point(p1));
        }
        return al;
    }

    public static void sort(ArrayList<Point> arrayList){
        arrayList.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = nextStepList(o1).size();
                int count2 = nextStepList(o2).size();
                if (count1<count2){
                    return -1;
                }else if (count1==count2){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
    }
}
