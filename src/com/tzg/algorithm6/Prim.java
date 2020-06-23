package com.tzg.algorithm6;

import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int vertex = data.length;
        //�ڽӾ���Ĺ�ϵʹ�ö�ά�����ʾ,10000��ʾ�����㲻��ͨ
        int [][] weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};

        //����MGraph����
        MGraph graph = new MGraph(vertex);
        //����һ��MinTree����
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertex, data, weight);
        //���
        minTree.showGraph(graph);
        //��������ķ�㷨
        minTree.prim(graph, 1);
    }
}



class MinTree{
    /**
     * ����ͼ���ڽӾ���
     * @param graph ͼ����
     * @param vertex ͼ��Ӧ�Ķ������
     * @param data ͼ�ĸ��������ֵ
     * @param matrix ͼ���ڽӾ���
     */
    public void createGraph(MGraph graph, int vertex, char[] data, int[][] matrix){
        int i,j;
        for (i = 0; i < vertex; i++) {
            graph.data[i] =  data[i];
            for (j = 0; j < vertex; j++) {
                graph.matrix[i][j] = matrix[i][j];
            }
        }
    }

    /**
     * ��ʾͼ���ڽӾ���
     * @param graph ͼ����
     */
    public void showGraph(MGraph graph){
        for (int[] item:graph.matrix) {
            System.out.println(Arrays.toString(item));
        }
    }


    /**
     * prim�㷨
     * @param graph
     * @param start ��ʾ��ͼ�ĵڼ������㿪ʼ���� 'A'->0
     */
    public void prim(MGraph graph, int start){
        //visited[] Ĭ��Ԫ�ص�ֵ����0, ��ʾû�з��ʹ�
        int[] visited = new int[graph.vertex];
        visited[start] =1;
        int minWeight = 100000;
        //h1 �� h2 ��¼����������±�
        int h1= -1;
        int h2= -1;
        //vertex-1����
        for (int i = 1; i <graph.vertex ; i++) {

            for (int j = 0; j <graph.vertex ; j++) {
                for (int k = 0; k <graph.vertex ; k++) {
                    if (visited[j]==1&&visited[k]==0 &&graph.matrix[j][k]<minWeight){
                        minWeight = graph.matrix[j][k];
                        h1 = j;
                        h2 = k;
                    }
                }
            }
            //��ʱ�ҵ�һ����С�ı�
            System.out.println("��<" + graph.data[h1] + "," + graph.data[h2] + "> Ȩֵ:" + minWeight);
            //����ǰ��������Ϊ�Ѿ�����
            visited[h2] = 1;
            //����
            minWeight = 10000;
        }

    }

}


class MGraph{
    int vertex;
    char[] data;
    int[][] matrix;
    public MGraph(int vertex){
        this.vertex = vertex;
        data = new char[vertex];
        matrix = new int[vertex][vertex];
    }
}