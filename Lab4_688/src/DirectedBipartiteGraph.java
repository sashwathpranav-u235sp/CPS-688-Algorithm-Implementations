public class DirectedBipartiteGraph {
    private final int numSideA;
    private final int numSideB;
    private final int sourceVertex;
    private final int destinationVertex;
    private final int maxFlow = 1;  // maxflow for any edge in this graph is 1

    // adjacency matrix for the bipartite matching graph
    int[][] matrix; // not an edmonds matrix
    /*
    * Representation of the adjacency matrix used in this class
    *
    * total verticies = sideA + sideB + 2
    * vertex index of source = 0
    * vertex index of destination (target) = sideA + sideB + 1
    *
    *  0 {0,1,2,3,4,5}
    *  1 {0,1,2,3,4,5}
    *  2 {0,1,2,3,4,5}
    *  3 {0,1,2,3,4,5}
    *  4 {0,1,2,3,4,5}
    *  5 {0,1,2,3,4,5}
    *
    *  each row is a vertex
    *  each column is a vertex the row vertices are either connected to or not connected to
    *  indices 1,2 is part of sideA or disjoint set A
    *  indices 3,4 is part of sideB or disjoint set B
    *  source vertex is 0
    *  destination vertex is 5
    * */

    public DirectedBipartiteGraph(int a, int b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Number of vertices must be positive");
        }

        numSideA = a;
        numSideB = b;
        // Total vertices: source + sideA + sideB + destination
        int totalVertices = numSideA + numSideB + 2;
        matrix = new int[totalVertices][totalVertices];
        sourceVertex = 0;
        destinationVertex = totalVertices - 1;

        // Initialize all verticies without any edges between them (denoted with -1)
        /*
        * no edge: -1
        * edge without flow: 0
        * edge with flow: 1
        *
        * */
        for (int i = 0; i < totalVertices; i++) {
            for (int j = 0; j < totalVertices; j++) {
                matrix[i][j] = -1; // intiallizes the edges as non-existent
            }
        }
    }

    // edge addition without flow (defaults to 0)
    public void addEdge(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        matrix[from][to] = 0;
    }

    // Edge addition with specific flow value
    public void addEdge(int from, int to, int flow) {
        validateVertex(from);
        validateVertex(to);
        validateFlow(flow);
        matrix[from][to] = flow;
    }

    // Add edge to destination without flow
    public void addEdgetoDestination(int from) {
        validateVertex(from);
        matrix[from][destinationVertex] = 0;
    }

    // Add edge to destination with flow
    public void addEdgetoDestination(int from, int flow) {
        validateVertex(from);
        validateFlow(flow);
        matrix[from][destinationVertex] = flow;
    }

    // Add edge from source without flow
    public void addEdgetoSource(int to) {
        validateVertex(to);
        matrix[sourceVertex][to] = 0;
    }

    // Add edge from source with flow
    public void addEdgetoSource(int to, int flow) {
        validateVertex(to);
        validateFlow(flow);
        matrix[sourceVertex][to] = flow;
    }

    // Remove an edge
    public void removeEdge(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        matrix[from][to] = -1;
    }

    // Get flow value for an edge
    public int getFlow(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        return matrix[from][to];
    }

    // Validate vertex index
    private void validateVertex(int v) {
        if (v < 0 || v >= numSideA + numSideB + 2) {
            throw new IllegalArgumentException("Vertex " + v + " is out of bounds");
        }
    }

    // Validate flow value
    private void validateFlow(int flow) {
        if (flow < 0 || flow > maxFlow) {
            throw new IllegalArgumentException("Flow must be between 0 and " + maxFlow);
        }
    }

    // Getters
    public int getNumVertices() {
        return numSideA + numSideB;
    }

    public int getSourceVertex() {
        return sourceVertex;
    }

    public int getDestinationVertex() {
        return destinationVertex;
    }

    public int getNumSideA() {
        return numSideA;
    }

    public int getNumSideB() {
        return numSideB;
    }


    int[][] getMatrix() {
        return matrix;
    }
}