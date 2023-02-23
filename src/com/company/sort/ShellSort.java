package com.company.sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(shellSort2(arr)));
    }
    
    public static int[] shellSort(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i ++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]){
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public static int[] shellSort2(int[] arr){
        for (int gap = arr.length; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int minIndex = i;
                int min = arr[i];

                while (minIndex - gap >= 0 && min < arr[minIndex - gap]){
                    arr[minIndex] = arr[minIndex - gap];
                    minIndex -= gap;
                }

                arr[minIndex] = min;
            }
        }
        return arr;
    }
}
