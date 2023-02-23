package com.company.recursion;

/**
 * 有一群猴子，去摘了一堆桃子
 * 商量之后决定每天吃剩余桃子的一半
 * 当每天大家吃完桃子之后，有个贪心的小猴都会偷偷再吃一个桃子
 * 按照这样的方式猴子们每天都快乐的吃着桃子
 * 直到第十天，当大家再想吃桃子时，发现只剩下一个桃子了
 * 问：猴子们一共摘了多少桃子
 */

public class Monkey {
    public static void main(String[] args) {
        System.out.println(peach(1));
    }

    /**
     * 第n天有多少个桃子
     * @param n
     * @return
     */
    public static int peach(int n){
        if (n == 10){
            return 1;
        }else {
            return (peach(n + 1) + 1) * 2;
        }
    }
}
