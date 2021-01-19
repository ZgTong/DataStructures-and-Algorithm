package com.tzg.avl;

public class AvlTreeDemo {
    public static void main(String[] args) {
        int[] arr = {10, 11, 7, 6, 8, 9};
        AvlTree avlTree = new AvlTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.addNode(new Node(arr[i]));
        }

        //����
        System.out.println("�������");
        avlTree.infixOrder();

        System.out.println("���ĸ߶�=" + avlTree.getRoot().height()); //3
        System.out.println("�����������߶�=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("�����������߶�=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("��ǰ�ĸ����=" + avlTree.getRoot());//8
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
            System.out.println("�ն�����,���ܱ���");
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
     * 1. ���ص� ��node Ϊ�����Ķ�������������С����ֵ
     * 2. ɾ��node Ϊ�����Ķ�������������С���
     *
     * @param node ����Ľ��(���������������ĸ����)
     * @return ���ص� ��node Ϊ�����Ķ�������������С����ֵ
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
            //û�д˽ڵ�
            if (targetNode == null) {
                return;
            }
            //ֻ��һ���ڵ�
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            //���ڵ�
            Node parentNode = searchParentNode(value);
            //3�����
            //Ҷ�ӽ��
            if (targetNode.left == null && targetNode.right == null) {
                if (parentNode.left != null && parentNode.left.value == value) {
                    parentNode.left = null;
                } else if (parentNode.right != null && parentNode.right.value == value) {
                    parentNode.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {//ɾ�������������Ľڵ�
                int minValue = deleteRightTreeMin(targetNode.right);
                targetNode.value = minValue;
            } else {//ɾ����һ�������Ľڵ�
                if (targetNode.left != null) {//�����ӽڵ�
                    if (parentNode != null) { //����������� ���ڵ�ֻ��һ������
                        if (parentNode.left.value == value) {
                            parentNode.left = targetNode.left;
                        } else {
                            parentNode.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //�����ӽڵ�
                    if (parentNode != null) {//����������� ���ڵ�ֻ��һ������
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

    //��ӽڵ�
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

        if (rightHeight() - leftHeight() > 1) {
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }
            return;
        }

        if (leftHeight() - rightHeight() > 1) {
            if (left != null && left.rightHeight() > left.leftHeight()) {
                left.leftRotate();
                rightRotate();
            } else {
                rightRotate();
            }
        }
    }


    //�������
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

    //�ҵ����ڵ�
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

    // ���� �Ըý��Ϊ���������ĸ߶�
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
        //�����µĽ�㣬�Ե�ǰ������ֵ
        Node node = new Node(value);
        //���µĽ������������óɵ�ǰ����������
        node.left = left;
        //���µĽ������������óɴ����ȥ������������������
        node.right = right.left;
        //�ѵ�ǰ����ֵ�滻�����ӽ���ֵ
        value = right.value;
        //�ѵ�ǰ�������������óɵ�ǰ�����������������
        right = right.right;
        //�ѵ�ǰ����������(���ӽ��)���ó��µĽ��
        left = node;
    }

    public void rightRotate() {
        Node node = new Node(value);
        node.right = right;
        node.left = left.right;
        value = left.value;
        left = left.left;
        right = node;
    }


}