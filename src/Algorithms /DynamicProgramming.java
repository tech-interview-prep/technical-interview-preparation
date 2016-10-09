import java.util.*;

public class DynamicProgramming {
	public static void main(String[] args){
		int[] arr = {3,2,7,1};
		int[] solution = new int[arr.length];
		//System.out.println(optimizeSpaceMaxSubArray(arr));
		//subsetSum(arr,0,0,6,solution);
		System.out.println(longestCommonSubsequence("abcd","abd"));

	}

	//Big-O: O(N)
	//Space: O(n)
	public static int maxSubArray(int[] arr){
		int max = arr[0];
		int[] sum = new int[arr.length];
		sum[0] = arr[0];

		for(int i = 1; i < arr.length;++i){
			//return the max of either the previous sum + current number or 
			//current number (the case in which the current number is greater than n-1 elements sum)
			sum[i] = Math.max(sum[i-1] + arr[i],arr[i]);
			max = Math.max(sum[i],max); 
		}
		return max;
	}
	//Big-O: O(N)
	//Space: O(1)
	public static int optimizeSpaceMaxSubArray(int[] arr){
		int max = arr[0];
		int sum = arr[0];

		for(int i = 1; i < arr.length;++i){
			sum = Math.max(sum + arr[i],arr[i]);
			max = Math.max(max,sum);
		}
		return max;
	}

	//Subset sum probem 
	//Given a set of positive integers and a value sum S, find out if there exist
	//a subset in array whose sum is equal to given sum.
	//{3,2,7,1}, sum:6 -> {3,2,1}
	//Big-O: 2^n
	public static void subsetSum(int[] arr, int currentSum, int index, int sum, int[] solution){
		if(currentSum == sum){
			for(int i = 0; i < solution.length;++i){ //solution are those numbers marked as 1
				if(solution[i] == 1){
					//System.out.println("Sum subset: " + arr[i]);
				}
			}

		}
		//have to break out of recursion since you have reached the end and haven't gotten the correct currSum
		else if(index == arr.length){
			return;
		} 
		else {
			//label valid index for solution
			solution[index] = 1;
			currentSum += arr[index];
			subsetSum(arr,currentSum,index+1,sum,solution); //recursive call to next index
			
			//when you have to subtract since currentSum is beyond sum.
			//therefore you call next index to see if it adds up to sum.
			currentSum -= arr[index];
			solution[index] = 0;
			subsetSum(arr,currentSum,index+1,sum,solution);
		}
	}

	/*
	 * Longest increasing subsequence
	 * O(n^2 + O(n) = O(n^2))
	 */

	public int findSubsequence(int[] arr){
		//let max[i] represent the length of the longest increasing subsequence
		//if any element before i is smaller than arr[i], then max[i] = max(max[i],max[j]+1)

		if(arr == null || arr.length == 0) return 0;

		int[] max = new int[arr.length];

		for(int i = 0; i < arr.length;++i){
			max[i] = 1;
			for(int j = 0; j < i; ++j){
				if(arr[i] > arr[j]){
					max[i] = Math.max(max[i],max[j]+1);
				}
			}
		}
		int res = 0;
		for(int i = 0; i < max.length;++i){
			if(max[i] > res){
				res = max[i]; //returns the max result
			}
		}
		return res;
	}

	//Big-O: n log n
	public static int optimizedSubsequence(int[] arr){
		if(arr.length == 0 || arr == null) return 0;

		ArrayList<Integer>res = new ArrayList<Integer>();

		for(int num: arr){
			if(res.size() == 0) res.add(num);
			else if(num > res.get(res.size()-1)){
				res.add(num);
			} else {
				int i = 0;
				int j = res.size()-1;
				while(i < j){
					int mid = (i + j)/2;
					if(res.get(mid) < num){
						i = mid + 1;
					} else {
						j = mid;
					}
				}
				res.set(j,num);
			}
		}
		return res.size();
	}

	//Longest common substring (find longest string that is string of 2 or more strings)
	//O(n^2)
	public static int lcs(String s, String t){
		int max = 0;
		int[][] dp = new int[s.length()][t.length()];

		for(int i = 0; i < s.length();++i){
			for(int j = 0; j < t.length();++j){
				if(s.charAt(i) == t.charAt(j)){
					if(i == 0 || j == 0){
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i-1][j-1] + 1;
					} 
					if(max < dp[i][j])
						max = dp[i][j];
				}
			}
		}
		return max;

	}

	//Longest common subsequence (find the longest subsequence common to all subsequences common to all subsequences in a set of sequences)
	//Recursively will be 2^n
	public static int longestCommonSubsequence(String s, String t){
		int[][] dp = new int[s.length()+1][t.length()+1];
		
		for(int i = 0; i <= s.length();++i){
			for(int j = 0; j <= t.length();++j){
				if(i == 0 || j == 0) dp[i][j] = 0;
				else if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}

		return dp[s.length()][t.length()];
	}

	

	

	



}