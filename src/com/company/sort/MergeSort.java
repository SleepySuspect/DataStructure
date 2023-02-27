package com.company.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {-9,78,0,23,-567,70, -1,900};
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        int[] temp = new int[100];
        mergeSort(arr, 0, 99, temp);
        System.out.println(Arrays.toString(temp));
    }

    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param temp   辅助数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp){
        if (left < right){
            int mid = (left + right)/2;
            //向左   递归分解
            mergeSort(arr, left, mid, temp);

            //向右递归分解
            mergeSort(arr, mid + 1, right, temp);

            //递归分解完成  开始合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 合并两个  有序子序列
     * @param arr
     * @param left     第一个有序子序列左指针
     * @param mid      第一个有序子序列最后一个元素
     * @param right
     * @param temp
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int l = left;
        int r = mid + 1;       //第二个序列的头
        int index = 0;            //指向temp
        while (l <= mid && r <= right){
            if (arr[l] <= arr[r]){
                temp[index] = arr[l];
                l ++;
            }else {
                temp[index] = arr[r];
                r ++;
            }
            index ++;
        }

        while (l <= mid){
            temp[index ++] = arr[l ++];
        }

        while (r <= right){
            temp[index ++] = arr[r ++];
        }

        //将temp元素拷贝到原arr中  注意不是拷贝所有元素
        index = 0;
//        int tempLeft = left;
        while (left <= right){
            arr[left] = temp[index];
            index ++;
            left ++;
        }
    }
}
