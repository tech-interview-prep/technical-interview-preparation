package facebook;

/* 	
	You are given an integer K, and a sorted array as an input which has been rotated about an unknown pivot.
	For example, 4 5 6 7 8 9 1 2 3.
    We need to write a function which should return the index of K in the array, if K is present, else return -1.
	
	Link: http://www.careercup.com/question?id=4852029923000320

*/	
public class RotatedSortedArray {
    public int search(int a[], int x) {
        return search(a, 0 , a.length-1, x);
    }

    private int search(int a[], int left, int right, int x) {
        int mid = (left + right) / 2;
        if (x == a[mid]) { // Found element
            return mid;
        }
        if (right < left) {
            return -1;
        }

		/* While there may be an inflection point due to the rotation, either the left or
		 * right half must be normally ordered.  We can look at the normally ordered half
		 * to make a determination as to which half we should search.
		 */
        if (a[left] < a[mid]) { // Left is normally ordered.
            if (x >= a[left] && x <= a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[left]) { // Right is normally ordered.
            if (x >= a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) { // Left is either all repeats OR loops around (with the right half being all dups)
            if (a[mid] != a[right]) { // If right half is different, search there
                return search(a, mid + 1, right, x);
            } else { // Else, we have to search both halves
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}
