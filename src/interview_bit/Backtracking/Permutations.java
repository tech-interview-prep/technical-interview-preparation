package interview_bit.backtracking;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by priyavivek on 11/9/15.
 *
 * Problem statement
 *
 * Given a collection of numbers, return all possible permutations.

 Example:

 [1,2,3] will have the following permutations:

 [1,2,3]
 [1,3,2]
 [2,1,3]
 [2,3,1]
 [3,1,2]
 [3,2,1]
 NOTE
 No two entries in the permutation sequence should be the same.
 For the purpose of this problem, assume that all the numbers in the collection are unique.
 Warning : DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
 Example : next_permutations in C++ / itertools.permutations in python.
 If you do, we will disqualify your submission retroactively and give you penalty points.
 */
public class Permutations {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
        ArrayList<Integer> perms = new ArrayList<>();
        getPermuatations(a,perms);

        return result;


    }

    public void getPermuatations(ArrayList<Integer> input,ArrayList<Integer> perms){

        if(input.size() == 1){
            perms.add(input.get(0));
            result.add(perms);
            return;
        }

        for(int i=0;i<input.size();i++){
            int j = 0;
            ArrayList<Integer> ip = new ArrayList<>();
            while(j<input.size()){
                if(j!=i) {
                    ip.add(input.get(j));
                }
                j++;
            }

            ArrayList<Integer> subPerms = new ArrayList<>();
            subPerms.addAll(perms);
            subPerms.add(input.get(i));
            getPermuatations(ip,subPerms);
        }

    }

    public static void main(String[] args){
        Permutations p = new Permutations();
        ArrayList<Integer> ip = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result = p.permute(ip);


    }
}
