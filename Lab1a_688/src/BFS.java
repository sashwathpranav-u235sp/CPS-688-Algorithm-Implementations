import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    Graph g; //input graph
    Graph result; //graph that will be modified when the BFS algorithm is run
    ArrayList<Integer> visited = new ArrayList<>(); // Arraylist to keep track of the nodes that are visited by the BFS algorithm

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
    public BFS(Graph input){
        g = input;
        result = new Graph(g.getNumVertices());

    }

    //method that implements the BFS algorithm
    // [IMPORTANT] BFS does not use recursion
    public void run(int start) {
        Queue<Integer> q = new LinkedList<>(); //Queue of nodes to be visited
        visited.add(start); // starting node added to visited
        for (int i = 0; i < g.getNumVertices(); i++) {
            if (g.getMatrix()[start][i] == 1) {
                q.add(i); //adding adjacent nodes to the queue to be visited
                visited.add(i); // adding adjacent nodes to the visited arraylist (this avoids cycles during the BFS implementation)
                result.addEdge(start, i); // adding an edge between the nodes "start" and "i" in the result graph
            }
        }
        while (!q.isEmpty()) { //this loop continues so long as the queue q is not empty
            int v = q.poll(); //removes and returns the first element (head) of the queue [throws an exception when the queue is empty unlike remove()]
            for (int i = 0; i < g.getNumVertices(); i++) {
                if (g.getMatrix()[v][i] == 1 && !visited.contains(i)) { // if there's an edge at (v,i) and i is not visited yet
                    q.add(i); // i is added to the queue to be visited
                    visited.add(i); //i is also added to the visited arrayList to avoid cycles
                    result.addEdge(v, i); // an edge is added between v and i
                }
            }
        }

        visited.clear(); //after the BFS algorithm is complete, the visited list is cleared for future use.
    }
}
