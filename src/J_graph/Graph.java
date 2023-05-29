package J_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 功能  图
 *
 * @author caojianbang
 * @date 1.12.22 12:14 AM
 */
public class Graph {
    private int numOfEdges;
    //vertex list
    private ArrayList<String> vertexList;
    private int[][] edges;//save edges
    private boolean[] isVisited;
    public static void main(String[] args) {
        String[] a = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(5);
        //add vertex
        for (int i = 0; i < a.length; i++) {
            graph.addVertex(a[i]);
        }
        //add edge
        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(2, 1, 1);
        graph.addEdges(3, 1, 1);
        graph.addEdges(4, 1, 1);
        System.out.println("show graph");
        graph.showGraph();
        //dfs
        System.out.println("dfs");
        graph.dfs();
        System.out.println();
        System.out.println("bfs");
        graph.bfs();
    }
    //get first negibhor
    public int getFirstNeighbor(int v1) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }
    //get next neighbor
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i <edges.length ; i++) {
            if(edges[v1][i]>0){
                return i;
            }
        }
        return -1;
    }


//dfs
    public void dfs(boolean[] isVisited, int i){
        System.out.print(getValueByIndex(i)+"->");
        isVisited[i]=true;
        int w =getFirstNeighbor(i);
        while(w!=-1){
            if(!isVisited[w]){
                dfs(isVisited,w);
            }
            w=getNextNeighbor(i,w);
        }
    }
    public void dfs(){
        isVisited=new boolean[vertexList.size()];
        for (int i = 0; i <vertexList.size() ; i++) {
            if(!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //bfs
    public  void bfs(){
        isVisited= new boolean[vertexList.size()];
        for (int i = 0; i <vertexList.size() ; i++) {
            if (!isVisited[i]) {
                bfs(isVisited,i);
            }
        }
    }
    public void bfs(boolean isvisited[],int i){
        int u;
        int w;
        //record the sequence of visiting
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i)+"->");
        queue.addLast(i);
        isvisited[i]=true;
        while(!queue.isEmpty()){
            u = (Integer) queue.removeFirst();
            w=getFirstNeighbor(u);
            while (w!=-1){
                if(!isvisited[w]){
                    System.out.print(getValueByIndex(w)+"->");
                    isvisited[w]=true;
                    queue.addLast(w);
                }
                w=getNextNeighbor(u,w);
            }
        }
    }




    //construntor
    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.numOfEdges = 0;
    }
    //number of edges
    public int getNumOfEdges() {
        return numOfEdges;
    }
    //number of vertex
    public int getNumOfVertex() {
        return vertexList.size();
    }



    //get vaule by index
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //get weight
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //show graph
    public void showGraph() {
        for (int[] a : edges) {
            System.out.println(Arrays.toString(a));

        }
    }

    //add vertex
    public void addVertex(String vertex) {
        vertexList.add(vertex);
    }

    //add edges
    public void addEdges(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
