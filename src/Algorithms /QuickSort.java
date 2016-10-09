import java.util.*;
public class QuickSort {
	public static void main(String[] args){
		int[] input = {23,31,1,21,36,72};
		int[] input2 = {11,14,16,12,11,15};
		System.out.println("before: " + Arrays.toString(input));
		quickSort(input);
		System.out.println(Arrays.toString(input));
	}
	public static void quickSort(int[] arr){
		recursiveQuickSort(arr,0,arr.length-1);
	}
	//Recursive quicksort logic
	public static void recursiveQuickSort(int[] arr, int startIndex, int endIndex){
		int index = partition(arr,startIndex,endIndex);

		//Recursive call quicksort with left part of partition array
		if(startIndex < index-1) recursiveQuickSort(arr,startIndex,index-1);

		if(endIndex > index) recursiveQuickSort(arr,index,endIndex);
	}
	//Divides array from pivot. Left side contains elems less than pivot and
	//right side contains elems greater than pivot.
	public static int partition(int[] arr, int left, int right){
		int pivot = arr[left]; //taking first elem as pivot
		while(left <= right){
			//search number which is greater than pivot
			System.out.println("pivot" + pivot);
			while(arr[left] < pivot){
				left++;
			}
			//search number which is less than pivot
			while(arr[right] > pivot){
				right--;
			}
			if(left <= right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				//increment left index, decrement right index
				left++;
				right--;
			}
		}
		return left;
	}
}