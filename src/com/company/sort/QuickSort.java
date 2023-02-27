package com.company.sort;

import java.util.Arrays;

/**
 * 冒泡 选择 插入 希尔（交换式、插入式） 快排 堆排序 基数
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
//        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];

        while (l < r){
            while (arr[l] < pivot){
                l ++;
            }
            while (arr[r] > pivot){
                r --;
            }

            if(l >= r){
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == pivot){
                r --;
            }
            if (arr[r] == pivot){
                l ++;
            }
        }

        if (l == r){
            l ++;
            r --;
        }

        //向左向右递归
        if (left < r){
            quickSort(arr, left, r);
        }
        if (l < right){
            quickSort(arr, l, right);
        }
    }
}
