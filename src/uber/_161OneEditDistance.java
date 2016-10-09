/**
 * One Edit Distance
 *
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 *  http://www.careercup.com/question?id=5092486548553728
 *  https://gist.github.com/bittib/5677448
 */

package uber;

/**
 * https://leetcode.com/problems/one-edit-distance/
 * @author bkoteshwarreddy
 */
public class _161OneEditDistance {

}

class Solution_OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n)
            return isOneEditDistance(t, s);
        if (n - m > 1)
            return false;
        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i))
            i++;
        if (i == m)
            return shift > 0;
        if (shift == 0)
            i++;
        while (i < m && s.charAt(i) == t.charAt(i + shift))
            i++;
        return i == m;
    }

    public boolean onlyOneEdit(String first, String second) {
        if (first.equals(second)) {
            return false;
        }

        int l1 = first.length();
        int l2 = second.length();

        if (l1 - l2 > 1 || l2 - l1 > 1) {
            // At least two edits .. no need to continue
            return false;
        }

        String longer = (l1 > l2) ? first : second;
        String shorter = (l1 > l2) ? second : first;

        for (int i = 0; i < shorter.length(); i++) {
            if (longer.charAt(i) != shorter.charAt(i)) {
                int shift = (l1 == l2) ? 0 : 1;
                return longer.substring(i + 1 + shift).equals(shorter.substring(i + 1));
            }
        }
        // No difference detected until the end of the shorter string
        return true;
    }
}
