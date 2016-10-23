package facebook;

/**
 * Recursive algorithm to return the closest element
 */
public class BinarySearchClosest {
    public static void main(String[] args) {
        Solution_BinarySearchClosest sol = new Solution_BinarySearchClosest();

        int[] array = {3, 6, 9, 12, 15, 18};
        for (int i = 0; i < 20; i++) {
            int loc = sol.binarySearchRecursiveClosest(array, i, 0, array.length - 1);
            System.out.println(i + ": " + loc);
        }
    }
}

class Solution_BinarySearchClosest {
    public int binarySearchRecursiveClosest(int[] a, int x, int low, int high) {
        if (low > high) { // high is on the left side now
            if (high < 0) return low;
            if (low >= a.length) return high;
            if (x - a[high] < a[low] - x) {
                return high;
            }
            return low;
        }

        int mid = low + (high - low) / 2;
        if (a[mid] < x) {
            return binarySearchRecursiveClosest(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursiveClosest(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }
}
