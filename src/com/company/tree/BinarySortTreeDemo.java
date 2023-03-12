package com.company.tree;

import java.awt.font.TextHitInfo;

/**
 * 二叉排序树
 *
 * md二叉树删除太难写了...
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9, 2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0 ; i < arr.length ; i ++){
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.delNode(12);
        binarySortTree.delNode(5);
        binarySortTree.delNode(2);
        binarySortTree.delNode(9);
        binarySortTree.delNode(1);
        binarySortTree.delNode(10);
        binarySortTree.delNode(7);
        binarySortTree.delNode(3);
        binarySortTree.preOrder();
    }
}

class BinarySortTree{
    private Node root;

    public void preOrder(){
        if (root == null){
            System.out.println("二叉排序树为空！！");
        }else {
            root.preOrder();
        }
    }

    public void add(Node node){
        if (root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public Node search(int value){
        if (root == null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root == null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    /**
     * 删除以node为根节点的树   最左边的值
     * @param root  根节点
     * @return
     */
    public int delLeftMinTree(Node root){
        Node p = root;
        while (p.getLeft() != null){
            p = p.getLeft();
        }
        delNode(p.getValue());
        return p.getValue();
    }

    //删除节点
    public void delNode(int value) {
        if (root == null){
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode == null){
                return;
            }
            if (root.getLeft() == null && root.getRight() == null){
                //在找到被删除节点   且整棵树只有根节点的时候   根节点就是待删除节点
                root = null;
                return;
            }
            Node parent = searchParent(value);
            if (targetNode.getRight() == null && targetNode.getLeft() == null){
                //待删除节点  为叶子节点   直接删除即可
                if (parent.getLeft() == targetNode){
                    parent.setLeft(null);
                }else {
                    parent.setRight(null);
                }
            }else if(targetNode.getLeft() != null && targetNode.getRight() != null){
                //待删除结点有两个子节点
                int rightTreeMin = delLeftMinTree(targetNode.getRight());
                targetNode.setValue(rightTreeMin);
            }else {
                //待删除节点有一个子节点
                if (targetNode.getLeft() != null){ //待删除节 左子节点 不为空
                    if (parent == null){ //当书中只剩下两层节点【待删除节点和他的子节点，此使parent为空，加入判断，否则报错】
                        root = targetNode.getLeft();
                    }else {
                        if (parent.getLeft().getValue() == value){
                            //待删除节点是父节点的左子节点
                            parent.setLeft(targetNode.getLeft());
                        }else {
                            parent.setRight(targetNode.getLeft());
                        }

                    }
                }else { //待删除节点的右子节点不为空
                    if (parent == null){
                        root = targetNode.getRight();
                    }else {
                        if (parent.getLeft().getValue() == value){
                            //待删除节点是父节点的左子节点
                            parent.setLeft(targetNode.getRight());
                        }else {
                            parent.setRight(targetNode.getRight());
                        }
                    }
                }
            }
        }


    }
}

class Node{
    private int value;
    private Node left;
    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public void add(Node node){
        if (node == null)
            return;
        if (this.value > node.value){
            if (this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null){
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    public Node search(int value){
        if (this.value == value){
            return this;
        }else if (this.value > value){ //去左子树查询
            if (this.left == null){
                return null;
            }else {
                return this.left.search(value);
            }

        }else {
            if (this.right != null){
                return this.right.search(value);
            }else {
                return null;
            }
        }
    }

    public Node searchParent(int value){
        //如果当前节点就是要删除节点的父节点
        if((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)){
            return this;
        }else {
            if (this.left != null && this.value > value){
                return this.left.searchParent(value);
            }else if(this.right != null && this.value < value){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }
}
