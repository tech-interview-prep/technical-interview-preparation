package leetcode.algorithms;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a
 * function to check whether these edges make up a valid tree.
 *
 * For example:
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Hint:
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 * According to the definition of tree on Wikipedia: "a tree is an undirected graph in which any two vertices are
 * connected by exactly one path. In other words, any connected graph without simple cycles is a tree."
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the
 * same as [1, 0] and thus will not appear together in edges.
 *
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {
}

class Solution_GraphValidTree {
    // union find cycle detection
    int[] dp;
    public int find(int i) {
        while (i != dp[i]) {
            i = dp[i];
        }
        return i;
    }

    public void union(int i, int j) {
        dp[find(j)] = dp[find(i)];
        return;
    }

    public boolean validTree(int n, int[][] edges) {
        dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = i;
        }
        for (int i = 0; i < edges.length; ++i) {
            if (find(edges[i][0]) != find(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
                n--;
            } else {
                return false;
            }
        }
        return (n == 1);
    }
}
