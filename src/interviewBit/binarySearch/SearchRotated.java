package interviewBit.binarySearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by priyavivek on 10/22/15.
 *
 * Problem statement
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

 You are given a target value to search. If found in the array, return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Input : [4 5 6 7 0 1 2] and target = 4
 Output : 0

 NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
 *
 */
public class SearchRotated {
    public int search(final List<Integer> a, int b) {
        int lo = 0;
        int hi = a.size() - 1;

        //Check if sorted array is rotated
        if (a.get(lo) > a.get(hi)) {


            int startInd = getStartInd(a);

            if (a.get(startInd) == b) {
                return startInd;
            }


            if (b > a.get(a.size() - 1)) {
                lo = 0;
                hi = startInd - 1;
            } else {
                lo = startInd + 1;
                hi = a.size() - 1;
            }
        }

        return numSearch(a, b, lo, hi);


    }

    public int getStartInd(final List<Integer> a) {
        int lo = 0;
        int hi = a.size() - 1;
        int mid;

        while (hi > lo + 1) {
            mid = (hi + lo) / 2;
            if (a.get(lo) > a.get(mid)) {
                hi = mid;
            } else if (a.get(mid) > a.get(hi)) {
                lo = mid;
            }
        }

        return lo + 1;
    }

    public int numSearch(final List<Integer>a, int b, int lo, int hi) {
        int mid;
        while (hi >= lo) {
            mid = (lo + hi) / 2;
            if (b > a.get(mid)) {
                lo = mid + 1;
            } else if (b < a.get(mid)) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchRotated s = new SearchRotated();
        ArrayList<Integer> ip = new ArrayList<Integer>(Arrays.asList(180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177));
        int result = s.search(ip, 42);
        System.out.println(result);

    }
}
