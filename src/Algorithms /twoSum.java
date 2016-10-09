import java.util.*;

public class twoSum{
	//Runtime: O(n^2)
	public static int[] sum(int[] nums, int target){
		for(int i = 0; i < nums.length;++i){
			for(int j = 0; j < nums.length;++j){
				if(nums[j] == target - nums[i]) return new int[] {i,j};
			}
		}
		throw new IllegalArgumentException("no two sum");
	}

	//Runtime:O(n) linear time 
	public static int[] optimizeSum(int[] nums, int target){
		Hashtable<Integer,Integer>table = new Hashtable<Integer,Integer>();
		for(int i = 0; i < nums.length;++i){
			int complement = target - nums[i];
			if(table.containsKey(complement)) return new int[]{i,table.get(complement)};
			table.put(nums[i],i); //value,index
		}
		throw new IllegalArgumentException("no two sum");
	}


	public static void main(String args[]){
		int[] arr = {2,7,11,15};
		int target = 9;
		optimizeSum(arr,target);
	}
	




}