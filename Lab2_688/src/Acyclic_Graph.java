import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Acyclic_Graph {
    Graph g; //input graph
    Graph result; //graph that will be modified when the BFS algorithm is run
    ArrayList<Integer> visited = new ArrayList<>(); // Arraylist to keep track of the nodes that are visited by the BFS algorithm
    int[] parent;
    //geters
    public Graph getinput() {
        return g;
    }

    //getters
    public Graph getresult() {
        return result;
    }

    //getter
    public ArrayList<Integer> getvisited() {
        return visited;
    }

    //constructor
    public Acyclic_Graph(Graph input){
        g = input;
        result = new Graph(g.getNumVertices());
        parent = new int[g.getNumVertices()];
        for (int i = 0; i < g.getNumVertices(); i++) {
            parent[i] = -1;
        }

    }

    public boolean hasCycle() {
        for (int start = 0; start < g.getNumVertices(); start++) {
            if (!visited.contains(start)) {
                Queue<Integer> q = new LinkedList<>();
                visited.add(start);
                q.add(start);
                parent[start] = -1; // Start node has no parent

                while (!q.isEmpty()) {
                    int v = q.poll();
                    for (int i = 0; i < g.getNumVertices(); i++) {
                        if (g.getMatrix()[v][i] >= 1) { // There's an edge between v and i
                            if (!visited.contains(i)) {
                                visited.add(i);
                                q.add(i);
                                parent[i] = v; // Set parent of i to v
                            } else if (parent[v] != i) {
                                // If i is visited and not the parent of v, then there's a cycle
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false; // No cycle found
    }


    //method that implements the BFS algorithm
    // [IMPORTANT] BFS does not use recursion
    public void run(int start) {
        String Result = "";
        Queue<Integer> q = new LinkedList<>(); //Queue of nodes to be visited
        visited.add(start); // starting node added to visited
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (g.getMatrix()[start][i] >= 1) {
                q.add(i); //adding adjacent nodes to the queue to be visited
                visited.add(i); // adding adjacent nodes to the visited arraylist (this avoids cycles during the BFS implementation)
                result.addEdge(start, i); // adding an edge between the nodes "start" and "i" in the result graph
            }
        }
        while (!q.isEmpty()) { //this loop continues so long as the queue q is not empty
            int v = q.poll(); //removes and returns the first element (head) of the queue [throws an exception when the queue is empty unlike remove()]
            for (int i = 0; i < g.getNumVertices(); i++) {
                if (g.getMatrix()[v][i] >= 1 && !visited.contains(i)) { // if there's an edge at (v,i) and i is not visited yet
                    q.add(i); // i is added to the queue to be visited
                    visited.add(i); //i is also added to the visited arrayList to avoid cycles
                    result.addEdge(v, i); // an edge is added between v and i
                }
            }
        }
        visited.clear(); //after the BFS algorithm is complete, the visited list is cleared for future use.
    }
}
