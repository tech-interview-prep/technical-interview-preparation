package algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();

        int[] array = {3, 6, 9, 12, 15, 18};
        for (int i = 0; i < 20; i++) {
            int loc = sol.binarySearch(array, i);
            int loc2 = sol.binarySearchRecursive(array, i, 0, array.length - 1);
            System.out.println(i + ": " + loc + " " + loc2);
        }
    }

    public int binarySearch(int[] input, int target) {
        if(input == null || input.length == 0) {
            return -1;
        }

        int low = 0;
        int high = input.length - 1;
        int mid;

        while(low <= high) {
            mid = low + (high - low) >> 1;

            if(input[mid] == target) {
                return mid;
            } else if(input[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int binarySearchRecursive(int[] a, int x, int low, int high) {
        if (low > high) return -1; // Error

        int mid = low + (high - low) / 2;
        if (a[mid] == x) {
            return mid;
        } else if (a[mid] > x) {
            return binarySearchRecursive(a, x, low, mid - 1);
        } else {
            return binarySearchRecursive(a, x, mid + 1, high);
        }
    }
}
