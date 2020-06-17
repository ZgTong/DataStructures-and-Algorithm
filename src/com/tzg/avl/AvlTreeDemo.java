package com.tzg.avl;

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr =  { 10, 11, 7, 6, 8, 9 };
        AvlTree avlTree = new AvlTree();
        for(int i=0; i < arr.length; i++) {
            avlTree.addNode(new Node(arr[i]));
        }

        //遍历
        System.out.println("中序遍历");
        avlTree.infixOrder();

        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
}

class AvlTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void addNode(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空二叉树,不能遍历");
        }
    }

    public Node searchNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchNode(value);
        }
    }

    public Node searchParentNode(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParentNode(value);
        }
    }


    /**
     * 1. 返回的 以node 为根结点的二叉排序树的最小结点的值
     * 2. 删除node 为根结点的二叉排序树的最小结点
     *
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int deleteRightTreeMin(Node node) {
        Node target = node;
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            Node targetNode = searchNode(value);
            //没有此节点
            if (targetNode == null) {
                return;
            }
            //只有一个节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //父节点
            Node parentNode = searchParentNode(value);
            //3种情况
            //叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//删除有两颗子树的节点
                int minValue = deleteRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            } else {//删除有一颗子树的节点
                if (targetNode.left != null) {//有左子节点
                    if (parentNode != null) { //处理特殊情况 根节点只有一颗子树
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //有右子节点
                    if (parentNode != null) {//处理特殊情况 根节点只有一颗子树
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.right;
                        } else {
                            parentNode.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

}


class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //添加节点
    public void addNode(Node node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.addNode(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }
        }

        if (rightHeight()-leftHeight()>1){
            if (right!=null && right.leftHeight()>right.rightHeight()){
                right.rightRotate();
                leftRotate();
            }else{
                leftRotate();
            }
            return;
        }

        if (leftHeight()-rightHeight()>1){
            if (left!=null && left.rightHeight()>left.leftHeight()){
                left.leftRotate();
                rightRotate();
            }else{
                rightRotate();
            }
        }
    }


    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node searchNode(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            if (this.left == null) {
                return null;
            }
            return this.left.searchNode(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.searchNode(value);
        }
    }

    //找到父节点
    public Node searchParentNode(int value) {
        if (
                (this.left != null && this.left.value == value) ||
                        (this.right != null && this.right.value == value)
        ) {
            return this;
        } else {
            if (value < this.value && this.left != null) {
                return this.left.searchParentNode(value);
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParentNode(value);
            } else {
                return null;
            }
        }
    }

    // 返回 以该结点为根结点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    public void leftRotate() {
        //创建新的结点，以当前根结点的值
        Node node = new Node(value);
        //把新的结点的左子树设置成当前结点的左子树
        node.left = left;
        //把新的结点的右子树设置成带你过去结点的右子树的左子树
        node.right = right.left;
        //把当前结点的值替换成右子结点的值
        value = right.value;
        //把当前结点的右子树设置成当前结点右子树的右子树
        right = right.right;
        //把当前结点的左子树(左子结点)设置成新的结点
        left= node;
    }

    public void rightRotate(){
        Node node = new Node(value);
        node.right = right;
        node.left = left.right;
        value = left.value;
        left = left.left;
        right = node;
    }


}