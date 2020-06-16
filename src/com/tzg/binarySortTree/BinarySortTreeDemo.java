package com.tzg.binarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for(int i = 0; i< arr.length; i++) {
            binarySortTree.addNode(new Node(arr[i]));
        }
        System.out.println("中序遍历二叉排序树~");
        binarySortTree.infixOrder();// 1, 3, 5, 7, 9, 10, 12


//        binarySortTree.deleteNode(12);
//        binarySortTree.deleteNode(5);
//        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(2);
//        binarySortTree.deleteNode(3);
//        binarySortTree.deleteNode(9);
//        binarySortTree.deleteNode(1);
//        binarySortTree.deleteNode(7);
        System.out.println("删除结点后");
        binarySortTree.infixOrder();
    }
}



class BinarySortTree{
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(Node node){
        if (root == null){
            root = node;
        }else{
            root.addNode(node);
        }
    }

    public void infixOrder(){
        if (root != null){
            root.infixOrder();
        }else{
            System.out.println("空二叉树,不能遍历");
        }
    }

    public Node searchNode(int value){
        if (root==null){
            return null;
        }else {
            return root.searchNode(value);
        }
    }

    public Node searchParentNode(int value){
        if (root == null){
            return null;
        }else{
            return root.searchParentNode(value);
        }
    }


    /**
     * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 2. 删除node 为根结点的二叉排序树的最小结点
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int deleteRightTreeMin(Node node){
        Node target = node;
        while (target.left!=null){
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    public void deleteNode(int value){
        if (root==null){
            return;
        }else {
            Node targetNode = searchNode(value);
            //没有此节点
            if (targetNode == null){
                return;
            }
            //只有一个节点
            if (root.left==null && root.right==null){
                root = null;
                return;
            }
            //父节点
            Node parentNode = searchParentNode(value);
            //3种情况
            //叶子结点
            if (targetNode.left==null && targetNode.right==null){
                if (parentNode.left!=null && parentNode.left.value==value){
                    parentNode.left = null;
                }else if (parentNode.right!=null && parentNode.right.value == value ){
                    parentNode.right = null;
                }
            }else if(targetNode.left != null && targetNode.right != null){//删除有两颗子树的节点
                int minValue = deleteRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            }else{//删除有一颗子树的节点
                if (targetNode.left != null){//有左子节点
                    if (parentNode!=null){ //处理特殊情况 根节点只有一颗子树
                        if (parentNode.left.value == value){
                            parentNode.left = targetNode.left;
                        }else{
                            parentNode.right = targetNode.left;
                        }
                    }else{
                        root = targetNode.left;
                    }
                }else{ //有右子节点
                    if (parentNode!=null){//处理特殊情况 根节点只有一颗子树
                        if (parentNode.left.value == value){
                            parentNode.left = targetNode.right;
                        }else{
                            parentNode.right = targetNode.right;
                        }
                    }else{
                        root = targetNode.right;
                    }
                }
            }
        }
    }

}


class Node{
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    //添加节点
    public void addNode(Node node){
        if (node == null){
            return;
        }

        if (node.value<this.value){
            if (this.left==null){
                this.left = node;
            }else{
                this.left.addNode(node);
            }
        }else {
            if (this.right==null){
                this.right = node;
            }else{
                this.right.addNode(node);
            }
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

    public Node searchNode(int value){
        if (value == this.value){
            return this;
        }else if(value < this.value){
            if (this.left==null){
                return null;
            }
            return this.left.searchNode(value);
        }else{
            if (this.right==null){
                return null;
            }
            return this.right.searchNode(value);
        }
    }

    //找到父节点
    public Node searchParentNode(int value){
        if (
                (this.left != null && this.left.value == value) ||
                (this.right!=null && this.right.value == value)
        ){
            return this;
        }else{
            if (value < this.value && this.left!=null){
                return this.left.searchParentNode(value);
            } else if (value >= this.value && this.right!=null){
                return this.right.searchParentNode(value);
            } else {
                return null;
            }
        }
    }


}