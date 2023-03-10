package com.company.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 9, 11, -1, 34, 89 };// 没有顺序的数组
        System.out.println(seqSearch(arr, 89));
    }
    public static int seqSearch(int[] arr, int x){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x){
                return i;
            }
        }
        return -1;
    }
}
