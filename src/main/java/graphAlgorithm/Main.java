package graphAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodongluo on 2018/9/7.
 */
public class Main {
    public int matrix[][];//邻接矩阵
    public int vertex[];//每个节点所带的信息

    private int vertexNum;//节点数目
    private int[] visitedCount;         //记录访问
    private int[] currDist;             //最短路径算法中用来记录每个节点的当前路径长度.

    public Main(int[][] matrix,int[] vertex){
        if(matrix.length!=matrix[0].length){
            throw new IllegalArgumentException("the matrix is not adjacency matrix");
        }
        if(matrix.length!=vertex.length){
            throw new IllegalArgumentException("the vertex length is not same as matrix length");
        }
        this.matrix = matrix;
        this.vertex = vertex;
        vertexNum = vertex.length;
        visitedCount = new int[vertexNum];
    }

    public Queue<Integer> breadthFirstSearch(){
        initVisitedCount();
        Queue<Integer> queue=new LinkedList<>();
        int begin =-1;
        while ((begin=findNotVisited())!=-1){
            visitedCount[begin] = 1;
            queue.offer(vertex[begin]);
            Queue<Integer> q = new LinkedList<>();
            q.offer(begin);
            while (!q.isEmpty()){
                begin = q.poll();
                for(int a=0;a<vertexNum;a++){
                    if(matrix[begin][a]!=Integer.MAX_VALUE&&visitedCount[a]==-1){
                        q.offer(a);
                        visitedCount[a] = 1;
                        queue.offer(vertex[a]);
                    }
                }

            }
        }
        return queue;
    }



    public Queue<Integer> depthFirstSearch(){
        initVisitedCount();
        Queue<Integer> queue = new LinkedList<>();
        int begin =-1;
        while((begin=findNotVisited())!=-1){
            DFS(begin,queue);
        }
        return  queue;
    }

    private void DFS(int begin,Queue<Integer> queue){
        visitedCount[begin] =1;
        queue.offer(vertex[begin]);
        for(int a=0;a<vertexNum;a++){
            if(matrix[begin][a]!=Integer.MAX_VALUE&&visitedCount[a]==-1){
                DFS(a,queue);
            }
        }

    }
    private int findNotVisited() {
        for(int i=0;i<vertexNum;i++){
            if(visitedCount[i]==-1){
                return i;
            }
        }
        return -1;
    }

    private void initVisitedCount() {
        for(int i=0;i<vertexNum;i++){
            visitedCount[i] = -1;
        }
    }

    public static void main(String[] args) {

        int[][] racs = new int[][]{
                {0,1,0,1,0,},
                {1,0,1,0,1,},
                {0,1,0,1,1,},
                {1,0,1,0,0,},
                {0,1,1,0,0,},
        };
        int oo = Integer.MAX_VALUE;

        int[][] racs1 = new int[][]{
                {oo, 1, 1,oo,oo,oo,oo,oo},
                { 1,oo,oo, 1,oo,oo,oo,oo},
                { 1,oo,oo, 1, 1,oo,oo,oo},
                {oo, 1, 1,oo,oo, 1, 1,oo},
                {oo,oo, 1,oo,oo,oo,oo, 1},
                {oo,oo,oo, 1,oo,oo, 1,oo},
                {oo,oo,oo, 1,oo, 1,oo,oo},
                {oo,oo,oo,oo, 1,oo,oo,oo},
        };

        int[] verticeInfos1 = new int[] {
                1,2,3,4,5,6,7,8
        };
        Main graph = new Main(racs1,verticeInfos1);
        Queue<Integer> dr = graph.depthFirstSearch();
        Queue<Integer> br = graph.breadthFirstSearch();

        System.out.println("--遍历");
        System.out.println("----深度优先结果: " + dr);
        System.out.println("----广度优先结果: " + br);
    }
}
