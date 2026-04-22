import java.util.ArrayList;

public class DFS {
    Graph g;
    Graph result;
    ArrayList<Integer> visited = new ArrayList<>();

    public DFS(Graph input) {
        g = input;
        result = new Graph(g.getNumVertices());
    }

    public Graph getinputgraph() {
        return g;
    }

    public Graph getResultgraph() {
        return result;
    }


    // implements the DFS algorithm
    // [IMPORTANT] DFS uses recursion
    public void run(int start) {
        
        // Mark current vertex as visited
        visited.add(start);
        
        // Visit all adjacent vertices
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (g.getMatrix()[start][i] == 1 && !visited.contains(i)) {
                result.addEdge(start, i);
                run(i);
            }
        }


        // if all nodes aren't visited
        if (!AllVisited()) {
            for (int i = 0; i < g.getNumVertices(); i++) {
                if (!visited.contains(i)) {
                    for (int k=0;k<g.getMatrix()[i].length;k++){
                        if (g.getMatrix()[i][k]==1 && !visited.contains(k)){
                            result.addEdge(i,k);
                        }
                    }
                }
            }
        }


    }



    public boolean AllVisited() {
        boolean result = true;
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (!visited.contains(i)) {
                result = false;
                break;
            }
        }
        return result;
    }
}