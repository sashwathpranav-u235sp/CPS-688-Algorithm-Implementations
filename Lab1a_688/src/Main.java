//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        System.out.println(g.toString());
        System.out.println("\n============================================================\n");
        System.out.println("Number of verticies for the node "+ 0 + " : " +g.degreeVertex(0));
        g.printAdjVertices(0); // implementation of printAdjVertices()
        System.out.println("\n============================================================\n");
        BFS bfs = new BFS(g);
        System.out.println("Starting BFS\n");
        bfs.run(0);
        System.out.println(bfs.result.toString());
        System.out.println("\n============================================================\n");
        DFS dfs = new DFS(g);
        System.out.println("Starting DFS\n");
        dfs.run(2);
        System.out.println(dfs.result.toString());

    }
}