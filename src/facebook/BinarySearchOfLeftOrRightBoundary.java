package facebook;

/* 	
	Sorted array, given a key, find its left most index or right most index in array.
	If it isn't in array, return -1.

	Binary Search Of Left Or Right Boundary

	Link: https://gist.github.com/bittib/5651966

*/	
public class BinarySearchOfLeftOrRightBoundary {
    public static int findLeftMostElement(int[] A, int key){
        if (A.length == 0) return -1;
        int low = 0, high = A.length-1;
        while (low < high-1){
            int mid = low + (high - low)/2;
            if (A[mid] < key)
                low = mid;
            else
                high = mid;
        }
        if (A[low] == key)
            return low;
        if (A[high] == key)
            return high;
        return -1;
    }
    // Using standard binary search template
    public static int findLeftMostElementB(int[] A, int key){
        if (A.length == 0) return -1;
        int low = 0, high = A.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (A[mid] == key && (mid == 0 || A[mid-1] < key))
                return mid;
            else if (A[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int findRightMostElement(int[] A, int key){
        if (A.length == 0) return -1;
        int low = 0, high = A.length-1;
        while (low < high-1){
            int mid = low + (high - low)/2;
            if (A[mid] <= key)
                low = mid;
            else
                high = mid;
        }
        if (A[high] == key)
            return high;
        if (A[low] == key)
            return low;
        return -1;
    }
    // Using standard binary search template
    public static int findRightMostElementB(int[] A, int key){
        if (A.length == 0) return -1;
        int low = 0, high = A.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if (A[mid] == key && (mid == A.length-1 || A[mid+1] > key))
                return mid;
            else if (A[mid] <= key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
