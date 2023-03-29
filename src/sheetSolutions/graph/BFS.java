package sheetSolutions.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static ArrayList<ArrayList<Integer>> adj; // Adjacency Lists

    // Constructor
    BFS(int v) {
        // No. of vertices
        adj = new ArrayList<>(v);
        for (int i = 0; i < v+1; ++i) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }

    public ArrayList<Integer> bfsOfGraphFromASourceNode(int V, ArrayList<ArrayList<Integer>> adj) {
        //  The source node is 0
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int curr_node = q.poll();
            bfs.add(curr_node);
            adj.get(curr_node).stream().mapToInt(j -> j).filter(j -> !visited[j]).forEach(j -> { // for each can also be used
                visited[j] = true;
                q.add(j);
            });
        }

        return bfs;
    }

    public static void main(String[] args) {

        BFS g = new BFS(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.addEdge(3,6);
        g.addEdge(6,4);
        g.addEdge(6,5);

        System.out.println(g.bfsOfGraphFromASourceNode(7,adj).toString());

    }
}
