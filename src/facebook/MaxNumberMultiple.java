package facebook;

import java.util.ArrayList;
import java.util.Random;

/*
	Given an array of integers. We have to find the max element of the array, which is at multiple places
	in the array and return any one of the indices randomly.

	Link: http://www.careercup.com/question?id=5764338593824768

*/
public class MaxNumberMultiple {
    public int getMaxRandmonIndex(int[] arr) {
        int currentMax = Integer.MIN_VALUE;
        ArrayList<Integer> index = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
                if (index.size() > 0) {
                    index.clear();
                }
                index.add(i);
            } else if (arr[i] == currentMax) {
                index.add(i);
            }
        }
        Random rand = new Random();
        int ind = rand.nextInt(index.size());
        return index.get(ind);
    }
}
