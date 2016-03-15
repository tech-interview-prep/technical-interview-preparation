package facebook;

import java.util.ArrayList;
import java.util.Arrays;

/* 	
	Power set P(S) of a set S is the set of all subsets of S. For example 
	S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}. 

	If S has n elements in it then P(s) will have 2^n elements
	
	Link: http://www.careercup.com/question?id=5670502550994944

*/	
public class SubSet {
	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) { // Base case - add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); 
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset); //
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size(); /* Compute 2^n */ 
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	public ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>(); 
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return subset;
	}

    /*
        Given a set of distinct integers, S, return all possible subsets.

        Note:

        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        For example,
        If S = [1,2,3], a solution is:

        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]
    */

    /*
     * Implemented based DFS + backtrack
     */
    public ArrayList<ArrayList<Integer>> subsets_DFS(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) return list;
        Arrays.sort(S);
        for (int i=0; i<=S.length; i++){
            dfs(S, 0, new int[i], 0, list);
        }
        return list;
    }

    void dfs(int[] S, int si, int[] T, int ti, ArrayList<ArrayList<Integer>> list){
        if (ti == T.length){
            ArrayList<Integer> sol = new ArrayList<Integer>();
            for (int i=0; i<ti; i++)
                sol.add(T[i]);
            list.add(sol);
            return;
        }
        for (int i = si; i<S.length; i++){
            T[ti] = S[i];
            dfs(S, i+1, T, ti+1, list);
        }
    }

    /*
     * Iterative version I : based on bit permutation
     */
    public ArrayList<ArrayList<Integer>> subsets_I(int[] S) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) return list;
        Arrays.sort(S);
        int n = S.length, maxn = 1 << n;
        for (int i=0; i<maxn; i++){
            ArrayList<Integer> sol = new ArrayList<Integer>();
            int key = i;
            for (int j=0; j<n; j++){
                if ((key & 1) != 0)
                    sol.add(S[j]);
                key >>= 1;
            }
            list.add(sol);
        }
        return list;
    }

    /*
     * Iterative version II : based on adding each element to all subset increamentally.
     */
    public ArrayList<ArrayList<Integer>> subsets_II(int[] S){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) return list;
        list.add(new ArrayList<Integer>());
        for (int i=0; i<S.length; i++){
            int size = list.size();
            for (int j = 0; j < size; j++){
                ArrayList<Integer> sol = new ArrayList<Integer>(list.get(j));
                sol.add(S[i]);
                list.add(sol);
            }
        }
        return list;
    }
}
