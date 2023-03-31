package sheetSolutions.graph;

import java.util.ArrayList;
/*
To detect a back edge, we need to keep track of the nodes visited till now and the nodes that are in the current recursion
stack [i.e., the current path that we are visiting]. If during recursion, we reach a node that is already in the recursion
stack, there is a cycle present in the graph.
 */
public class DetectCycleInDirectedGraphUsingDFS {
    private static ArrayList<ArrayList<Integer>> adj; // Adjacency Lists

    // Constructor
    DetectCycleInDirectedGraphUsingDFS(int v) {
        // No. of vertices
        adj = new ArrayList<>(v);
        for (int i = 0; i < v + 1; ++i) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // V is the no. of vertices
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (detectCycleUtil(i, adj, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycleUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack) {
        if (recStack[node]) { // keeps track of different paths that we have visited
            return true;
        }
        if (visited[node]) { // we have visited this node as part of a path, but we didn't find anything. so no,cycle
            return false;
        }

        visited[node] = true;
        recStack[node] = true;

        for (int curr_node : adj.get(node)) {
            if (detectCycleUtil(curr_node, adj, visited, recStack)) {
                return true;
            }
        }
        recStack[node] = false; // unmarking the current node from the recursion stack, to represent that the current node is no longer a part of the path being traced.
        return false;
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraphUsingDFS g = new DetectCycleInDirectedGraphUsingDFS(6);

        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 3);


        System.out.println(g.detectCycle(6, adj));
    }
}

