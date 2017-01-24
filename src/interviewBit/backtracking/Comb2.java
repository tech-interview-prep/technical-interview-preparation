package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by priyavivek on 11/9/15.
 *
 * Problem statement
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 The solution set must not contain duplicate combinations.
 Example :

 Given candidate set 10,1,2,7,6,1,5 and target 8,

 A solution set is:

 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 Example : itertools.combinations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Comb2 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {

        Collections.sort(a);
        ArrayList<Integer> temp = new ArrayList<>();
        getCombos(a, 0, b, temp);

        //Sort result in ascending order
        Collections.sort(result, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                int an = a.size();
                int bn = b.size();
                for (int i = 0; i < Math.min(an, bn); i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(an, bn);
            }
        });



        return result;

    }

    public void getCombos(ArrayList<Integer> a,int startInd,int currSum,ArrayList<Integer> temp1){
        //Case when elements add up to the sum
        if(currSum == 0){
            result.add(temp1);
            return;
        }

        //The sum of elements goes over the required sum
        if(currSum < 0){
            return;
        }
        int i = startInd;

        while(i <a.size()){
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.addAll(temp1);
            temp2.add(a.get(i));
            int j = i+1;

            //Recursively proceed to the next element and update sum accordingly
            getCombos(a, i+1, currSum - a.get(i),temp2);

            //Iterate over repeated elements in order to avoid counting combinations already found
            while(j<a.size()){
                if(a.get(j) != a.get(i)){
                    break;
                }
                j++;

            }

            i = j;


        }


    }

    public static void main(String[] args){

        Comb2 c = new Comb2();
        ArrayList<Integer> ip = new ArrayList<Integer>(Arrays.asList(10,1,2,7,6,1,5));

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = c.combinationSum(ip,8);



    }




}
