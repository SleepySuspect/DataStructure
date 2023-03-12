package com.company.tree;

import java.util.Arrays;

public class HeapSort {
    //堆排序   大根堆--》升序排列
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9, 1, -1, 90, 78};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 第一次将整个数组调整为大根堆，从第arr.length / 2 - 1个位置开始，不断向左向上调整
     *
     * 在第一次调整的基础上，从上往下判断，如果上层满足是大根堆，下层肯定是大根堆，
     * @param arr
     */
    public static void heapSort(int[] arr){
        //第一次将整个数组调整为大根堆，从第arr.length / 2 - 1个位置开始，不断向左向上调整
        for (int i = arr.length / 2 - 1; i >= 0; i --) {
            adjustHeap(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, i);
        }

    }
    /** 调整大根堆
     * @param arr 待调整的数组
     * @param index 非叶子节点在数组中的索引   【根据非叶子节点调整数组  一层一层向上调整】
     * @param length 表示数组中有多少元素参与调整   这个长度是逐渐减少的
     */
    public static void adjustHeap(int[] arr, int index, int length){
        int temp = arr[index];
        for (int i = 2 * index + 1; i < length; i = i * 2 + 1) {
            if (i + 1 < length && arr[i] < arr[i + 1]){
                i ++;
            }
            if (arr[i] > temp){
                arr[index] = arr[i];
                index = i;
            }else {
                //在第一次调整的基础上，从上往下判断，如果上层满足是大根堆，下层肯定是大根堆，
                break;
            }
        }
        arr[index] = temp;
    }
}
