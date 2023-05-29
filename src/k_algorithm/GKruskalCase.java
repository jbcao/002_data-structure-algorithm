package k_algorithm;

import java.util.Arrays;

/**
 * @author caojianbang
 * @version 1.0
 * @description 克鲁斯卡尔算法
 * @date 2022/12/14/0014 9:05
 */
public class GKruskalCase {
    public static void main(String[] args) {
        //顶点
        char vertex[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //邻接矩阵
        int matrx[][] =
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {{0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};
        GKruskalCase kruskalCase = new GKruskalCase(vertex, matrx);
        kruskalCase.print();
        //克鲁斯卡尔
        kruskalCase.kruskal();

    }

    //边 定点 邻接矩阵
    private int edgeNum;
    private char[] vertex;
    private int[][] matrix;
    //不能联通
    private static final int INF = Integer.MAX_VALUE;

    //1.构造器
    public GKruskalCase(char[] vertex, int[][] matrix) {
        //初始化顶点和边
        int vlen = vertex.length;

        //初始化顶点
        this.vertex = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertex[i] = vertex[i];
        }

        //初始化边
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        //统计边长度
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    //2.打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵");
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    //3.排序 采用冒泡
    public void sortEdges(EData edges[]) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight >edges[j + 1].weight) {
                    EData tmp = edges[j + 1];
                    edges[j + 1]= edges[j];
                    edges[j]= tmp;
                }
            }
        }
    }

    //4.获取顶点的位置
    public int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    //5.获取边的数组
    private EData[] getEdges() {
        int index = 0;
        EData edges[] = new EData[edgeNum];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i+1; j < vertex.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    //6.获得终点
    private int getEnd(int ends[], int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }
    //7.克鲁斯卡尔
    public void kruskal(){
        int index=0;//临时变量，后面会用到
        //存放终点
        int end[] =new int[edgeNum];
        //边对象
        EData edges[]=getEdges();
        //保留最小生成树，也是边队形
        EData res[] = new EData[edgeNum];
        //打印原来边的集合
        System.out.println("图中变得集合="+ Arrays.toString(edges)+"共"+edges.length+"条边");
        //排序
        sortEdges(edges);
        System.out.println("图中变得集合="+ Arrays.toString(edges)+"共"+edges.length+"条边");
        //遍历边对象，
        for (int i = 0; i <edgeNum ; i++) {
            //得到第i个边的第一个顶点
            int p1 = getPosition(edges[i].start);
            int p2 = getPosition(edges[i].end);
            //获得这两个顶点的终点
            int m = getEnd(end,p1);
            int n = getEnd(end,p2);
            //判断顶点是否重合
            if(m!=n){
                end[m]=n;
                res[index++]=edges[i];
            }
        }
        //打印最小生成树
        System.out.println("生成的最小生成树为：");
        for (int i = 0; i <index ; i++) {
            System.out.println(res[i]);
        }
    }
}

//边的类
class EData {
    //第一个边 第二个边 权值
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
