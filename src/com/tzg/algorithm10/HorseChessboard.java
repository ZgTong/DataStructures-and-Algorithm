package com.tzg.algorithm10;

import java.awt.*;
import java.util.ArrayList;

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
     * ���ܣ� ���ݵ�ǰλ��(Point����)�����������������Щλ��(Point)�������뵽һ��������(ArrayList), �����8��λ��
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
