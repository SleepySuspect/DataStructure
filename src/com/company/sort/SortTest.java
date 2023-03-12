package com.company.sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
//        String i = "!2";

        int arr[] = { 53, 3, 542, 748, 14, 214};
        int[] arr2 = new int[10];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(arr2));
        insertSort(arr2);
//        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }

    public static void bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
    }

    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i;
            int insertValue = arr[i];
            while (insertIndex - 1 >= 0 && arr[insertIndex - 1] > insertValue){
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex --;
            }
            if (insertIndex != i){
                arr[insertIndex] = insertValue;
            }
        }
    }
}
