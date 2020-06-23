package com.tzg.algorithm6;

import java.util.Arrays;

public class Prim {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int vertex = data.length;
        //邻接矩阵的关系使用二维数组表示,10000表示两个点不联通
        int [][] weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}};

        //创建MGraph对象
        MGraph graph = new MGraph(vertex);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, vertex, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim(graph, 1);
    }
}



class MinTree{
    /**
     * 创建图的邻接矩阵
     * @param graph 图对象
     * @param vertex 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param matrix 图的邻接矩阵
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
     * 显示图的邻接矩阵
     * @param graph 图对象
     */
    public void showGraph(MGraph graph){
        for (int[] item:graph.matrix) {
            System.out.println(Arrays.toString(item));
        }
    }


    /**
     * prim算法
     * @param graph
     * @param start 表示从图的第几个顶点开始生成 'A'->0
     */
    public void prim(MGraph graph, int start){
        //visited[] 默认元素的值都是0, 表示没有访问过
        int[] visited = new int[graph.vertex];
        visited[start] =1;
        int minWeight = 100000;
        //h1 和 h2 记录两个顶点的下标
        int h1= -1;
        int h2= -1;
        //vertex-1条边
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
            //此时找到一条最小的边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //重置
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