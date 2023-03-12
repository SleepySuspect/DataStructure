package com.company.sort;

public class SleepSort implements Runnable{
    private String num;
    public static void main(String[] args) {
        int arr[] = { 13, 3, 2, 6, 14, 1};
        for (int i = 0; i < arr.length; i++) {
            new Thread(new SleepSort(arr[i])).start();
        }
    }

    public SleepSort(int num){
        this.num = num + "";
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num) * 100);
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
