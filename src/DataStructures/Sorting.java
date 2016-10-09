public class Sorting{

	public static void main(String[] args){
		int[] arr = {1,8,11,-1,0,3};
		//insertionSort(arr);
		mergeSort(arr);
		printArray(arr);
		
	}

	//////////INSERTION SORT////////
	/*
	 * Time Complexity - O(n^2), since you go through 2 for loops
	 * Best case - Array is already sorted, O(n)
	 */
	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++){ //start with 1 since we already know arr[0] is already sorted
			insert(arr, i);
		}
	}

	private static void insert(int[] arr, int index){
		int value = arr[index]; //value of the element to be inserted

		//iterate in the loop for all elements below the currentIndex
		int reverseIndex = index;
		for(int i = index - 1; i >= 0; --i){
			if(arr[i] >= value){
				arr[i+1] = arr[i]; //moving along array
				reverseIndex = i; //keep track of where to place index for value
			} else break;
		}
		arr[reverseIndex] = value;
	}

	//////////QUICKSORT SORT////////



	//////////MERGE SORT////////
	/*
	 * A divide and conquer algorithm with a recursive merge. 
	 * Time Complexity - O(nlogn) because the number of recursive call in merge sort is based upon
	 * the total depth of the tree which is log(n). When we call the recursive merge, it is a total
	 * on n operations.
	 * Best case - O(nlogn)
	 * Space - O(n) since it requires additional memory check to allocate a new merge result
	 */
	public static void mergeSort(int[] arr){
		int size = arr.length;
		int mid = size / 2;

		if(size < 2) return; //corner case or else you get forever loop
		
		//Calculate size for left and right for array building
		int leftSize = mid;
		int rightSize = size - mid;

		int[] left = new int[leftSize];
		int[] right = new int[rightSize];

		//copy array contents into left
		for(int i = 0; i < mid;++i){
			left[i] = arr[i];
		}

		//copy array contents into right 
		for(int j = mid; j < size; ++j){
			right[j-mid] = arr[j];
		}

		//do it again
		mergeSort(left);
		mergeSort(right);

		merge(left,right,arr);
	}

	public static void merge(int[] left, int[] right, int[] res){
		int i = 0;
		int j = 0;
		int k = 0;
		
		while(i < left.length && j < right.length){ //compare array index i by array index j
			//i to move iteration, k is to increase size for next iteration
			if(left[i] <= right[j]) res[k++] = left[i++];
			
			else res[k++] = right[j++];	
		}

		//take care of left out arrays from either left or right side
		while(i < left.length) res[k++] = left[i++];
		
		while(j < right.length) res[k++] = right[j++];
	}

	private static void printArray(int[] arr){
		for(int i: arr) System.out.print(i + " ");
	}

}