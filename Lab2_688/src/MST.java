import java.util.Arrays;

public class MST {
    Graph g;
    Graph result;

    public MST(Graph input) {
        g = input;
        result = new Graph(g.getNumVertices());
    }

    public void primMST() {
        int numVertices = g.getNumVertices();
        int[][] graph = g.getMatrix();

        int[] parent = new int[numVertices];
        int[] key = new int[numVertices]; // contains the nodes covered in the MST
        boolean[] mstSet = new boolean[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false); // used to check if the verticies are visited

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < numVertices - 1; count++) { // if numvertices is 6, numvertices-1 is 5 and count<numverticies is 0 - 4
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }


        // Add the edges to the result graph
        for (int i = 1; i < numVertices; i++) {
            if (parent[i] != -1) {
                result.addEdge(parent[i], i, graph[i][parent[i]]);
            }
        }
    }

    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public void printMST() {
        int totalWeight = 0;
        int[][] mstMatrix = result.getMatrix();

        System.out.println("Minimum Spanning Tree Edges:");

        for (int i = 0; i < mstMatrix.length; i++) {
            for (int j = i + 1; j < mstMatrix[i].length; j++) {
                if (mstMatrix[i][j] != 0) {
                    System.out.printf("Edge %d-%d has a weight of %d\n", i, j, mstMatrix[i][j]);
                    totalWeight += mstMatrix[i][j];
                }
            }
        }

        System.out.println("MST = " + totalWeight);
    }

    public Graph getResult() {
        return result;
    }
}