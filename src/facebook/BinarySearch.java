package facebook;

/**
 * Binary Search
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution_BinarySearch sol = new Solution_BinarySearch();

        int[] array = {3, 6, 9, 12, 15, 18};
        for (int i = 0; i < 20; i++) {
            int loc = sol.binarySearch(array, i);
            int loc2 = sol.binarySearchRecursive(array, i, 0, array.length - 1);
            System.out.println(i + ": " + loc + " " + loc2);
        }
    }
}

class Solution_BinarySearch {
    public int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) return -1; // Error

        int mid = low + (high - low) / 2;
        if (a[mid] < x) {
            return binarySearchRecursive(a, x, mid + 1, high);
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return mid;
        }
    }
}
