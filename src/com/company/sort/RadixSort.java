package com.company.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
//        int arr[] = { 53, 3, 542, 748, 14, 214};
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(radixSort(arr)));
    }

    /**
     * 基数排序
     * @param arr
     * @return
     */
    public static int[] radixSort(int[] arr){
        //得到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //定义10个桶
        int[][] bucket = new int[arr.length][10];
        //定义数组  代表十个桶中  数据个数
        int[] bucketElementCount = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //将数据放入桶中
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[bucketElementCount[digitOfElement]][digitOfElement] = arr[j];
                bucketElementCount[digitOfElement] ++;
            }

            //将数据从桶中取出
            int index = 0;     //arr指针
            for (int j = 0; j < 10; j++) {
                if (bucketElementCount[j] != 0){
                    //说明桶中有数据    [按添加顺序将桶中元素放入原数组]
                    for (int k = 0; k < bucketElementCount[j]; k++) {
                        arr[index ++] = bucket[k][j];
                    }
                }
                bucketElementCount[j] = 0;
            }
        }
        return arr;
    }
}
