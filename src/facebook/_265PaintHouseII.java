package facebook;

/**
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house
 * with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same
 * color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0]
 * is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Follow up:
 * Could you solve it in O(nk) runtime?
 *
 * https://leetcode.com/problems/paint-house-ii/
 */
public class _265PaintHouseII {
}

class Solution_PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int m = costs.length, n = costs[0].length;
        int min1 = 0, min2 = 0, idMin1 = -1;

        for (int i = 0; i < m; i++) {
            int m1 = Integer.MAX_VALUE, m2 = m1, idm1 = -1;

            for (int j = 0; j < n; j++) {
                // If same color as j - 1, we can only extend from 2nd min of j - 1
                int cost = costs[i][j] + (j == idMin1 ? min2 : min1);

                // Update m1 m2 if cost is smaller than any of them
                if (cost < m1) {
                    m2 = m1; m1 = cost; idm1 = j;
                } else if (cost < m2) {
                    m2 = cost;
                }
            }
            min1 = m1; idMin1 = idm1; min2 = m2;
        }
        return min1;
    }
}
