package facebook;

import java.util.Arrays;

/*
    Select Top K smallest Elements

     https://gist.github.com/bittib/5652140
          http://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/

*/
public class FindTopKSmallestElements {
    public static int[] firstKSmallestElements(int[] A, int k) {
        int n = A.length;
        if (n == 0 || k == 0 || n < k) return null;
        int idx = selectK(A, 0, n - 1, k);
        //  int idx = selectKIterative(A, 0, n-1, k);
        return Arrays.copyOf(A, k);
    }

    static int selectK(int[] A, int low, int high, int k) {
        int pivot = partition(A, low, high);
        int leftCnt = pivot - low + 1;
        if (leftCnt == k)
            return pivot;
        if (leftCnt < k)
            return selectK(A, pivot + 1, high, k - leftCnt);
        else
            return selectK(A, low, pivot - 1, k);
    }

    static int partition(int[] A, int low, int high) {
        int pivot = low + (high - low) / 2;
        if (pivot != high) {
            swap(A, pivot, high);
            pivot = high;
        }
        while (low <= high) {
            if (A[low] < A[pivot])
                low++;
            else if (A[high] >= A[pivot])
                high--;
            else {
                swap(A, low++, high++);
            }
        }
        swap(A, low, pivot);
        return low;
    }

    //Iterative version of selectK
    static int selectKIterative(int[] A, int low, int high, int k) {
        int leftCnt = 0, pivot = low;
        do {
            pivot = partition(A, low, high);
            leftCnt = pivot - low + 1;
            if (leftCnt < k) {
                low = pivot + 1;
                k -= leftCnt;
            } else if (leftCnt > k) {
                high = pivot - 1;
            }
        } while (leftCnt != k);
        return pivot;
    }

    static void swap(int[] A, int i, int j) {
        int t = A[i]; A[i] = A[j]; A[j] = t;
    }
}
