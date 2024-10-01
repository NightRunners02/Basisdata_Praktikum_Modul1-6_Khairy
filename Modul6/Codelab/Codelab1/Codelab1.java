package Basisdatapraktikum.Modul6.Codelab.Codelab1;

import java.util.LinkedList;
import java.util.Queue;

 class BFSTraversal {
    private int node;
    private LinkedList<Integer>adj[];
    private Queue<Integer>que;
    @SuppressWarnings("unchecked")
    BFSTraversal(int v){
        node=v;
        adj=new LinkedList[node];
        for (int i = 0;i<v;i++){
            adj[i]= new LinkedList<>();
        }
        que=new LinkedList<Integer>();
    }
    void insertEdge(int v, int w){
        adj[v].add(w);
    }
    void BFS(int n){
        boolean nodes[]=new boolean[node];
        int a = 0;
        nodes[n]=true;
        que.add(n);
        while (que.size()!=0){
            n=que.poll();
            System.out.println(n+" ");
            for (int i = 0; i<adj[n].size();i++){
                a=adj[n].get(i);
                if(!nodes[a]){
                    nodes[a]=true;
                    que.add(a);
                }
            }
        }

    }

    public static void main(String[] args) {
        BFSTraversal graph = new BFSTraversal(6);
        graph.insertEdge(0,1);
        graph.insertEdge(0,5);
        graph.insertEdge(0,4);
        graph.insertEdge(0,1);
        graph.insertEdge(1,0);
        graph.insertEdge(1,5);
        graph.insertEdge(1,2);
        graph.insertEdge(5,0);
        graph.insertEdge(5,1);
        graph.insertEdge(5,4);
        graph.insertEdge(2,1);
        graph.insertEdge(2,4);
        graph.insertEdge(2,3);
        graph.insertEdge(4,0);
        graph.insertEdge(4,2);
        graph.insertEdge(4,5);
        graph.insertEdge(3,2);
        System.out.println("BFS Traversal is:");
        graph.BFS(3);
    }
}
