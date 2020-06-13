package com.tzg.threadedBinaryTree;

public class threadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1
        System.out.println("使用线索化的方式遍历 线索化二叉树");
        threadedBinaryTree.threadedList(); // 8, 3, 10, 1, 14, 6
    }
}

class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre;
    public void  setRoot(HeroNode root){
        this.root = root;
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }

    public void threadedNodes(HeroNode node){
        if (node==null){
            return;
        }
        //左子树线索化
        threadedNodes(node.getLeft());

        //线索化当前节点
        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //此处是在下一次循环中做的 所以是用pre代表上一轮中的当前节点
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        //线索化右子树
        threadedNodes(node.getRight());
    }

    public void threadedList(){
        HeroNode node = root;
        while (node!=null){
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType()==1){
                node = node.getRight();
                System.out.println(node);
            }

            node = node.getRight();
        }
    }

}

//结点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //默认null
    private HeroNode right; //默认null
    //说明
    //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
    private int leftType;
    private int rightType;



    public int getLeftType() {
        return leftType;
    }
    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }
    public int getRightType() {
        return rightType;
    }
    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
    public HeroNode(int no, String name) {
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


}