package com.tzg.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertexList; //存储顶点集合
    private int[][] matrix; //矩阵
    private int numOfEdges; //表示边的数目
    private boolean[] isVisited;//记录某个结点是否被访问
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
     * 添加边
     * @param n1 表示点的下标即使第几个顶点  "A"-"B"
     * @param n2 第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdges(int n1, int n2, int weight){
        matrix[n1][n2] = weight;
        matrix[n2][n1] = weight;
        numOfEdges++;
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //返回n1和n2的权值
    public int getEdgeWeight(int n1, int n2){
        return matrix[n1][n2];
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i ){
        return vertexList.get(i);
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public int getEdgesNums(){
        return numOfEdges;
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] item : matrix) {
            System.err.println(Arrays.toString(item));
        }
    }

    //返回节点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }

}
