package interviewBit.twoPointers;
import java.util.ArrayList;

/**
 * Created by priyavivek on 10/27/15.
 *
 * Problem statement
 *
 * Given an array with n objects colored red, white or blue,
 sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: Using library sort function is not allowed.

 Example :

 Input : [0 1 2 0 1 2]
 Modify array so that it becomes : [0 0 1 1 2 2]
 *
 */
public class Sortcolor {
    public void sortColors(ArrayList<Integer> a) {
        int redCount = 0, blueCount = 0, whiteCount = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == 0) {
                redCount++;
            } else if (a.get(i) == 1) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }
        int count = 0;
        while (count < a.size()) {
            for (int j = 0; j < redCount; j++) {
                a.set(count, 0);
                count++;
            }

            for (int j = 0; j < whiteCount; j++) {
                a.set(count, 1);
                count++;
            }

            for (int j = 0; j < blueCount; j++) {
                a.set(count, 2);
                count++;
            }
        }
    }

}
