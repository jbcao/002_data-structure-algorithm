package k_algorithm;



import java.util.Arrays;

/**
 * 功能 普利姆算法
 *
 * @author caojianbang
 * @date 10.12.22 5:28 AM
 */
public class FPrimAlgorithm {
    public static void main(String[] args) {
        char data[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int vertes = data.length;
        int weight[][] = new int[][]{{10000, 5, 7, 10000, 10000, 10000, 2},
        { 5, 10000, 10000, 9, 10000, 10000, 3},
        { 7, 10000, 10000, 10000, 8, 10000, 10000},{
            10000, 9, 10000, 10000, 10000, 4, 10000
        },{
            10000, 10000, 8, 10000, 10000, 5, 4
        },{
            10000, 10000, 10000, 4, 5, 10000, 6
        },{
            2, 3, 10000, 10000, 4, 6, 10000
        },};
Graph graph = new Graph(vertes);
MinTree minTree = new MinTree();
minTree.createGraph(graph,vertes,data,weight);
minTree.showGraph(graph);
minTree.prim(graph,0);

}
}

class MinTree {//最小生成树

    //构造树
    public void createGraph(Graph graph, int vertex, char[] data, int weight[][]) {
        int i, j = 0;

        graph.vertex = vertex;
        for (i = 0; i < vertex; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < vertex; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //遍历树
    public void showGraph(Graph graph) {
        for (int[] link : graph.weight
                ) {
            System.out.println(Arrays.toString(link));
        }
    }
    //普利姆算法
    public void prim(Graph graph,int v){
        //存放被访问的记录
        int isVisited[] = new int[graph.vertex];

        //1访问过  0没访问过
        isVisited[v]=1;
         int v1=-1;
         int v2=-1;
         int min =  10000;
        for (int k =1 ; k <graph.vertex ; k++) {
            for (int i = 0; i <graph.vertex ; i++) {
                for (int j=0;j<graph.vertex;j++){
                    if(isVisited[i]==1&&isVisited[j]==0&&graph.weight[i][j]<min){
                        min=graph.weight[i][j];
                        v1=i;
                        v2=j;
                    }
                }
            }
            System.out.println("边"+graph.data[v1]+" "+graph.data[v2]+"权值"+min);
            isVisited[v2]=1;
            min=10000;
        }

    }


}

//存放图
class Graph {
    int vertex;//顶点
    char[] data;//数据
    int weight[][];//邻接矩阵

    //构造方法
    public Graph(int vertex) {
        this.vertex = vertex;
        data = new char[vertex];
        weight = new int[vertex][vertex];
    }
}