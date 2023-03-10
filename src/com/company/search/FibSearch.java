package com.company.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibSearch {
    private static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 89));
    }

    /**
     * 非递归方式
     * @param arr
     * @param value
     * @return
     */
    public static int fibSearch(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid;
        int[] f = getFib();

        while (high > f[k] - 1){
            k ++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high){
            mid = low + f[k - 1] -1;
            if (value < arr[mid]){
                //向左查找
                high = mid - 1;
                k --;
            }else if(value > arr[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if (mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }

    public static int[] getFib(){
        int[] fib = new int[maxSize];
        if (maxSize > 1){
            fib[0] = 1;
        }
        if (maxSize > 2){
            fib[1] = 1;
        }
        for (int i = 2; i < maxSize - 1; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }
}
