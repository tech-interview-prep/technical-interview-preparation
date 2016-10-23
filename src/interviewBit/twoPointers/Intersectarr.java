package interviewBit.twoPointers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by priyavivek on 10/27/15.
 *
 * Problem statement
 *
 * Find the intersection of two sorted arrays.
 OR in other words,
 Given 2 sorted arrays, find all the elements which occur in both the arrays.

 Example :

 Input :
 A : [1 2 3 3 4 5 6]
 B : [3 3 5]

 Output : [3 3 5]

 Input :
 A : [1 2 3 3 4 5 6]
 B : [3 5]

 Output : [3 5]
 NOTE : For the purpose of this problem ( as also conveyed by the sample case ), assume that elements that appear more than once in both arrays should be included multiple times in the final o
 */
public class Intersectarr {
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

        int lena = a.size();
        int lenb = b.size();
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (i < lena && j < lenb) {
            if (a.get(i) < b.get(j)) {
                i++;
            } else if (a.get(i) > b.get(j)) {
                j++;
            } else {
                result.add(a.get(i));
                i++;
                j++;
            }
        }

        return  result;

    }


    public static void main(String[] args) {
        Intersectarr a = new Intersectarr();
        // List<Integer> ip1 = new ArrayList<Integer>(Arrays.asList(1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101));
        // List<Integer> ip2 = new ArrayList<Integer>(Arrays.asList(5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98 ));

        List<Integer> ip1 = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 8, 9, 10, 10, 14, 16, 16, 17, 19, 20, 20, 20, 20, 21, 23, 26, 27, 29, 30, 30, 30, 31, 32, 33, 33, 34, 35, 35, 36, 37, 39, 39, 41, 42, 43, 43, 44, 44, 45, 46, 46, 47, 49, 51, 52, 53, 55, 55, 56, 57, 58, 59, 60, 65, 66, 66, 68, 68, 69, 69, 70, 70, 70, 71, 73, 75, 75, 75, 79, 80, 80, 81, 82, 85, 87, 91, 92, 98, 98, 98, 99, 100, 101));
        List<Integer> ip2 = new ArrayList<Integer>(Arrays.asList(4, 7, 10, 10, 15, 17, 19, 20, 24, 27, 27, 30, 31, 35, 40, 41, 42, 46, 48, 49, 50, 51, 54, 57, 62, 62, 63, 66, 67, 68, 69, 70, 71, 73, 74, 78, 80, 81, 92, 94, 99, 101));
        ArrayList<Integer> result = new ArrayList<Integer>();
        result = a.intersect(ip1, ip2);

    }

}
