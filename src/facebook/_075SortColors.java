/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

Link: http://joycelearning.blogspot.com/2013/10/leetcode-sort-colors.html
Link: http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
*/

package facebook;

import utils.Utils;

/**
 * https://leetcode.com/problems/sort-colors/
 * @author bkoteshwarreddy
 */

public class _075SortColors {
    public static void main(String[] args) {
      Solution_SortColors sol = new Solution_SortColors();

      int[] A = new int[]{1, 1, 0, 1, 2, 0, 1, 2, 0, 0, 1};
      sol.sortColors(A);
      Utils.printArrayln(A);
    }
}

class Solution_SortColors {
    public void sortColors(int[] A) {
        for(int index = 0, start = 0, end = A.length - 1; index <= end;) {
            if (A[index] == 0) {
                A[start++] = 0;
                if (index >= start) {
                    A[index] = 1;
                }
                index++;
            } else if (A[index] == 2){
                A[index] = A[end];
                A[end--] = 2;
            } else {
                index++;
            }
        }
    }

    public void sortColors2(int[] A) {
        if(A == null || A.length == 0 || A.length == 1)  return;

        // one-pass solution
        int red = 0, blue = A.length - 1, tmp, i = 0;
        // stop looping when current >= blue
        while(i <= blue) {
            // if color is red, move to the front
            if(A[i] == 0) {
                // when cur > red, switch
                if(i > red) {
                    tmp = A[red];
                    A[red] = A[i];
                    A[i] = tmp;
                    red++;
                }
                // when cur <= red, no need to switch, just move both to next
                else {
                    i++;
                    red++;
                }
            }
            // if color is blue, move to the end
            else if(A[i] == 2) {
                // when cur < blue, switch
                if(i < blue) {
                    tmp = A[blue];
                    A[blue] = A[i];
                    A[i] = tmp;
                    blue--;
                }
                // when cur >= blue, end the loop
                else {
                    return;
                }
            }
            // if color is white, skip
            else {
                i++;
            }
        }
    }
}
