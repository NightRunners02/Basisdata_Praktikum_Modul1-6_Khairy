package Basisdatapraktikum.Modul6.Codelab.Latihan.Latihan2;

import java.util.*;

class DFSTraversal {
    private LinkedList<Integer> adj[]; // representasi daftar ketetanggaan
    private boolean visited[];

    // Pembuatan graf
    @SuppressWarnings("unchecked")
    DFSTraversal(int V) {
        // V adalah jumlah simpul dalam graf
        adj = new LinkedList[V];
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    // Menambahkan edge ke graf
    void insertEdge(int src, int dest) {
        adj[src].add(dest);
    }

    // Metode DFS
    void DFS(int vertex) {
        visited[vertex] = true; // Menandai node saat ini sebagai dikunjungi
        System.out.print(vertex + " ");
        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n]) {
                DFS(n);
            }
        }
    }

    public static void main(String args[]) {
        DFSTraversal graph = new DFSTraversal(8);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(0, 3);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 5);
        graph.insertEdge(3, 6);
        graph.insertEdge(4, 7);
        graph.insertEdge(4, 5);
        graph.insertEdge(5, 2);

        System.out.println("Penelusuran Kedalaman Pertama untuk graf adalah:");
        graph.DFS(0);
    }
}
