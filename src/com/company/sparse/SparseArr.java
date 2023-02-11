package com.company.sparse;

public class SparseArr {
    public static void main(String[] args) {
        int chessArr[][] = new int[6][6];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 1;
        chessArr[5][4] = 1;
        chessArr[0][0] = 1;
        print(chessArr);
        int[][] sparseArr = arrayToSparse(chessArr);


        System.out.println("#$#############################");
        sparseToArray(sparseArr);
    }

    /**
     * 二维数组转换为稀疏数组
     * @param arr
     * @return
     */
    public static int[][] arrayToSparse(int[][] arr){
        int count = 0;      //count表示一共有多少非0元素
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0)
                    count ++;
            }
        }
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = count;
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0){
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = arr[i][j];
                    index ++;
                }
            }
        }
        print(sparseArr);
        return sparseArr;
    }

    /**
     * 稀疏数组转化为方形数字
     * @param sparseArr
     * @return
     */
    public static int[][] sparseToArray(int[][] sparseArr){
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i = 1; i <= sparseArr[0][2]; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        print(arr);
        return arr;
    }

    public static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
