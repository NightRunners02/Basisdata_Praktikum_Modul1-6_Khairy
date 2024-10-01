package Basisdatapraktikum.Modul6.Praktikum.Praktikum2;

import java.util.*;

 class GraphSearch {
    private int numVertices;
    private LinkedList<Integer>[] adjLists;
    private boolean[] visited;


    @SuppressWarnings("unchecked")
    public GraphSearch(int vertices) {
        numVertices = vertices;
        adjLists = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
        visited = new boolean[vertices];
    }

    // BFS
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }


    void BFS(int vertex) {
        visited = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {
            int s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adjLists[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    // DFS
    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> i = adjLists[vertex].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFS(n);
            }
        }
    }

    // Wrapper untuk DFS agar kita bisa reset daftar visited
    void startDFS(int vertex) {
        visited = new boolean[numVertices];
        DFS(vertex);
        System.out.println();
    }

    public static void main(String args[]) {
        GraphSearch g = new GraphSearch(15);

        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 7);
        g.addEdge(4, 10);
        g.addEdge(5, 2);
        g.addEdge(5, 6);
        g.addEdge(5, 9);
        g.addEdge(5, 9);
        g.addEdge(6, 1);
        g.addEdge(7, 8);
        g.addEdge(7, 11);
        g.addEdge(11, 1);

        System.out.println("BFS (Breadth First Search)");

        g.BFS(1);

        System.out.println("DFS (Depth First Search)");

        g.startDFS(1);
    }
}
