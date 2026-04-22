import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        //this graph has a cycle
        //when the Acyclic_graph alg runs, the alg should give the message no if the graph contains a cycle, else the message is yes
        Graph h = new Graph(6);
        h.addEdge(0, 1);
        h.addEdge(0, 2);
        h.addEdge(0,3);
        h.addEdge(1, 4);
        h.addEdge(2, 5);
        //This graph does not have a cycle

        //Testing Acyclic
        Acyclic_Graph a = new Acyclic_Graph(g);
        Acyclic_Graph b = new Acyclic_Graph(h);
        System.out.println("Graph is cyclic: "+a.hasCycle());
        System.out.println("Graph is cyclic: "+b.hasCycle());

        System.out.println();
        //Testing Nqueens
        NQueens solver = new NQueens(8);
        if (solver.run()) {
            System.out.println("Solution found:");
            solver.show();
        } else {
            System.out.println("No solution exists for " + 8 + " queens.");
        }

        System.out.println();
        //Testing MST
        // Create a graph
        Graph gj = new Graph(4);

        // Add edges with weights
        gj.addEdge(0, 1, 10);
        gj.addEdge(0, 2, 6);
        gj.addEdge(0, 3, 5);
        gj.addEdge(1, 3, 15);
        gj.addEdge(2, 3, 4);
        //gj.addEdge(2, 4, 7);
        //gj.addEdge(3, 4, 9);

        // Find MST using Prim's algorithm
        MST mst = new MST(gj);
        mst.primMST();

        // Print the MST
        System.out.println("Minimum Spanning Tree:");
        //System.out.println(mst.getResult().toString());
        mst.printMST();
        System.out.println();
        System.out.println();

        //LIS
        Scanner scanner = new Scanner(System.in);

        // Read input sequence
        System.out.println("Enter the number of elements in the sequence:");
        int nl = scanner.nextInt();
        List<Integer> sequence = new ArrayList<>();
        for (int i = 0; i < nl; i++) {
            System.out.println("Enter a number:");
            sequence.add(scanner.nextInt());
        }

        // Find LIS
        List<Integer> lis = LIS.findLIS(sequence);

        // Output results
        System.out.println("LIS = " + lis.size());
        System.out.print("LIS is: ");
        for (int num : lis) {
            System.out.print(num + " ");
        }
        System.out.println();


        //Knapsack
        Scanner scanner1 = new Scanner(System.in);

        // Read input
        System.out.println("Enter the number of candies: ");
        int N = scanner1.nextInt(); // Number of candies

        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter the value of candy " + (i + 1) + ": ");
            values[i] = scanner1.nextInt(); // Sentimental values
        }

        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Enter the weight of candy " + (i + 1) + ": ");
            weights[i] = scanner1.nextInt(); // Weights
        }

        System.out.println("Enter max weight: ");
        int W = scanner1.nextInt(); // Maximum weight capacity

        // Calculate maximum value
        int maxValue = Knapsack.knapsack(W, weights, values, N);
        System.out.println(maxValue);


    }


}