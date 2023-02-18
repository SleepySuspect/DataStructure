package com.company.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);

        //入栈
        arrayStack.push(12);
        arrayStack.push(1324);
        arrayStack.push(32);
        arrayStack.push(32);
        arrayStack.show();

        System.out.println(arrayStack.peek() + "栈顶元素");
        //出栈
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("$$$$$$$$$$");
        arrayStack.show();

    }
}

class ArrayStack{
    private int top = -1;
    private int[] data;
    private int maxSize;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        this.data = new int[maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return this.data.length - 1 == top;
    }

    //判断栈空
    public boolean isEmpty(){
        return this.top == -1;
    }

    //输出栈所有元素
    public void show(){
        if (isEmpty()){
            System.out.println("栈空");
        }else {
            for (int i = 0; i <= this.top; i++) {
                System.out.println(this.data[i]);
            }
        }
    }

    //入栈
    public void push(int x){
        if (!isFull()){
            this.data[++ top] = x;
        }else {
            System.out.println("栈满！！无法添加");
        }
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }else {
            int temp = this.data[top];
            top --;
            return temp;
        }
    }

    //输出栈顶元素
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("栈空");
        }else {
            return this.data[top];
        }
    }

}
