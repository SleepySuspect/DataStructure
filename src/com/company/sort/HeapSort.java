package com.company.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }


        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr, 0, i);

        }
    }

    /**
     * 将数组调整为大根堆
     * @param arr
     * @param index  非叶子节点在数组中的索引
     * @param length   二叉树的节点数   【调整过程中 数量追减减少】
     */
    public static void adjustHeap(int[] arr, int index, int length){
        int temp = arr[index];
        for (int i = index * 2 + 1; i < length; i = 2 * index + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]){
                i ++;
            }
            if (arr[i] > temp){
                arr[index] = arr[i];
                index = i;
            }else {
                break;
            }
        }
        arr[index] = temp;
    }
}
