  /*
  Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

Hint:

Expected runtime complexity is in O(log n) and the input is sorted.
   */

package facebook;

/**
 * https://leetcode.com/problems/h-index-ii/
 * @author bkoteshwarreddy
 */

public class _275H_IndexII {
}

class Solution_H_IndexII {
    // O(log n)
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (citations[mid] < citations.length - mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return citations.length - left;
    }

/*****************************************************************************/

    // O(n)
    public int hIndex2(int[] citations) {
        int result = 0;
        for (int i = 0; i < citations.length; ++i) {
            result = Math.max(result, Math.min(citations[i], citations.length - i));
        }
        return result;
    }
}
