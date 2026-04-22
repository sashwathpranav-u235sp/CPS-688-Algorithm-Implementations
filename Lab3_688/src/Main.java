//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //problem 2
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        DFS dfs1 = new DFS(g);
        // yes
        System.out.println(dfs1.stronglyconnected()?"yes" : "no");


        Graph g2 = new Graph(6);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(2, 4);
        g2.addEdge(3, 1);
        g2.addEdge(3, 5);
        g2.addEdge(4, 5);
        g2.addEdge(5, 0);
        DFS dfs2 = new DFS(g2);
        // no
        System.out.println(dfs2.stronglyconnected()?"yes" : "no");





        //Problem 1

        P1 a = new P1(8);
        a.addPrice(1);
        a.addPrice(5);
        a.addPrice(8);
        a.addPrice(9);
        a.addPrice(10);
        a.addPrice(17);
        a.addPrice(17);
        a.addPrice(20);
        a.run();
        System.out.println("The max value of a rod of length 8 is: " + a.lookup(8));






    }
}