package com.company.recursion;

import netscape.security.UserTarget;

public class MiGong {
    public static void main(String[] args) {
        //创建地图  地图约定
        //1 墙        2 此路可通        3该点走过，但是不通       0该点没有走过
        int[][] map = new int[8][7];
        //0 6 列设置为墙
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        //1 7行设置为墙
        for (int i = 0; i < map[0].length; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        //设置障碍物
        map[3][1] = 1;
        map[3][2] = 1;


        Boolean way = findWay(map, 1, 1);
        System.out.println(way);
        show(map);

    }

    /**
     * 通过递归给小球找路  ij表示小球的初始位置   终点默认为右下角
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static Boolean findWay(int[][] map, int i, int j){
        if (map[6][5] == 2){
            return true;
        }else {
            if (map[i][j] == 0){
                //假设该点可以走通
                //如果该点没有走过   按照下右上左逻辑开始走
                map[i][j] = 2;
                if (findWay(map, i + 1, j)){
                    return true;
                }else if (findWay(map, i, j + 1)){
                    return true;
                }else if (findWay(map, i - 1, j)){
                    return true;
                }else if (findWay(map, i, j - 1)){
                    return true;
                }else {
                    map[i][j] = 3;      //此路不通
                    return false;
                }
            }else {
                // 1 2 3 分别代表  墙  可以走通  走过，但是不通
                return false;
            }
        }
    }

    /**
     * 遍历地图
     * @param map
     */
    public static void show(int[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
