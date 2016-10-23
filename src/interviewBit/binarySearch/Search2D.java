package interviewBit.binarySearch;
//import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Created by priyavivek on 10/20/15.
 *
 * Problem statement
 *
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix.

 This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than or equal to the last integer of the previous row.
 Example:

 Consider the following matrix:

 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target = 3, return 1 ( 1 corresponds to true )

 Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem
 */
public class Search2D {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {

        int rowNum;

        rowNum = getRowNum(0, a.size() - 1, b, a);


        ArrayList<Integer> currRow = a.get(rowNum);
        return searchRow(0, currRow.size() - 1, b, currRow);


    }

    public int getRowNum(int lo, int hi, int b, ArrayList<ArrayList<Integer>> a) {
        if (lo > hi) {
            return a.size() - 1;
        } else {
            int mid = (lo + hi) / 2;
            int midVal = a.get(mid).get(0);
            if (mid >= a.size() - 1) {
                return mid;
            }
            int midValNext = a.get(mid + 1).get(0);
            if (midVal == b) {
                return mid;
            } else if (b > midVal && b < midValNext) {
                return mid;
            } else if (midVal > b) {
                return getRowNum(lo, mid - 1, b, a);
            } else if (midVal < b) {
                return getRowNum(mid + 1, hi, b, a);
            } else {
                return mid;
            }


        }

    }


    public int searchRow(int lo, int hi, int b, ArrayList<Integer> a) {

        if (lo > hi) {
            return 0;
        } else {
            int mid = (lo + hi) / 2;
            int midVal = a.get(mid);
            if (midVal > b) {
                return searchRow(lo, mid - 1, b, a);
            } else if (midVal < b) {
                return searchRow(mid + 1, hi, b, a);
            } else {
                return 1;
            }


        }

    }


    public static void main(String[] args) {
        Search2D s = new Search2D();
        ArrayList<Integer> x = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 5, 6, 14, 14, 16, 19));
        ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList(22, 24, 28, 33, 35, 37, 38, 40, 41));
        ArrayList<Integer> z = new ArrayList<Integer>(Arrays.asList(45, 50, 52, 55, 56, 56, 57, 60, 60));
        ArrayList<Integer> w = new ArrayList<Integer>(Arrays.asList(63, 64, 66, 68, 68, 71, 78, 78, 79));
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(84, 89, 90, 91, 93, 94, 94, 97, 98));

        /*ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        ArrayList<Integer> z = new ArrayList<Integer>();
        ArrayList<Integer> x1 = new ArrayList<Integer>();
        ArrayList<Integer> y1 = new ArrayList<Integer>();
        ArrayList<Integer> z1 = new ArrayList<Integer>();
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        ArrayList<Integer> b1 = new ArrayList<Integer>();
        x.add(1);
        y.add(11);
        z.add(49);
        x1.add(74);
        y1.add(77);
        z1.add(78);
        a1.add(93);
        b1.add(94);*/

        ArrayList<ArrayList<Integer>> ip = new ArrayList<ArrayList<Integer>>();
        ip.add(x);
        ip.add(y);
        ip.add(z);
        ip.add(w);
        ip.add(a);


        /*ip.add(x);
        ip.add(y);
        ip.add(z);
        ip.add(x1);
        ip.add(y1);
        ip.add(z1);
        ip.add(a1);
        ip.add(b1);*/

        int result = s.searchMatrix(ip, 68);

        System.out.println(result);




    }
}
