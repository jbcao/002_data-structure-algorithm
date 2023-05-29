package k_algorithm;

/**
 * 功能 动态规划 解决背包问题
 *
 * @author caojianbang
 * @date 3.12.22 4:35 AM
 */
public class CDynamic {
    public static void main(String[] args) {
        int w[] = {1, 4, 3};//物品重量
        int val[] = {1500, 3000, 2000};//物品价值
        int m = 4;//背包容量
        int n = val.length;//物品个数

        //创建数组
        int v[][] = new int[n + 1][m + 1];
        int p[][] = new int[n + 1][m + 1];

        //动态规划
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[i].length; j++) {
                //公式
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        p[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }

            }

        }

        //遍历动态规划后的数组
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        //遍历添加的路径
        int i = v.length - 1;
        int j = v[0].length - 1;
        while (i >= 1 && j >= 0) {
            if (p[i][j] == 1) {
                System.out.printf("第%d个商品放入背包", i);
                j -= w[i - 1];
            }
            i--;
        }

    }
}
