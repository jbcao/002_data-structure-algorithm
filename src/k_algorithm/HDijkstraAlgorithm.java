package k_algorithm;

import java.util.Arrays;

/**
 * @author caojianbang
 * @version 1.0
 * @description 地杰斯特拉算法求最短路径
 * @date 2022/12/20/0020 13:41
 */
public class HDijkstraAlgorithm {
    public static void main(String[] args) {
char[] vertex= { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
int[][] matrix= new int[vertex.length][vertex.length];
final int N = 65535;
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        Graphy graphy = new Graphy(vertex,matrix);
        graphy.djs(6);
        graphy.show();
    }
}

//为了区分和前面的graph，所以取了这个名字，实际一样
class Graphy {
    //顶点  邻接矩阵  访问过节点集合
    private char[] vertex;
    private int[][] matrix;
    private VisitedVertex vv;

    //构造器 直接给的，简单一点
    public Graphy(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }
     //地杰斯特拉算法
    public void djs(int index){
        //初始化vv
        vv=new VisitedVertex(vertex.length,index);
        //跟新出发顶点到周围的距离和前驱  dis  pre
        update(index);
        System.out.println("当前dis"+Arrays.toString(vv.dis));
        for (int i = 1; i <vertex.length ; i++) {
            index=vv.updateArr();
            update(index);
            System.out.println("当前dis"+Arrays.toString(vv.dis));
        }
        System.out.println();
    }
    //更新顶点的dis  pre
    private void update(int index){
        int len = 0;
        //遍历该行
        for (int i = 0; i <matrix[index].length ; i++) {
            len=vv.getDis(index)+matrix[index][i];//出发点到index的距离+index到j的距离
            if(!vv.in(i)&&len<vv.getDis(i)){
                //更新dis pre
                vv.updateDis(i,len);
                vv.updatePre(i,index);
            }
        }
    }
    //用于显示的方法
    public void show(){
        vv.show();
    }
    }

//访问过的集合
class VisitedVertex {
    //是否访问 距离 前驱
    private int[] alreardy;
    public int[] dis;
    private int[] pre;

    //构造器
    /**
     * @param length 顶点个数
     * @param index  出发顶点下表
     */
    public VisitedVertex(int length, int index) {
        this.alreardy = new int[length];
        this.dis = new int[length];
        this.pre = new int[length];
        //初始化already
        this.alreardy[index] = 1;//1访问过，0未访问
        Arrays.fill(dis, 65535);
        dis[index] = 0;
    }

    //获得是否访问过
    public boolean in(int index) {
        return alreardy[index] == 1;
    }


    //获得距离
    public int getDis(int index) {
        return dis[index];
    }
    //更新距离

    /**
     * @param index  出发点到index的距离
     * @param length
     */
    public void updateDis(int index, int length) {
        dis[index] = length;
    }

    //跟新前驱
    public void updatePre(int pre, int index) {
        this.pre[pre] = index;

    }

    //获得新的未访问过的节点
    public int updateArr(){
        int min=65535,index=0;
        for (int i = 0; i <alreardy.length ; i++) {
            if(alreardy[i]==0&&dis[i]<min){
                index=i;
                break;
               // min=dis[i];
            }
        }
        //设置已经访问过
        alreardy[index]=1;
        return index;
    }
    //用于显示
    public void show(){
        System.out.println("===============");
        System.out.println("already");
        for (int i:alreardy
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("dis");
        for (int i:dis
                ) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("pre");
        for (int i:pre
                ) {
            System.out.print(i+" ");
        }
        System.out.println();
        //好看最后的最短距离
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int count=0;
        for (int i: dis) {
           if(i!=65535){
               System.out.print(vertex[count]+"("+i+")");
           }else {
               System.out.print("N");
           }
           count++;
        }
    }
}