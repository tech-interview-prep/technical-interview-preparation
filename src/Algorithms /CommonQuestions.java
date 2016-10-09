public class CommonQuestions {
	public static void main(String[] args){
		//System.out.println(computePower(5,3));
		String[] names = {
		    "MacLaren’s Pub", //0
		    "Monk’s Cafe", // 1
		    "Paddy’s Pub", //2
		    "Taco Town", //3
		    "Xylophone Cafe", //4
		    "Abdul’s Orange Chicken Emporium", //5
		    "Bob’s Burgers", //6
		    "Central Perk", //7
		    "Da Situation", //8
		    "Krusty Krab",//9
		    "Los Pollos Hermanos", //10
		};
		System.out.println(findRotationPoint(names));
	}


	//Check if its prime, any number divisible by 1 or itself
	public static boolean isPrime(int n){
		if(n < 2) return false;
		int sqrt = (int)Math.sqrt(n)+1;
		
		for(int i = 2; i < sqrt;++i){
			if(n % i == 0) return false; //number is perfectly divisible - no prime
		}
		return true; 
	}
	//Reverse Integer with library method
	public static int reverseInteger(int num){
		if(num == 0 || num == Integer.MIN_VALUE) return 0;

		boolean isNegative = num < 0 ? true : false;

		if(isNegative) num = -1 * num;

		long reverse = 0;
		int lastDigit = 0;

		while(num != 0){
			lastDigit = num % 10; //gives you last digit 
			reverse = reverse * 10 + lastDigit; //pattern is reverse * 10
			num = num / 10; //get rid of last number
		}

		if(isNegative != true){
			return reverse > Integer.MAX_VALUE ? 0 : (int)reverse;
		} else {
			reverse = reverse * -1;
			return reverse < Integer.MIN_VALUE ? 0 : (int)reverse;
		}

	}
	//Power of Two
	public static boolean powerTwo(int n){
		while(n % 2 == 0 && n > 1){
			n = n / 2;
		}
		return n == 1;
	}
	//Power of Three
	public static boolean powerThree(int n){
		while(n % 3 == 0 && n > 1){
			n = n / 3;
		}
		return n == 1;
	}
	//Fibonacci 
	public static void fuzzbuzz(int num){
		if(num % 5 == 0){
			if(num % 3 == 0){
				System.out.println("FuzzBuzz");
			}
		}
		else if(num % 3 == 0) System.out.println("Fuzz");
		else if(num % 5 == 0) System.out.println("Buzz");
	}
	//Compute a^b
	public static int computePower(int a, int b){
		int result = 1;
		for(int i = 0; i < b; ++i){
			result *= a;
		}
		return result;
	}
	//Write a function for finding the index of the rotationPoint
	public static int findRotationPoint(String[] names){
	    int low = 0;
	    int high = names.length - 1;
	    int mid = (low + high)/2;
	    
	    while(low < high){
	      if(names[mid].compareTo(names[low]) < 0){
	        low = mid; //deleting left part of array up to mid
	      } else {
	        high = mid; //deleting right part of array up to mid
	      }  
	      mid = (low + high)/2; //reset to next mid
	    }
	    return mid; //returns 5   
  }

	// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	// Find the minimum element.

  	public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high)/2;
        

        while(low <= high){
            if(nums[mid] > nums[high]){
                low = mid + 1;
            } else if(nums[mid] < nums[low]){
                high = mid;
            } else {
                break;
            }
            mid = (low + high)/2;
        }
        return nums[low];
    }

 




}