package leetcode_online_judge;

import java.util.ArrayList;

public class Triangle {
    /*
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the
    row below.

    For example, given the following triangle
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Note:
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the
    triangle.
    */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        int s = triangle.size();
        ArrayList<Integer> ret = triangle.get(s - 1);
        for (int i = s - 2; i >= 0; i--) {
            ArrayList<Integer> preLevel = triangle.get(i);
            for (int j = 0, l = preLevel.size(); j < l; j++) {
                ret.set(j, preLevel.get(j) + Math.min(ret.get(j), ret.get(j + 1)));
            }
        }
        return ret.get(0);
    }
}
