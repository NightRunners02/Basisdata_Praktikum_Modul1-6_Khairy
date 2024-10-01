package Basisdatapraktikum.Modul6.Praktikum.Praktikum1;

class DirectedGraph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public DirectedGraph(int v) {
        vertices = v;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int start, int end) {
        adjacencyMatrix[start - 1][end - 1] = 1;
    }

    public void printAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("   ");
        for (int i = 1; i <= vertices; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();
        for (int i = 0; i < vertices; i++) {
            System.out.printf("%2d ", (i + 1));
            for (int j = 0; j < vertices; j++) {
                System.out.printf("%2d ", adjacencyMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public void calculateDegrees() {
        int[] inDegree = new int[vertices];
        int[] outDegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    outDegree[i]++;
                    inDegree[j]++;
                }
            }
        }

        System.out.println("\nNode   In-Degree   Out-Degree");
        for (int i = 0; i < vertices; i++) {
            System.out.printf("%-6d %-10d %-10d%n", (i + 1), inDegree[i], outDegree[i]);
        }
    }

    public void printGraphNotation() {
        System.out.print("\nVertices (V): {");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i);
            if (i < vertices) {
                System.out.print(", ");
            }
        }
        System.out.println("}");

        System.out.print("Edges (E): {");
        boolean first = true;
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    if (!first) {
                        System.out.print(", ");
                    }
                    System.out.print("(" + (i + 1) + ", " + (j + 1) + ")");
                    first = false;
                }
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(12);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);
        graph.addEdge(7, 9);
        graph.addEdge(8, 10);
        graph.addEdge(9, 11);
        graph.addEdge(10, 11);
        graph.addEdge(11, 12);
        graph.addEdge(12, 1);

        graph.printAdjacencyMatrix();

        graph.calculateDegrees();

        graph.printGraphNotation();
    }
}
