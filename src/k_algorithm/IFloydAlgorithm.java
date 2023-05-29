package k_algorithm;

import java.util.Arrays;

/**
 * @author caojianbang
 * @version 1.0
 * @description
 * @date 2022/12/29/0029 16:47
 */
public class IFloydAlgorithm {
    public static void main(String[] args) {
        char[] vertex={ 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix= new int[vertex.length][vertex.length];
        final int N =65535;
        matrix[0]=new int[]{ 0, 5, 7, N, N, N, 2 };
        matrix[1] = new int[] { 5, 0, N, 9, N, N, 3 };
        matrix[2] = new int[] { 7, N, 0, N, 8, N, N };
        matrix[3] = new int[] { N, 9, N, 0, N, 4, N };
        matrix[4] = new int[] { N, N, 8, N, 0, 5, 4 };
        matrix[5] = new int[] { N, N, N, 4, 5, 0, 6 };
        matrix[6] = new int[] { 2, 3, N, N, 4, 6, 0 };
        Grapy graphy = new Grapy(vertex,matrix,vertex.length);
        graphy.floyd();
        graphy.show();
    }
}

class Grapy {
    //顶点 距离 前驱
    private char[] vertex;
    private int[][] dis;
    private int[][] pre;


    //构造方法
    public Grapy(char[] vertex, int[][] martex, int length) {
        this.vertex = vertex;
        this.dis = martex;
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) {
            Arrays.fill(pre[i], i);
        }
    }
    //显示
    public void show(){
        char[] vertex= {'A','B','C','D','E','F','G'};
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                System.out.print(vertex[i]+"到"+vertex[j]+"最短路径"+dis[i][j]+" ");
            }
            System.out.println();
            for (int j = 0; j <pre.length ; j++) {
                System.out.print(vertex[pre[i][j]]);
            }
            System.out.println();
            System.out.println();
        }
    }

    //floyd算法
    public void floyd(){
        int len=0;
        for (int k = 0; k < dis.length; k++) {
            for (int i = 0; i < dis.length; i++) {
                for (int j = 0; j < dis.length; j++) {
                    len=dis[i][k]+dis[k][j];
                    if(len<dis[i][j]){
                        dis[i][j]=len;
                        pre[i][j]=pre[k][j];
                    }
                }
            }
        }
    }

}