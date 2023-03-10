package com.company.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 1、必须有序  才能使用二分查找
 * 2、返回所有的相同值
 */
public class BinarySort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234, 1234, 1234, 1234};
//        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(search(arr, 0, arr.length, 1234));
    }

    public static List<Integer> search(int[] arr, int left, int right, int x){
        if (left > right){
            return null;
        }
        int mid = (left + right) / 2;
        if (x < arr[mid]){
            return search(arr, 0, mid - 1, x);
        }else if (x > arr[mid]){
            return search(arr, mid + 1, right, x);
        }else {
            ArrayList<Integer> res = new ArrayList<>();
            int index = mid - 1;
            while (true){
                if (index < 0 || arr[index] != x){
                    break;
                }
                res.add(index);
                index --;
            }
            res.add(mid);
            index = mid + 1;
            while (true){
                if (index >= arr.length || arr[index] != x){
                    break;
                }
                res.add(index);
                index ++;
            }
            return res;
        }
    }
}
