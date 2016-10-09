package facebook;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given a directed graph, design an algorithm to find out whether there is a route
    between two nodes.

     https://gist.github.com/zac-xin/2601219

*/
public class GraphRouteTwoNodes {
    public enum State {
        Unvisited, Visited, Visiting;
    }
    /*
     * we can use breadth first search or depth first search
     */
    public static boolean breadthFirstSearch(Graph_AdjacencyList g, int start, int end) {
        boolean[] visited = new boolean[g.size() + 1];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int item : g.neighbours(v)) {
                if (!visited[item]) {
                    if (item == end)
                        return true;
                    else {
                        visited[item] = true;
                        queue.add(item);
                    }
                }
            }
        }
        return false;
    }

    public static boolean depthFirstSearch(Graph_AdjacencyList g, int start, int end) {
        boolean visited[] = new boolean[g.size() + 1];
        return depthRecursive(g, start, end, visited);
    }

    public static boolean depthRecursive(Graph_AdjacencyList g,
                                         int start, int end, boolean[] visited) {
        visited[start] = true;
        for (int item : g.neighbours(start)) {
            if (!visited[item]) {
                if (item == end)
                    return true;
                else
                    return depthRecursive(g, item, end, visited);
            }
        }
        return false;
    }

    // ------------------------ Cracking the coding interview ----------------------------- //

    public static boolean search(Graph g, GraphNode start, GraphNode end) {
        LinkedList<GraphNode> q = new LinkedList<GraphNode>();
        for (GraphNode u : g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        GraphNode u;
        while (!q.isEmpty()) {
            u = q.removeFirst();
            if (u != null) {
                for (GraphNode v : u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }

    class Graph {
        private GraphNode vertices[];
        public int count;
        public Graph() {
            vertices = new GraphNode[6];
            count = 0;
        }

        public void addNode(GraphNode x) {
            if (count < 30) {
                vertices[count] = x;
                count++;
            } else {
                System.out.print("Graph full");
            }
        }

        public GraphNode[] getNodes() {
            return vertices;
        }
    }

    class GraphNode {
        private GraphNode adjacent[];
        public int adjacentCount;
        private String vertex;
        public GraphRouteTwoNodes.State state;
        public GraphNode(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new GraphNode[adjacentLength];
        }

        public void addAdjacent(GraphNode x) {
            if (adjacentCount < 30) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
        public GraphNode[] getAdjacent() {
            return adjacent;
        }
        public String getVertex() {
            return vertex;
        }
    }
}
