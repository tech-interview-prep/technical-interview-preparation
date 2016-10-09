public class LargestSumSubArray {
	
	public static void main(String[] args){
		int[] arr = {4,3,-5,0,6,-8,12,3,-9,2,5,8,-3,4,8,0,3,-3,-5,
			-9,4,2};
		System.out.println(largestSum(arr));
	}

	public static int largestSum(int[] arr){
		//essentially need 2 pointers to keep track of sum
		int currentStart = 0, currentEnd = 0, currentSum = 0;

		//values used to get track of largest
		int maxStart = 0, maxEnd = 0, maxSum = 0;
		
		while(currentEnd != arr.length){
			currentSum += arr[currentEnd]; //incrementing sum
			//update maximum sum and corresponding indices
			if(currentSum > maxSum){
				maxSum = currentSum;
				maxStart = currentStart;
				maxEnd = currentEnd;
			}
			//current subarray will not be apart of maximum subarray
			//move the ptr to next index
			if(currentSum <= 0){
				currentStart = currentEnd + 1;
				currentSum = 0;
			}
			currentEnd++;
		}
		System.out.println("maxSum: " + maxSum);
		System.out.println("Indexes (" + maxStart + "," + maxEnd + ")");
		return maxSum;
	}
}