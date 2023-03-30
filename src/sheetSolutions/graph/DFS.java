package sheetSolutions.graph;

import java.util.ArrayList;

//Recursive solution for dfs of a graph, V is the no of vertices
public class DFS {
    private static ArrayList<ArrayList<Integer>> adj; // Adjacency Lists

    // Constructor
    DFS(int v) {
        // No. of vertices
        adj = new ArrayList<>(v);
        for (int i = 0; i < v + 1; ++i) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfsUtil(0, adj, dfs, visited);
        return dfs;
    }

    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited) {
        visited[node] = true;
        dfs.add(node);
        for (int curr_node : adj.get(node)) {
            if (!visited[curr_node]) {
                dfsUtil(curr_node, adj, dfs, visited);
            }
        }
    }

    public static void main(String[] args) {

        DFS g = new DFS(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3, 6);
        g.addEdge(6, 4);
        g.addEdge(6, 5);

        System.out.println(g.dfsOfGraph(7, adj).toString());

    }
}
