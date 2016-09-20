package interview_bit.arrays;

import java.util.ArrayList;

/**
 * Problem statement
 *
 * Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]
 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 *
 *
 */
public class Maxset {
    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> subarrays = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();


        //Obtain all the sub-arrays of non-negative numbers
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0;i<a.size();i++){
            if(a.get(i) >= 0 ){
                temp.add(a.get(i));
            }else{
                if(temp.size() > 0) {
                    subarrays.add(temp);
                }

                temp = new ArrayList<Integer>();
            }

        }

        //Account for the last sub-array

        if(temp.size() > 0) {
            subarrays.add(temp);
        }

        long segmentsum;
        long segmentsummax = -1;

        for(int j=0;j<subarrays.size();j++){
            segmentsum=0;
            for(int k=0;k<subarrays.get(j).size();k++){
                segmentsum += subarrays.get(j).get(k);

            }
            //Get sub-array with max sum and check for ties
            if(segmentsum > segmentsummax){
                segmentsummax = segmentsum;
                result = subarrays.get(j);
            }else if(segmentsum == segmentsummax){

                if(subarrays.get(j).size() > result.size()){
                    result = subarrays.get(j);
                }


            }

        }

        return result;

    }


}
