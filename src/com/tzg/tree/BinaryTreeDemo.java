package com.tzg.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        HeroNode root = new HeroNode(1,"tzg");
        HeroNode childNode1 = new HeroNode(2,"ll");
        HeroNode childNode2 = new HeroNode(3,"dc");
        HeroNode childNode3 = new HeroNode(4,"lxs");
        HeroNode childNode4 = new HeroNode(5,"ybl");
        HeroNode childNode5 = new HeroNode(6,"lcy");
        HeroNode childNode6 = new HeroNode(7,"wh");
        bt.setRoot(root);
        root.setLeft(childNode1);
        root.setRight(childNode2);
        childNode2.setLeft(childNode3);
        childNode2.setRight(childNode4);
        childNode4.setLeft(childNode5);
        childNode4.setRight(childNode6);
//        bt.preOrder();
//        bt.infixOrder();
//        bt.postOrder();

//        HeroNode resNode = bt.preOrderSearch(8);
//        if (resNode != null) {
//            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", 8);
//        }

//        HeroNode resNode = bt.postOrderSearch(5);
//        if (resNode != null) {
//            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
//        } else {
//            System.out.printf("没有找到 no = %d 的英雄", 5);
//        }
//        System.out.println("删除前,前序遍历");
//        bt.preOrder(); //  1,2,3,4,5,6,7
//        bt.delNode(5);
//        System.out.println("删除后，前序遍历");
//        bt.preOrder(); // 1,2,3,4

    }
}

class BinaryTree{
    private HeroNode root;
    public void setRoot(HeroNode root){
        this.root = root;
    }

    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else{
            System.out.println("二叉树为空");
        }
    }

    public HeroNode preOrderSearch(int no){
        if (root!=null){
            return root.preOrderResearch(no);
        }else{
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no){
        if (root!=null){
            return root.infixOrderResearch(no);
        }else{
            return null;
        }
    }

    public HeroNode postOrderSearch(int no){
        if (root!=null){
            return root.postOrderResearch(no);
        }else{
            return null;
        }
    }

    public void delNode(int no){
        if (root!=null){
            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("二叉树为空");
        }


    }

}

class HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    public HeroNode(int no, String name){
        this.no = no;
        this.name = name;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HeroNode getLeft() {
        return left;
    }
    public void setLeft(HeroNode left) {
        this.left = left;
    }
    public HeroNode getRight() {
        return right;
    }
    public void setRight(HeroNode right) {
        this.right = right;
    }
    @Override
    public String toString() {
        return "HeroNode [no=" + no + ", name=" + name + "]";
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);

        if (this.left!=null){
            this.left.preOrder();
        }

        if (this.right!=null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right!=null){
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }

        if (this.right!=null){
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //前序查找
    public HeroNode preOrderResearch(int no){
        if (this.no==no){
            return this;
        }

        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.preOrderResearch(no);
        }
        if (resNode!=null){
            return resNode;
        }

        if (this.right!=null){
            resNode = this.right.preOrderResearch(no);
        }

        return resNode;

    }
    //中序查找
    public HeroNode infixOrderResearch(int no){


        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.infixOrderResearch(no);
        }
        if (resNode!=null){
            return resNode;
        }

        if (this.no==no){
            return this;
        }

        if (this.right!=null){
            resNode = this.right.infixOrderResearch(no);
        }

        return resNode;
    }
    //后序查找
    public HeroNode postOrderResearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode = this.left.postOrderResearch(no);
        }
        if (resNode!=null){
            return resNode;
        }



        if (this.right!=null){
            resNode = this.right.postOrderResearch(no);
        }

        if (resNode!=null){
            return resNode;
        }

        if (this.no==no){
            return this;
        }

        return resNode;
    }

    //删除节点
    public void delNode(int no){
        if (this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
}
