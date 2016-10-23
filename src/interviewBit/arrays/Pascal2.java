package interviewBit.arrays;

import java.util.ArrayList;

/**
 * Problem statement
 *
 *
 * Given an index k, return the kth row of the Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Input : k = 3

 Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1].
 Note:Could you optimize your algorithm to use only O(k) extra space?
 *
 */
public class Pascal2 {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int nCk = 1;
        for (int k = 0; k <= a; k++) {
            result.add(nCk);
            nCk = nCk * (a-k) / (k+1);
        }
        return result;

    }
}
