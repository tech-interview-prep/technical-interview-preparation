package leetcode_online_judge.Java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import utils.UndirectedGraphNode;

/**
 * https://leetcode.com/problems/clone-graph/
 * @author bkoteshwarreddy
 */
public class _133CloneGraph {
    /*
    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


    OJ's undirected graph serialization:
    Nodes are labeled uniquely.

    We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
    As an example, consider the serialized graph {0,1,2#1,2#2,2}.

    The graph has a total of three nodes, and therefore contains three parts as separated by #.

    First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
    Second node is labeled as 1. Connect node 1 to node 2.
    Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
    Visually, the graph looks like the following:

           1
          / \
         /   \
        0 --- 2
             / \
             \_/
     */
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        UndirectedGraphNode tmpNode;
        while (!queue.isEmpty()) {
            tmpNode = queue.remove();
            for (UndirectedGraphNode n : tmpNode.neighbors) {
                if (!map.containsKey(n)) {
                    queue.add(n);
                    map.put(n, new UndirectedGraphNode(n.label));
                }
                map.get(tmpNode).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }

    public static void test() {
        UndirectedGraphNode node = UndirectedGraphNode.constructGraph();
        node.print();

        System.out.println("===========");

        cloneGraph(node).print();
    }

    public static void main(String[] args) {
        test();
    }
}
