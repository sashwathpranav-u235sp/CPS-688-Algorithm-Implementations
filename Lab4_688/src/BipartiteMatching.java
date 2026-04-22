import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteMatching {
    private DirectedBipartiteGraph input;
    private DirectedBipartiteGraph residualGraph;
    private int total_flow = 0;

    public BipartiteMatching(DirectedBipartiteGraph i) {
        this.input = i;
        // Create residual graph (copy of input)
        this.residualGraph = new DirectedBipartiteGraph(input.getNumSideA(), input.getNumSideB());
        copyGraph(input, residualGraph);
    }

    private void copyGraph(DirectedBipartiteGraph source, DirectedBipartiteGraph target) {
        for (int i = 0; i < source.matrix.length; i++) {
            for (int j = 0; j < source.matrix[i].length; j++) {
                if (source.matrix[i][j] >= 0) {
                    target.matrix[i][j] = source.matrix[i][j];
                }
            }
        }
    }

    public void findMatching() {
        while (bfs()) {
            total_flow++;
        }
        System.out.println("The maximum number of applicants matching for the jobs is " + total_flow);
    }

    private boolean bfs() {
        int[] parent = new int[residualGraph.matrix.length];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(residualGraph.getSourceVertex());
        parent[residualGraph.getSourceVertex()] = -2; // Mark source as visited

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 0; next < residualGraph.matrix.length; next++) {
                // If there's capacity and next vertex hasn't been visited
                if (residualGraph.matrix[current][next] > 0 && parent[next] == -1) {
                    parent[next] = current;
                    if (next == residualGraph.getDestinationVertex()) {
                        // Found a path to the destination vertex - the flow must be augmented
                        augmentPath(parent);
                        return true;
                    }
                    queue.add(next);
                }
            }
        }
        return false; // No path found
    }

    private void augmentPath(int[] parent) {
        int current = residualGraph.getDestinationVertex();
        while (current != residualGraph.getSourceVertex()) {
            int prev = parent[current];
            // Decrease capacity on forward edge
            residualGraph.matrix[prev][current] -= 1;
            // Increase capacity on backward edge (a backward edge is created if the backward edge doesn't exist)
            if (residualGraph.matrix[current][prev] < 0) {
                residualGraph.matrix[current][prev] = 0;
            }
            residualGraph.matrix[current][prev] += 1;
            current = prev;
        }
    }

    public int getTotalFlow() {
        return total_flow;
    }
}