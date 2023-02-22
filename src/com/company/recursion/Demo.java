package com.company.recursion;

public class Demo {
    public static void main(String[] args) {
        print(5);
        System.out.println(fal(5));

    }

    /**
     * 阶乘求解
     * @param n
     * @return
     */
    public static int fal(int n){
        if (n == 1){
            return 1;
        }
        return fal(n - 1) * n;
    }

    /**
     * 分析打印过程
     * @param n
     */
    public static void print(int n){
        if (n > 1){
            print(n -1);
        }
        System.out.println(n);
    }
}
