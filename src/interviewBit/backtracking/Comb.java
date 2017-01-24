package interviewBit.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by priyavivek on 12/1/15.
 *
 * Problem statement
 *
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, ... , ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 The combinations themselves must be sorted in ascending order.
 CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
 The solution set must not contain duplicate combinations.
 Example,
 Given candidate set 2,3,6,7 and target 7,
 A solution set is:

 [2, 2, 3]
 [7]
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
 Example : itertools.combinations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Comb {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    HashMap<ArrayList<Integer>,Integer> mappings = new HashMap<ArrayList<Integer>,Integer>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<Integer> currList = new ArrayList<Integer>();
        findCombs(a,currList,b);

        //Sort elements in a combination in non-descending order and combinations in ascending order
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

    public void findCombs(ArrayList<Integer> a, ArrayList<Integer> currList,int targetSum){

        if(targetSum == 0){
            Collections.sort(currList);

            //Ensure no duplicate combinations
            if(!mappings.containsKey(currList)){
                mappings.put(currList,1);
                result.add(currList);
            }

            return;

        }

        if(targetSum < 0){
            return;
        }

        for(int i=0;i<a.size();i++){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(currList);
            temp.add(a.get(i));
            findCombs(a,temp,targetSum - a.get(i));
        }
    }
}
