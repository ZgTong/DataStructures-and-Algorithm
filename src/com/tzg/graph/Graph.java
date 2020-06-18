package com.tzg.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList; //�洢���㼯��
    private int[][] matrix; //����
    private int numOfEdges; //��ʾ�ߵ���Ŀ
    private boolean[] isVisited;//��¼ĳ������Ƿ񱻷���
    public static void main(String[] args) {
        int n = 5;
        String[] list = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String item:list) {
            graph.insertVertex(item);
        }

        graph.insertEdges(0,1,1);
        graph.insertEdges(0,2,1);
        graph.insertEdges(1,2,1);
        graph.insertEdges(1,3,1);
        graph.insertEdges(1,4,1);
        graph.showGraph();
    }
    public Graph(int n ){
        this.matrix = new int[n][n];
        this.vertexList =  new ArrayList<String>(n);
        this.numOfEdges = 0;
    }

    /**
     * ��ӱ�
     * @param n1 ��ʾ����±꼴ʹ�ڼ�������  "A"-"B"
     * @param n2 �ڶ��������Ӧ���±�
     * @param weight ��ʾ
     */
    public void insertEdges(int n1, int n2, int weight){
        matrix[n1][n2] = weight;
        matrix[n2][n1] = weight;
        numOfEdges++;
    }

    //����ڵ�
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //����n1��n2��Ȩֵ
    public int getEdgeWeight(int n1, int n2){
        return matrix[n1][n2];
    }

    //���ؽ��i(�±�)��Ӧ������ 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i ){
        return vertexList.get(i);
    }

    //���ؽ��i(�±�)��Ӧ������ 0->"A" 1->"B" 2->"C"
    public int getEdgesNums(){
        return numOfEdges;
    }

    //��ʾͼ��Ӧ�ľ���
    public void showGraph(){
        for (int[] item : matrix) {
            System.err.println(Arrays.toString(item));
        }
    }

    //���ؽڵ�ĸ���
    public int getNumOfVertex(){
        return vertexList.size();
    }

}
