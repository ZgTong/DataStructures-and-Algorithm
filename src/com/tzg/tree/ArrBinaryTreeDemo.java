package com.tzg.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(); // 1,2,4,5,3,6,7
    }
}


class ArrBinaryTree{
    private int[] abt;
    public ArrBinaryTree(int[] arr){
        this.abt = arr;
    }

    
    public void preOrder(){
        this.preOrder(0);
    }


    public void preOrder(int index){
        if (abt==null||abt.length==0){
            System.out.println("????????????????????????????");
        }
        System.out.println(abt[index]);
        if ((index*2+1)<abt.length){
            preOrder(index*2+1);
        }
        if ((index*2+2)<abt.length){
            preOrder(index*2+2);
        }
    }
}