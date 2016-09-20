  /*
  There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. (Read more about how a graph is represented)[https://www.khanacademy.org/computing/computer-science/algorithms/graph-representation/a/representing-graphs].

Hints:
This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
(Topological Sort via DFS)[https://class.coursera.org/algo-003/lecture/52]] - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via (BFS)[http://en.wikipedia.org/wiki/Topological_sorting#Algorithms].
   */
package facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/course-schedule-ii/
 * @author bkoteshwarreddy
 */
public class _210CourseScheduleII {
}

class Solution_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            degree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < degree.length; ++i) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int top = queue.remove();
            result[index++] = top;
            for (int i = 0; i < prerequisites.length; ++i) {
                if (prerequisites[i][1] == top) {
                    degree[prerequisites[i][0]]--;
                    if (degree[prerequisites[i][0]] == 0)
                        queue.offer(prerequisites[i][0]);
                }
            }
        }
        if (index == numCourses)
            return result;
        return new int[0];
    }
}
