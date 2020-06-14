package com.tzg.huffmanTree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    public static Node createHuffmanTree(int[] hta){
        List<Node> nodesList = new ArrayList<Node>();

        for (int value : hta) {
            nodesList.add(new Node(value));
        }

        while (nodesList.size()>1){
            Collections.sort(nodesList);

            Node leftNode = nodesList.get(0);
            Node rightNode = nodesList.get(1);

            Node parentNode = new Node(leftNode.value+rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            nodesList.remove(leftNode);
            nodesList.remove(rightNode);
            nodesList.add(parentNode);
        }
        return nodesList.get(0);
    }


    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else{
            System.out.println("空树");
        }
    }
}
class Node implements Comparable<Node>{
    int value; //节点的权值
    char c; //字符
    Node left;//左右子节点
    Node right;

    /**
     * 前序遍历
     */
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }
}
