package interviewBit.graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by priyavivek on 11/27/15.
 *
 * Problem statement
 *
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class Clonegraph {

    HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
       return cloneRecur(node);
    }

    //Recursively clone a graph. Use a hashmap to account for cycles in a graph.

    public UndirectedGraphNode cloneRecur(UndirectedGraphNode node){
        if(node == null){
            return null;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visited.put(node,clone);

        for(UndirectedGraphNode x : node.neighbors){
            clone.neighbors.add(cloneRecur(x));
        }

        return clone;



    }



    public static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public static void main(String[] args){

        UndirectedGraphNode a = new UndirectedGraphNode(703);
        UndirectedGraphNode b = new UndirectedGraphNode(279);
        UndirectedGraphNode c = new UndirectedGraphNode(43);

        List<UndirectedGraphNode> aN = new ArrayList<UndirectedGraphNode>(Arrays.asList(c,b,a));
        List<UndirectedGraphNode> bN = new ArrayList<UndirectedGraphNode>(Arrays.asList(c,b,a));
        List<UndirectedGraphNode> cN = new ArrayList<UndirectedGraphNode>(Arrays.asList(b,a));

        a.neighbors = aN;
        b.neighbors = bN;
        c.neighbors = cN;

        UndirectedGraphNode result;

        Clonegraph cg = new Clonegraph();

        result = cg.cloneGraph(a);


    }


}
