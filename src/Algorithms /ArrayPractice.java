import java.util.*;
public class ArrayPractice {
	
	/** 
	 * Non-optimized recursive solution
	 * Runtime: Since each fib call makes two calls, we need to think of it as a binary tree.
	 * The height of a binary tree is O(n) which means the toal number of nodes is 2^n, so total runtime is O(2^n).
	 */
	public static int fibo(int num){
		if(num < 2) return num;
		else return fibo(num-1) + fibo(num-2);

	}

	/** 
	 * Optimized recursive fibonacci solution
	 */
	public static int memo(int num){
		Hashtable<Integer,Integer>map = new Hashtable<Integer,Integer>();
		
		if(num < 2) return num;

		if(map.containsKey(num)) return map.get(num);

		int res = memo(num-1) + memo(num-2);
		map.put(num,res);

		return res;
	}
	
	//Recursive Factorial
	public static int recursive_factorial(int number){
		if(number <= 1) return 1;

		else return number * recursive_factorial(number - 1);
	}
	//Iterative factorial
	public static int iterative_factorial(int number){
		int res = 1;
		while(number != 0){
			res = res * number;
			number--;
		}
		return res;
	}

	//Remove an provided element in array
	public static ArrayList<Integer> removeDuplicate(int[] arr, int value){
		ArrayList<Integer>res = new ArrayList<Integer>();
		for(int i = 0; i < arr.length;++i){
			if(value != arr[i]){
				res.add(arr[i]);
			} 
		}
		return res;
	}
	//Given an array and a value, remove all instances of that value and return length
	public static int retLen(int[] arr, int value){
		ArrayList<Integer>res = new ArrayList<Integer>();

		for(int i = 0; i < arr.length;++i){
			if(value != arr[i]) res.add(arr[i]);
		}
		return res.size();
	}
	//Remove all duplicates from array
	public static ArrayList<Integer> removeDuplicates(int[] arr){
		ArrayList<Integer>res = new ArrayList<Integer>();
		Set<Integer>set = new LinkedHashSet<Integer>(); //maintains

		for(int i = 0; i < arr.length;++i){
			if(!set.contains(arr[i])){
				set.add(arr[i]);
				res.add(arr[i]);
			}
		}
		return res;
	}
	//Given a array of inte­gers, in which every ele­ments occurs even num­ber of times except one 
	//num­ber which occurs odd num­ber of times. Find out that number.
	public static int oddOccurences(int[] arr){
		Hashtable<Integer,Integer>map = new Hashtable<Integer,Integer>();

		for(int i = 0; i < arr.length;++i){
			if(!map.containsKey(arr[i])) map.put(arr[i],1);
			else map.put(arr[i],map.get(arr[i])+1);
		}
		for(Map.Entry<Integer,Integer>entry: map.entrySet()){
			if(entry.getValue() % 2 == 1) return entry.getKey(); //check which have a odd value
		}
		throw new IllegalArgumentException("Invalid entry");
	}

	public static int oddOccurenceXOR(int[] arr){
		/* XOR Properties
		 * 1. If you xor an number with it self you get 0
		 * 2. If you xor an number with 0 you get the number itself
		 */
		int res = 0;
		for(int i = 0; i < arr.length;++i){
			res = res ^ arr[i];
		} 
		return res;

	}

	//Find the missing number in an area of 100 integers
	//Algorithmn: Use the sum formula. Subtract all the numbers from sum.
	public static int findMissingNum(int[] arr, int totalCount){
		//1. Sum of the series: Formula: n(n+1)/2 (but only work for one missing number)
		//2. Use Bitset, if the array has more than 1 missing element
		int expectedSum = totalCount * ((totalCount+1)/2);
		int actualSum = 0;
		for(int i : arr) 
			actualSum += i;
		return expectedSum - actualSum;
	}
	
	//Find the duplicate number in array
	public static int findDuplicate(int[] arr){
		Hashtable<Integer,Integer>map = new Hashtable<Integer,Integer>();
		for(int i = 0; i < arr.length;++i){
			if(!map.containsKey(arr[i])) map.put(arr[i],1);
			else map.put(arr[i],map.get(arr[i])+1);
		}
		for(Map.Entry<Integer,Integer>entry: map.entrySet()){
			if(entry.getValue() > 1) return entry.getKey();
		}
		throw new IllegalArgumentException("invalid arr");
	}

	//Find largest and smallest number in unsorted array
	public static void MaxAndMin(int[] arr){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for(int i = 0; i < arr.length;++i){
			if(arr[i] > max) max = arr[i];
			else if(arr[i] < min) min = arr[i]; //corner case with -2147483648 and -2
		}
		System.out.println("max number: " + max);
		System.out.println("min number: " + min);
	}

	
	//Find repeated numbers in an array if it contains a duplicate
	public static void findRepeatedDuplicates(int[] arr){
		Hashtable<Integer,Integer>map = new Hashtable<Integer,Integer>();
		for(int i = 0; i < arr.length;++i){
			if(!map.containsKey(arr[i])) map.put(arr[i],1);
			else map.put(arr[i], map.get(arr[i])+1);
		}

		for(Map.Entry<Integer,Integer>entry: map.entrySet()){
			if(entry.getValue() > 1){
				System.out.println("Duplicated number: " + entry.getKey());
			}
		}
		return;
	}


	//Find intersection of 2 sorted arrays
	public static ArrayList<Integer> intersection(int[] arr, int[] arr2){
		ArrayList<Integer>list = new ArrayList<Integer>();
		for(int i = 0; i < arr.length;++i){
			for(int j = 0; j < arr2.length;++j){
				if(arr[i] == arr2[j]) list.add(arr[j]);
			}
		}
		return list;
	}

	//Find the kth smallest/largest element in unsorted array, really inefficient O(nlogn)
	//For a better approach use priorityqueue
	public static int kthSmallest(int[] arr, int k){
		Arrays.sort(arr);
		for(int i = 0; i < arr.length;++i){
			return arr[k-1];
		}
		return 0;
	}

	//Find First Repeated Element in Array
	public static int firstRepeatedElem(int[] arr){
		List<Integer>list = new ArrayList<Integer>();
		Hashtable<Integer,Integer>map = new Hashtable<Integer,Integer>();
		for(int i = 0; i < arr.length; ++i){
			if(!map.containsKey(arr[i])) map.put(arr[i],1);
			else map.put(arr[i],map.get(arr[i])+1);
		}
		for(Map.Entry<Integer,Integer>entry: map.entrySet()){
			if(entry.getValue() > 1){
				list.add(entry.getKey());
			}
		}
		return list.get(0);
	}

	//Find First NonRepeated Element in Array
	public static int firstNonRepeatedElem(int[] arr){
		List<Integer>list = new ArrayList<Integer>();
		Hashtable<Integer,Integer>map = new Hashtable<Integer,Integer>();
		for(int i = 0; i < arr.length; ++i){
			if(!map.containsKey(arr[i])) map.put(arr[i],1);
			else map.put(arr[i],map.get(arr[i])+1);
		}
		for(Map.Entry<Integer,Integer>entry: map.entrySet()){
			if(entry.getValue() == 1){
				list.add(entry.getKey());
			}
		}
		return list.get(0);
	}

	//Find top two numbers in array
	public static ArrayList<Integer> topTwo(int[] arr){
		ArrayList<Integer>list = new ArrayList<Integer>();
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
		for(int i : arr){
			if(arr[i] > max1){
				max2 = max1;
				max1 = arr[i];
			} else if(arr[i] > max2)
				max2 = arr[i];
		}
		list.add(max1);
		list.add(max2);
		return list;
	}

	//Check if array has a duplicate
	public static boolean hasDuplicate(int[] arr){
		Set<Integer>set = new HashSet<Integer>();
		if(arr.length == 1) return true;
		for(int i = 0; i < arr.length;++i){
			if(set.contains(arr[i])) return true;
			set.add(arr[i]);
		}
		return false;
	}
	//Remove duplicate (IN PLACE) from Sorted Array, return the new length of array
	public static int removeDuplicate(int[] nums){
		if(nums.length < 2) return nums.length;

		int indexBefore = 1;
		for(int i = 0; i < nums.length-1;++i){
			if(nums[i] == nums[i+1]) continue;
			else {
				nums[indexBefore] = nums[i+1];
				indexBefore++;
			}
		}
		return indexBefore;
	}

	//Given an array and a value, remove all instances of that value in place and return the new length.
	public static int removeElement(int[] nums, int val){
		int indexChange = 0;
		for(int i = 0; i < nums.length;++i){
			if(nums[i] != val) nums[indexChange++] = nums[i];
		}
		return indexChange;
	}

	//Say you have an array for which the ith element is the price of a given stock on day i.
	//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
	//design an algorithm to find the maximum profit.
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        //pattern is to buy the smallest num, and sell the largest one
        //max profit is subtracting the sell with the buy
        int maxProfit = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length;++i){
            if(prices[i] > buy){
                if((prices[i]-buy) > maxProfit)
                    maxProfit = prices[i] - buy; //only update maxProfit if you get a greater maxProfit
            } else {
                buy = prices[i];
            }
        }
        return maxProfit;
    }

    //Find the second largest element in array
    public static int secondElem(int[] arr){
    	int first = 0, second = 0;

    	if(arr[0] > arr[1]){
    		first = arr[0];
    		second = arr[1];
    	} else {
    		first = arr[1];
    		second = arr[0];
    	}

    	for(int i = 2; i < arr.length;++i){
    		if(arr[i] > first){
    			second = first; //replace first to second
    			first = arr[i];
    		} else if(arr[i] < first && arr[i] > second){ //dont care if arr[i] < second since its second Largest
    			second = arr[i];
    		} 
    	}
    	return second;
    }
   

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                i++;
            } else {
                nums[j] = nums[i];
                i++;
                j++; //j will end where you would have to place zero's at end
            }
        }

        while(j < nums.length){
            nums[j] = 0;
            j++;
        }
    }

  


    public static void main(String[] args){
		int[] arr1 = {1, 1, 2,2,3}; 
		int[] arr = {2147483647, 40, 2147483647};

		int missing = findMissingNum(arr, 5);
		//System.out.printf("Missing number in array %s is %d %n", 
                           //Arrays.toString(arr), missing);

		int[] res = {9459, 9575, 5692, 1305, 1942, 9012};
		System.out.println(secondElem(res));

	}
 











}