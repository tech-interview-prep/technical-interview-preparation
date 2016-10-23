package interviewBit.arrays;

import java.util.ArrayList;

/**
 * Problem statement
 *
 *Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.

 Do it in place.

 Example

 Given array A as

 1 0 1
 1 1 1
 1 1 1
 On returning, the array A should be :

 0 0 0
 1 0 1
 1 0 1
 Note that this will be evaluated on the extra memory used. Try to minimize the space and time complexity.
 *
 *
 */


public class Setzero {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {


        int numRows = a.size();
        int numCols = a.get(0).size();

        ArrayList<Integer> rowInds = new ArrayList<Integer>();
        ArrayList<Integer> colInds = new ArrayList<Integer>();


        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (a.get(i).get(j) == 0) {
                    if (!rowInds.contains(i)) {
                        rowInds.add(i);
                    }

                    if (!colInds.contains(j)) {
                        colInds.add(j);
                    }

                }

            }

        }


        ArrayList<Integer> currRow = new ArrayList<Integer>();
        for (int i = 0; i < numRows; i++) {
            currRow = a.get(i);
            if (rowInds.contains(i)) {
                for (int j = 0; j < numCols; j++) {
                    currRow.set(j, 0);

                }

            }

            for (int k = 0; k < colInds.size(); k++) {
                currRow.set(colInds.get(k), 0);
            }

        }




    }

    public static void main(String[] args) {
        Setzero x = new Setzero();
        ArrayList<ArrayList<Integer>> ip = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        ip.add(temp);
        temp = new ArrayList<Integer>();

        temp.add(1);
        temp.add(0);
        ip.add(temp);
        x.setZeroes(ip);

        int ff = 5;




    }






}
