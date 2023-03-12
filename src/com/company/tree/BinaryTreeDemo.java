package com.company.tree;

/**
 * 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode hero2 = new HeroNode(2, "卢俊义");
        HeroNode hero3 = new HeroNode(3, "吴用");
        HeroNode hero4 = new HeroNode(4, "公孙胜");
        HeroNode hero5 = new HeroNode(5, "关胜");

        //手动创建二叉树
        root.setLeft(hero2);
        root.setRight(hero3);
        hero3.setRight(hero4);
        hero3.setLeft(hero5);
        binaryTree.setRoot(root);
        binaryTree.preOrder(root);

        binaryTree.del(3);
        System.out.println(binaryTree.preOrderSearch(4));
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(HeroNode root){
        if (root == null){
            return;
        }
        root.preOrder();
    }

    public HeroNode preOrderSearch(int no){
        if (root == null){
            return null;
        }
        return root.preOrderSearch(no);
    }

    public void del(int no){
        if (root != null && root.getNo() == no){
            root = null;
            return;
        }
        if (root != null){
            root.del(no);
        }

    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;        //默认为空
    private HeroNode right;         //默认为空

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
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }
        if (this.right != null){
            this.right.preOrder();
        }
    }

    public HeroNode preOrderSearch(int no){
        if (this.no == no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null){
            return resNode;
        }
        if (this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public void del(int no){
        if (this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        if (this.left != null){
            this.left.del(no);
        }
        if (this.right != null){
            this.right.del(no);
        }
    }
}
