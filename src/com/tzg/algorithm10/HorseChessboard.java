package com.tzg.algorithm10;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class HorseChessboard {
    private static int X; //��������
    private static int Y; //��������
    private static boolean[] visited; //����λ���Ƿ񱻷���
    private static boolean finished; //true��ʾ�ɹ�
    public static void main(String[] args) {
        System.out.println("��ʿ����");
        X = 8;
        Y = 8;
        //��ʼλ��
        int row = 5;
        int column = 5;

        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        long start = System.currentTimeMillis();
        cavalierTravel(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("����ʱ: " + (end - start) + " ����");

        //������̵�������
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
     * ���ܣ� ���ݵ�ǰλ��(Point����)�����������������Щλ��(Point)�������뵽һ��������(ArrayList), �����8��λ��
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
