package com.company.recursion;

//8皇后
public class Queen8 {
    int max = 8;
    int[] array = new int[max]; //存放皇后的位置
    int count = 0;
    int judgeCount = 0;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.put(0);

        System.out.println(queen8.judgeCount);
    }

    /**
     * 给第几个皇后找位置
     * @param n
     * @return
     */
    public void put(int n){
        if (n == max){
            count ++;
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)){   //如果放置第n个皇后不冲突  就放置第n + 1个
                put(n + 1);
            }
            //如果冲突  继续循环   把皇后放在下一列
        }
    }


    /**
     * 放置第n个皇后的时候  判断有没有和前边的皇后重复
     * @param n
     * @return
     */
    public boolean judge(int n){
        judgeCount ++;
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                //在同一列或者统已对角线
                return false;
            }
        }
        return true;
    }
}
