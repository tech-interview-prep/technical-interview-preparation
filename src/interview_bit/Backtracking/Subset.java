package interview_bit.backtracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by priyavivek on 11/8/15.
 *
 * Problem statement
 *
 * Given a set of distinct integers, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 Also, the subsets should be sorted in ascending ( lexicographic ) order.
 Example :

 If S = [1,2,3], a solution is:

 [
 [],
 [1],
 [1, 2],
 [1, 2, 3],
 [1, 3],
 [2],
 [2, 3],
 [3],
 ]
 */
public class Subset {

    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> A;
    int N;

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> temp;
        res = new ArrayList<>();
        temp = new ArrayList<>();
        this.A = A;
        N = A.size();
        Collections.sort(A);

        subset(0, temp);

        //Sort result in lexicographic order.
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
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

        return res;

    }

    //Compute all subsets recursively.Every element is either present or not present
    private void subset(int index, ArrayList<Integer> arr) {

        if (index == N) {
            res.add(new ArrayList<>(arr));
            return;
        }

        //Element not present
        subset(index + 1, arr);

        //Element present
        arr.add(A.get(index));
        subset(index + 1, arr);

        arr.remove(arr.size() - 1);

    }


    public static void main(String[] args){


        Subset s = new Subset();
        ArrayList<Integer> ip = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        result = s.subsets(ip);

        int m=9;
    }
}
