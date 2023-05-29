package k_algorithm;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author caojianbang
 * @version 1.0
 * @description 马踏棋盘算法+贪心算法优化
 * @date 2023/1/09/0009 15:31
 */
public class JHorseChessboard {
    //    行数 列数
    private static int X;//列
    private static int Y;//行
    //位置是否访问过
    private static boolean visited[];
    //是否所有位置走完
    private static boolean finished;

    public static void main(String[] args) {
        System.out.println("start...");
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        //创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        //测试耗时
        long start = System.currentTimeMillis();
        travelChessboard(chessboard, row - 1, column - 1, 1);
        long end = System.currentTimeMillis();
        System.out.println("spend" + (end - start) + "");
        for (int[] link : chessboard
                ) {
            for (int i = 0; i < link.length; i++) {
                System.out.print(link[i] + "\t");
            }
            System.out.println();
        }

    }

    /**
     * 根据当前位置 计算能走哪些位置 并放入到一个集合中
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        //创建一个point
        //判断 八个位置 ，可以的话就存入集合
        ArrayList<Point> ps = new ArrayList<>();
        Point p = new Point();
        //位置 5
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        //位置6
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        //位置7
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p));
        }
        //位置0
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p));
        }
        //位置1
        if ((p.x = curPoint.x + 2) < X && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        //位置2
        if ((p.x = curPoint.x + 1) < X && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        //位置3
        if ((p.x = curPoint.x - 1) >= 0 && (p.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p));
        }
        //位置4
        if ((p.x = curPoint.x - 2) >= 0 && (p.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p));
        }
        return ps;
    }

    //完成骑士周游问题的算法
    //参数 棋盘 当前位置 步数
    public static void travelChessboard(int[][] chessboard, int row, int column, int step) {
        //标记步骤
        chessboard[row][column] = step;
        //标记访问过
        visited[row * X + column] = true;
        //获取当前可以走的下一个集合的位置
        ArrayList<Point> ps = next(new Point(column, row));
        //排序
        sort(ps);
        //遍历ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);
            //判断该位置是否被访问过
            if (!visited[p.y * X + p.x]) {
                travelChessboard(chessboard, p.y, p.x, step + 1);
            }
        }
        /**
         * 判断马儿是否完成的任务
         * 1 棋盘到目前位置 没有走完
         * 2 棋盘处于一个回溯过程
         */
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }

    //用贪心算法进行优化
    public static void sort(ArrayList<Point> ps) {
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1 < count2) {
                    return -1;
                } else if (count1 == count2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }
}
