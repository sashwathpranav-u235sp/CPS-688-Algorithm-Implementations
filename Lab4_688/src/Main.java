public class Main {
    public static void main(String[] args) {
        // Example usage
        DirectedBipartiteGraph graph = new DirectedBipartiteGraph(6, 6); // 6 nodes on each side

        // Add edges from source to side A (vertices 1-6)
        for (int i = 1; i <= 6; i++) {
            graph.addEdgetoSource(i, 1);
        }

        // Add edges from side B to sink (vertices 4-6)
        for (int i = 7; i <= 12; i++) {
            graph.addEdgetoDestination(i, 1);
        }

        // Add bipartite edges (A->B)
        graph.addEdge(1, 8,1);
        graph.addEdge(1, 9,1);
        graph.addEdge(3, 7,1);
        graph.addEdge(3, 10,1);
        graph.addEdge(4, 9,1);
        graph.addEdge(5, 9,1);
        graph.addEdge(5, 10,1);
        graph.addEdge(6, 12,1);


        BipartiteMatching matcher = new BipartiteMatching(graph);
        matcher.findMatching(); // Will print the maximum matching count
    }
}