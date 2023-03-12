package com.company.tree;

//数组存储  完全二叉树
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
    }
}

class ArrBinaryTree{
    public int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("二叉树为空~");
        }
        System.out.println(arr[index]);

        //向左递归
        if (2 * index + 1 < arr.length)
            preOrder(2 * index + 1);

        if (2 * index + 2 < arr.length)
        preOrder(2 * index + 2);
    }
}
