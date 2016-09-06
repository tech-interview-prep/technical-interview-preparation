package facebook;

/*
	find the minimum and maximum element from an array with minimum time of comparision

	Link: https://gist.github.com/bittib/5567049

*/
public class MinAndMaxWithMinTime {
    /*
        Time Complexity : Comparision time : 3 * n/2 + 1
     */
    public int[] findMinMax(int[] A){
        int n = A.length;
        if (n == 0) return null;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i=0; i < n-1; i+=2){
            int smaller = A[i], bigger = A[i+1];
            if (A[i] > A[i+1]){
                smaller = A[i+1];
                bigger = A[i];
            }
            if (smaller < min) {
                min = smaller;
            }
            if (bigger > max) {
                max = bigger;
            }
        }
        if (n % 2 == 1){
            if (A[n-1] < min){
                min = A[n-1];
            }
            else if (A[n-1] > max){
                max = A[n - 1];
            }
        }
        return new int[]{min, max};
    }
}
