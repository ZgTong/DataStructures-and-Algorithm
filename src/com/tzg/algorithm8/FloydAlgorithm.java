package com.tzg.algorithm8;

import java.util.Arrays;

public class FloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //�����ڽӾ���
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[] { 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };

        //���� Graph ����
        Graph graph = new Graph(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph {
    private char[] vertex;
    private int[][] distance;
    private int[][] pre; // ���浽��Ŀ�궥���ǰ������

    public Graph(int length ,int[][] matrix, char[] vertex){
        this.vertex = vertex;
        this.distance = matrix;
        this.pre = new int[length][length];
        //��ʼ��pre ֵΪ�±�
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i],i);
        }
    }

    public void floyd(){
        int len = 0;
        //�����м�ڵ�k
        for (int k = 0; k < distance.length; k++) {
            //��i��ʼ����
            for (int i = 0; i < distance.length; i++) {
                //����j
                for (int j = 0; j < distance.length; j++) {
                    len = distance[i][k]+distance[k][j];
                    if (len<distance[i][j]){
                        distance[i][j] = len;//������̾���
                        pre[i][j] = pre[k][j];//����ǰ������
                    }
                }
            }
        }
    }

    public void show(){
        char[] vertex ={'A','B','C','D','E','F','G'};
        for (int k = 0; k < distance.length; k++) {
            for (int i = 0; i < distance.length; i++) {
                System.out.print(vertex[pre[k][i]]);
            }
            System.out.println();
            // ���dis�����һ������
            for (int i = 0; i < distance.length; i++) {
                System.out.print("("+vertex[k]+"��"+vertex[i]+"�����·����" + distance[k][i] + ") ");
            }
            System.out.println();
        }
    }
}
