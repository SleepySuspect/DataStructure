package com.company.sort;

import java.util.Arrays;

//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {0, 4, 7, 5, 2, 6, 1, 3};
        System.out.println(Arrays.toString(insertSort(arr)));
    }

    public static int[] insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            if (insertIndex != i)    //优化  待插入元素与前半段有序序列加起来的序列也是有序的  可以减少一次移动
                arr[insertIndex + 1] = insertValue;
        }
        return arr;
    }
}
