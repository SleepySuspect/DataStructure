package com.company.search;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234, 1234, 1234, 1234};
//        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(insertSearch(arr, 0, arr.length -1, 1234));
    }

    public static int insertSearch(int[] arr, int left, int right, int value){
        if (left > right || arr[left] > value || arr[right] < value)      //必须添加，否则出现越界错误
            return -1;
        int l = left;
        int r = right;
        int mid = left + (right - left) * (value - arr[l]) / (arr[right] - arr[left]);
        if(arr[mid] < value){
            return insertSearch(arr, mid + 1, r, value);
        }else if(arr[mid] > value){
            return insertSearch(arr, l, mid - 1, value);
        }else {
            return mid;
        }
    }
}
