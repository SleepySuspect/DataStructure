package com.company.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//选择排序
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {0, 4, 7, 5, 2, 6, 1, 3};
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间" + simpleDateFormat.format(date));
        System.out.println(Arrays.toString(selectSort(arr)));



        Date date1 = new Date();
        System.out.println("结束时间" + simpleDateFormat.format(date1));
    }

    //选择排序
    public static int[] selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i){          //优化  减少交换次数
                //将本轮最小的和 第一个进行交换
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }
}
