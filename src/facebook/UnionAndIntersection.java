package facebook;

import java.util.Arrays;

/*
	Given two arrays of sorted integers, merge them keeping in mind that there might be common elements in the
	arrays and that common elements must only appear once in the merged array.

    Union and Intersection of two sorted arrays
    For example, if the input arrays are:
    arr1[] = {1, 3, 4, 5, 7}
    arr2[] = {2, 3, 5, 6}
    Then your program should print Union as {1, 2, 3, 4, 5, 6, 7} and Intersection as {3, 5}.

	Link: http://www.careercup.com/question?id=4713484755402752
	      http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/

*/
public class UnionAndIntersection {
    public int[] union(int arr1[], int arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0;
        int[] newArray = new int[m+n];
        int k = 0;
        while(i < m && j < n) {
            if(arr1[i] < arr2[j]) {
                newArray[k++] = arr1[i++];
            }
            else if(arr2[j] < arr1[i]) {
                newArray[k++] = arr2[j++];
            }
            else {
                newArray[k++] = arr2[j++];
                i++;
            }
        }

        /* add remaining elements of the larger array */
        while(i < m) {
            newArray[k++] = arr1[i++];
        }
        while(j < n) {
            newArray[k++] = arr2[j++];
        }

        return Arrays.copyOfRange(newArray, 0, k);
    }

    public int[] intersection(int arr1[], int arr2[]){
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0;
        int[] newArray = new int[m+n];
        int k = 0;
        while(i < m && j < n) {
            if(arr1[i] < arr2[j]) {
               i++;
            }
            else if(arr2[j] < arr1[i]) {
                j++;
            }
            else {
                newArray[k++] = arr2[j++];
                i++;
            }
        }

        return Arrays.copyOfRange(newArray, 0, k);
    }
}
