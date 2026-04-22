

public class Graph {
    int[][] matrix; // adjacency matrix [adjacency matrix is created using a 2d array or a nested array]
    int numVertices;// number of vertices

    public Graph(int Vertices) {
        numVertices = Vertices;
        matrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrix[i][j] = 0; // setting all values in the matrix to zero
            }
        }
        System.out.println("An directed graph with " + numVertices + " vertices has been created"); // matrix creation message
    }

    public void addEdge(int a, int b) {
        if (a < 0 || a >= numVertices || b < 0 || b >= numVertices) {
            System.out.println("Invalid vertex"); // if node value does not exist between 0 and numVertices-1
                                                  // then the vertex or vertices are deemed invalid
        }else {
            matrix[a][b]=1;

            // Changing the value at (a,b) and (b,a) to 1. This is the case since the graph is undirected
            // Value 1 at (a,b) denotes an edge connecting a and b
        }


    }
    // values at (a,b) are set to zero again. However, this method is not used.
    public void removeEdge(int a, int b){
        if (a < 0 || a >= numVertices || b < 0 || b >= numVertices) { // if node value does not exist between 0 and numVertices-1
            System.out.println("Invalid vertex");                     // then the vertex or vertices are deemed invalid
        } else {
            matrix[a][b]=0;
        }
    }

    // finds the degree of a certain vertex. [Degree: the number of adjacent vertices to a given vertex]
    public int degreeVertex(int a){
        int degree=0;
        for (int i = 0; i < numVertices; i++) {
            if (matrix[a][i]==1){
                degree++;
            }
        }
        return degree;
    }

    // prints all the adjacent vertices of a given vertex
    public void printAdjVertices(int a) {
        System.out.println("Node: " + a);
        for (int i = 0; i < numVertices; i++) {
            if (matrix[a][i]==1){
                System.out.println("\t" + a + " ---> " + i);

            }
        }
    }

    //getter
    public int[][] getMatrix() {
        return matrix;
    }
    //getter
    public int getNumVertices() {
        return numVertices;
    }
    // returns a string which shows all the nodes and the edges of the graph
    /*
    Sample Output: [IMPORTANT: \n - line break | \t - tab (4 spaces)]

    Node a: ["Node "+a+"\n"]
        a ---> b  ["\t" + a + " ---> " + b + "\n"] [+ : .append() in StringBuilder]
        a ---> c
    Node b:
        b ---> a
        b ---> c
    Node c:
        c ---> a
        c ---> b

    */
    public String toString(){
        StringBuilder r = new StringBuilder(); //StringBuilder allows concatenation of other strings, integers or characters to it
        for (int i = 0;i<numVertices;i++){     // which can be later converted into a string using toString() since StringBuilder is not a String.
            r.append("Node: ").append(i).append("\n");
            for (int j=0;j<numVertices;j++){
                if (matrix[i][j]==1){
                    r.append("\t").append(i).append(" ----> ").append(j).append("\n");
                }
            }
        }
        return r.toString();
    }
}
