package com.company.linkedlist;

import java.util.ArrayList;

//循环单链表解决约瑟夫问题
public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        Boy boy1 = new Boy(1, "张三1");
        Boy boy2 = new Boy(2, "张三2");
        Boy boy3 = new Boy(3, "张三3");
        Boy boy4 = new Boy(4, "张三4");
        Boy boy5 = new Boy(5, "张三5");

        ArrayList<Boy> boys = new ArrayList<>();
        boys.add(boy1);
        boys.add(boy2);
        boys.add(boy3);
        boys.add(boy4);
        boys.add(boy5);

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(boy1);
        circleSingleLinkedList.add(boy2);
        circleSingleLinkedList.add(boy3);
        circleSingleLinkedList.add(boy4);
        circleSingleLinkedList.add(boy5);

//        circleSingleLinkedList.show();
        circleSingleLinkedList.joseph(5, 1, 2);
    }
}

class CircleSingleLinkedList{
    private Boy head = null;

    /**
     * 约瑟夫问题求解
     * @param size  一共有多少个孩子
     * @param start 从哪个孩子开始
     * @param countNum 一轮数几个数
     */
    public void joseph(int size, int start, int countNum){

        //先进行数据校验
        if (head == null || start > size || size < 1){
            System.out.println("初始化参数有误，无法继续...");
            return;
        }

        //创建一个辅助指针  指向对头的前一个位置
        Boy helper = head;
        while (helper.getNext() != head){
            helper = helper.getNext();
        }

        //first helper 分别向前走start - 1
        for (int i = 0; i < start - 1; i++) {
            helper = helper.getNext();
            head = head.getNext();
        }

        //循环出队  直到剩下最后一个元素
        while (true){
            if (head == helper){
                break;
            }
            //小孩开始报数
            for (int i = 0; i < countNum - 1; i++) {
                helper = helper.getNext();
                head = head.getNext();
            }
            System.out.println(head.toString() + "------>出队");
            head = head.getNext();
            helper.setNext(head);
        }
        System.out.println("最后留在队中的小孩：" + head.toString());
    }

    /**
     * 添加到单链表最后
     * @param boy
     */
    public void add(Boy boy){

        if (head == null){    //链表为空时
            head = boy;
            boy.setNext(boy);
            return;
        }
        Boy p = head;
        while (p.getNext() != head){
            p = p.getNext();
        }
        //将p移动到循环单链表的最后位置
        p.setNext(boy);
        boy.setNext(head);
    }

    /**
     * 遍历循环单链表
     */
    public void show(){
        Boy p = head;
        while (p.getNext() != head) {
            System.out.println(p);
            p = p.getNext();
        }
        System.out.println(p);
    }
}

class Boy{
    private int id;
    private String name;
    private Boy next;

    public Boy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


