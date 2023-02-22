package com.company.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {0, 4, 7, 5, 2, 6, 1, 3};
        Date startDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间==>" + simpleDateFormat.format(startDate));
        int[] arr = new int[80];
        for (int i = 0; i < 80; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(bubbleSort(arr)));

        Date endDate = new Date();
        System.out.println("结束时间==》" + simpleDateFormat.format(endDate));
    }
    public static int[] bubbleSort(int[] arr){
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
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
        return arr;
    }
}
