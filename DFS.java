import java.util.*;

class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    // Graph creation
    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            adjLists[i] = new LinkedList<>();
        }
    }

    // Add edges (Directed)
    void addEdge(int src, int dest) {
        adjLists[src].add(dest);
    }

    // DFS algorithm
    void DFS(int vertex) {
        Arrays.fill(visited, false);  // Optional reset
        DFSUtil(vertex);
    }

    private void DFSUtil(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int adj : adjLists[vertex]) {
            if (!visited[adj]) {
                DFSUtil(adj);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        System.out.println("Following is Depth First Traversal starting from vertex 2:");
        g.DFS(2);
    }
}
