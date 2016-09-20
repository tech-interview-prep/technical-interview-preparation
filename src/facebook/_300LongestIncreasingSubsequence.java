/*
    Longest Increasing Sequence

    Link: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
          https://gist.github.com/search?l=java&q=LongestIncreasingSequence
          http://www.codelibrary.ml/lis-nlogn
          http://www.codelibrary.ml/lis/java

*/
package facebook;

import java.util.Arrays;

public class _300LongestIncreasingSubsequence {

}

class Solution_LongestIncreasingSequence {
    /*
 * Dynamic Programming Solution
 * f[i] : longest increasing sequence of A[0..i], f[i] = max{f[j]} + 1,  0<= j < i
 * Time complexity : O(n^2) ; Space complexity : O(n)
 */
    public int[] lis(int[] x) {
        int n = x.length;
        int[] len = new int[n];
        Arrays.fill(len, 1);
        int[] pred = new int[n];
        Arrays.fill(pred, -1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (x[j] < x[i] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    pred[i] = j;
                }
            }
        }
        int bi = 0;
        for (int i = 1; i < n; i++) {
            if (len[bi] < len[i]) {
                bi = i;
            }
        }
        int cnt = len[bi];
        int[] res = new int[cnt];
        for (int i = bi; i != -1; i = pred[i]) {
            res[--cnt] = x[i];
        }
        return res;
    }

/*
 * Greedy + binary Search
 * Time complexity : O(nlgn), Space complexity : O(n)
 *
 */
    public static int[] lisB(int[] a) {
    int n = a.length;
    int[] tail = new int[n];
    int[] prev = new int[n];

    int len = 0;
    for (int i = 0; i < n; i++) {
        int pos = lower_bound(a, tail, len, a[i]);
        if (pos == len) {
            ++len;
        }
        prev[i] = pos > 0 ? tail[pos - 1] : -1;
        tail[pos] = i;
    }

    int[] res = new int[len];
    for (int i = tail[len - 1]; i >= 0; i = prev[i]) {
        res[--len] = a[i];
    }
    return res;
}

    static int lower_bound(int[] a, int[] tail, int len, int key) {
        int lo = -1;
        int hi = len;
        while (hi - lo > 1) {
            int mid = (lo + hi) >>> 1;
            if (a[tail[mid]] < key) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi;
    }

    // ------------------------------- //
    // DP version, Time Complexity : O(n^2)
    public int LIS(int[] A){
        if (A == null || A.length == 0) return 0;
        int n = A.length;
        int[] f = new int[n];
        for (int i=0; i<n; i++){
            f[i] = 1;
            for (int j=0; j<i; j++){
                if (A[j] <= A[i] && f[j] + 1 > f[i])
                    f[i] = f[j] + 1;
            }
        }
        return f[n-1];
    }
    // O(nlgn) version by using binary search
    public int LIS_B(int[] A){
        if (A == null || A.length == 0) return 0;
        int[] d = new int[A.length];
        d[0] = A[0];
        int k = 0;
        for (int i=1; i<A.length; i++){
            int j = findFirstGreaterThanElement(d, 0, k, A[i]);
            d[j] = A[i];
            if (j > k)
                k++;
        }
        return k+1;
    }

    int findFirstGreaterThanElement(int[] A, int low, int high, int key){
        while (low <= high){
            int mid = low + (high - low)/2;
            if (A[mid] <= key)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}
