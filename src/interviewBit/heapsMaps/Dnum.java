package interviewBit.heapsMaps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by priyavivek on 11/22/15.
 *
 * Problem statement
 *
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

 Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

 Note:
 - If K > N, return empty array.

 For example,

 A=[1, 2, 1, 3, 4, 3] and K = 3

 All windows of size K are

 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]

 So, we return an array [2, 3, 3, 2].
 */
public class Dnum {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        int N = A.size();
        ArrayList<Integer> result = new ArrayList<>();

        if(B > N){
            return result;
        }
        HashMap<Integer,Integer> windowMaps = new HashMap<>();

        int flag = 0;
        for(int i=0;i<N-B+1;i++){

            //Use window[i,i+B-1] to update window[i+1,i+B]
            if(i > 0){
                if(windowMaps.get(A.get(i-1)) == 1){
                    windowMaps.remove(A.get(i-1));
                }else {
                    windowMaps.put(A.get(i-1),windowMaps.get(A.get(i-1)) - 1);
                }
            }

            //Just for the first window, read all the elements within the window
            //For all other windows, we need to read just 1 new element
            int j;
            if(flag == 0){
                j = i;
                flag = 1;
            }else {
                j = i + B - 1;
            }

            //If an element already exists, increase its count
            //Else, add it with a count of 1
            while(j<i+B){
                if(windowMaps.containsKey(A.get(j))){
                    windowMaps.put(A.get(j),windowMaps.get(A.get(j)) + 1);
                }else{
                    windowMaps.put(A.get(j),1);
                }

                j++;
            }

            //Calculate the number of unique elements in the current window
            result.add(windowMaps.size());


        }

        return result;


    }

    public static void main(String[] args){
        Dnum d = new Dnum();
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3));
        ArrayList<Integer> result = new ArrayList<>();
        result = d.dNums(A,3);
    }
}
