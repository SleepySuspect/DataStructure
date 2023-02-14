package com.company.queue;

import java.util.Scanner;

public class QueueArrDemo {
    public static void main(String[] args) {
        QueueArray queueArray = new QueueArray(4);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("p(peek): 查看队列头的数据");
            String input = scanner.next();
            switch (input){
                case "a":
                    System.out.println("请输入你要添加的数据");
                    int x = scanner.nextInt();
                    queueArray.addQueue(x);
                    break;
                case "g":
                    System.out.println(queueArray.getQueue());
                    break;
                case "p":
                    try{
                        System.out.println(queueArray.peek());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    queueArray.showQueue();
                    break;
                case "e":
                    flag = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("输入错误，请重新输入!");
            }
        }
    }
}

class QueueArray{
    //队头 指向第一个元素
    //队尾 指向最后一个元素的下一个位置   存储数组的数组  最大长度
    private int head;
    private int tail;
    private final int maxSize;
    private final int[] data;

    public QueueArray(int maxSize){
        this.data = new int[maxSize];
        this.head = 0;
        this.tail = 0;
        this.maxSize = maxSize;
    }

    //判空
    public boolean isEmpty(){
        return this.head == this.tail;
    }

    //判满   【预留一个空间，否则无法判断是满还是空】
    public boolean isFull(){
        return (this.tail + 1) % this.maxSize == head;
    }

    //加入队列
    public void addQueue(int x){
        if (isFull()){
            System.out.println("队列已满，无法添加");
        }else {
            this.data[tail] = x;
            tail = (tail + 1) % maxSize;
        }
    }

    //出队
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队空，无法出队~");
        }else {
            int temp = data[head];
            head = (head + 1) % maxSize;
            return temp;
        }
    }

    //当前队列数据个数
    public int size(){
        return (tail + maxSize - head) % maxSize;
    }

    //显示所有队列数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队空...");
        }else {
            for (int i = head; i < head + size(); i++) {
                System.out.print(this.data[i % maxSize] + " ");
            }
            System.out.println();
        }
    }

    //查看队头元素
    public int peek(){
        return this.data[head];
    }



}
