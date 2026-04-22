import java.util.ArrayList;
//public void run(int start, boolean isReversed) {} OVERLOAD methods if function name is necessary
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

    public boolean P2run(int start) {
        visited.add(start);

        // Visit all adjacent vertices
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (g.getMatrix()[start][i] == 1 && !visited.contains(i)) {
                result.addEdge(start, i);
                P2run(i);
            }
        }

        if (!AllVisited()) {
            return false;
        }else {
            return true;
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

    public boolean stronglyconnected() {
        System.out.println("Checking graph with " + g.getNumVertices() + " vertices");
        visited.clear();
        run(0);
        if(!AllVisited()) // if all nodes are not visited it returns false
            return false;

        Graph transpose = Transpose(g);

        DFS reverse = new DFS(transpose);
        reverse.visited.clear(); // clears on every run
        reverse.run(0);
        return reverse.AllVisited();
    }

    public static Graph Transpose(Graph go) {
        Graph transpose = new Graph(go.getNumVertices()); // creates new transpose graph
        int [][] matrix = go.getMatrix();
        for(int i =0; i < go.getNumVertices(); i++){
            for(int j = 0; j < go.getNumVertices(); j++){ // interates through the matrix
                if (matrix [i][j] == 1) {  // if there is a connection between i and j, the directed edge is transposed
                    transpose.addEdge(j, i);
                }
            }
        }
        return transpose;
    }
}