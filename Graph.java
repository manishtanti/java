import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

//input
// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0
// 6

public class Graph {
    static class Edge {
        int src, nbr, wt;

        Edge() {
        };

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void findPath(int src, int des, ArrayList<Edge>[] graph, boolean[] visited, String psf, int wt) {
        if (src == des) {
            System.out.println(psf + " @ " + wt);
        }
        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                findPath(edge.nbr, des, graph, visited, psf + edge.nbr + "-> ", wt + edge.wt);
            }
        }
        visited[src] = false;
    }

    public static void connectedComponent(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> sc) {
        visited[src] = true;
        sc.add(src);
        for (Edge edge : graph[src]) {
            if (visited[edge.nbr] == false) {
                connectedComponent(graph, edge.nbr, visited, sc);
            }
        }
    }

    public static void breadthFirstSearch(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        while (q.size() > 0) {
            int top = q.remove();
            System.out.print(top + " -> ");
            if (visited[top] == true) {
                continue;
            }
            visited[top] = true;
            for (Edge edge : graph[top]) {
                if (visited[edge.nbr] == false) {
                    System.out.print(edge.nbr + " ");
                    q.add(edge.nbr);
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vts, edges;
        vts = sc.nextInt();
        edges = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vts];
        for (int i = 0; i < vts; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < edges; i++) {
            int src = sc.nextInt();
            int nbr = sc.nextInt();
            int wt = sc.nextInt();
            graph[src].add(new Edge(src, nbr, wt));
            graph[nbr].add(new Edge(nbr, src, wt));
        }

        sc.close();

        // to view edges
        // for(int i=0;i<vts;i++){
        // for(Edge edge:graph[i]){
        // System.out.println(edge.src + " --> "+ edge.nbr+" == "+edge.wt);
        // }
        // System.out.println();
        // }

        boolean[] visited = new boolean[vts];
        // findPath(start,end,graph,visited,"0-> ",0);

        // conected componenet
        // ArrayList<ArrayList<Integer>> largeComponent = new ArrayList<>();
        // for(int i=0;i<vts;i++){
        // if(visited[i]==false){
        // ArrayList<Integer> smallComponent = new ArrayList<>();
        // connectedComponent(graph,i,visited,smallComponent);
        // largeComponent.add(smallComponent);
        // }
        // }
        // System.out.println(largeComponent);

        // breadth first search
        for (int i = 0; i < vts; i++) {
            if (visited[i] == false) {
                breadthFirstSearch(graph, i, visited);
            }
        }
    }

}
