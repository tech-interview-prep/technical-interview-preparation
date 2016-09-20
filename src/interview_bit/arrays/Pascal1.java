package interview_bit.arrays;

import java.util.ArrayList;

/**
 * Problem statement
 *
 *
 * Given numRows, generate the first numRows of Pascal’s triangle.

 Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

 Example:

 Given numRows = 5,

 Return

 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Pascal1 {
    public ArrayList<ArrayList<Integer>> generate(int a) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int nck;

        for(int i=0;i<a;i++){
            nck = 1;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                temp.add(nck);
                nck = nck * (i-j)/(j+1);

            }

            result.add(temp);

        }

        return result;

    }

}
