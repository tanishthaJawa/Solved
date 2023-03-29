package sheetSolutions.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CreateGraph<T> {
    private final Map<T, List<T>> map = new HashMap<>();

    private void addVertex(T s) {
        map.put(s, new LinkedList<>());
    }

    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }
        map.get(source).add(destination);

        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public void getVertexCount() {
        System.out.println("The no. of vertex in graph is " + map.keySet().size());
    }

    public void getEdgesCount() {
        int count = 0, bidirectionalEdges = 0;
        for (T vertex : map.keySet()) {
            for (T edge : map.get(vertex)) {
                if (isEdgeBidirectional(vertex, edge)) {
                    bidirectionalEdges++;
                } else {
                    count++;
                }
            }
        }
        count = count + (bidirectionalEdges / 2);
        System.out.println("The no. of edges in graph is " + count);
    }

    public void hasVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("The graph contains vertex " + s);
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    public void hasEdge(T s, T d) {
        if (!map.containsKey(s)) {
            return;
        }
        if (map.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else {
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    private boolean isEdgeBidirectional(T s, T d) {
        if (!map.containsKey(s) && map.containsKey(d)) {
            return false;
        }
        return map.get(s).contains(d) && map.get(d).contains(s);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T k : map.keySet()) {
            result.append(k.toString()).append(" : ");
            for (T e : map.get(k)) {
                result.append(e.toString()).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        CreateGraph<Integer> graph = new CreateGraph<>();
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, false);
        graph.addEdge(1, 5, true);
        graph.addEdge(2, 4, false);
        graph.addEdge(3, 4, true);
        graph.addEdge(4, 5, false);

        System.out.println("Graph:\n" + graph);

        // Gives the no of vertices in the graph.
        graph.getVertexCount();

        // Gives the no of edges in the graph.
        graph.getEdgesCount();

        // Tells whether the edge is present or not.
        graph.hasEdge(6, 4);

        // Tells whether vertex is present or not
        graph.hasVertex(5);
    }
}
