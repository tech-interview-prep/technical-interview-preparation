package leetcode_online_judge.Java;

import java.util.ArrayList;
import java.util.List;

public class _163MissingRanges {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
		List<String> missingRanges = new ArrayList<String>();
		int begin = lower;
		for (int number : A) {
			if (number != begin) {
				missingRanges.add(generateRange(begin, number - 1));
			}
			begin = number + 1;
		}
		if (begin <= upper) {
			missingRanges.add(generateRange(begin, upper));
		}
		return missingRanges;
	}

	String generateRange(int begin, int end) {
		return (begin == end) ? (begin + "") : (begin + "->" + end);
	}

    public static void main(String[] args) {
        _163MissingRanges maximumProductSubarray = new _163MissingRanges();
        int A[] = {0, 1, 3, 50, 75, 120};
        System.out.println(maximumProductSubarray.findMissingRanges(A, 0, 150));
    }
}