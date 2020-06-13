package com.tzg.threadedBinaryTree;

public class threadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");

        //������
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //��������������
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //����: ��10�Žڵ����
        HeroNode leftNode = node5.getLeft();
        HeroNode rightNode = node5.getRight();
        System.out.println("10�Ž���ǰ������� ="  + leftNode); //3
        System.out.println("10�Ž��ĺ�̽����="  + rightNode); //1
        System.out.println("ʹ���������ķ�ʽ���� ������������");
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
        //������������
        threadedNodes(node.getLeft());

        //��������ǰ�ڵ�
        if (node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //�˴�������һ��ѭ�������� ��������pre������һ���еĵ�ǰ�ڵ�
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        pre = node;

        //������������
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

//���
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //Ĭ��null
    private HeroNode right; //Ĭ��null
    //˵��
    //1. ���leftType == 0 ��ʾָ�����������, ��� 1 ���ʾָ��ǰ�����
    //2. ���rightType == 0 ��ʾָ����������, ��� 1��ʾָ���̽��
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