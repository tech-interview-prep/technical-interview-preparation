package interview_bit.stacks_and_queues;
import java.util.*;

/**
 * Created by priyavivek on 11/7/15.
 *
 * Problem statement
 *
 * Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

 More formally,

 G[i] for an element A[i] = an element A[j] such that
 j is maximum possible AND
 j < i AND
 A[j] < A[i]
 Elements for which no smaller element exist, consider next smaller element as -1.

 Example:

 Input : A : [4, 5, 2, 10]
 Return : [-1, 4, -1, 2]

 Example 2:

 Input : A : [3, 2, 1]
 Return : [-1, -1, -1]
 */
public class Nearest {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {

        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();


        for(int i=0;i<arr.size();i++){
            if(s.empty()){
                result.add(-1);

            //For arr[i], if arr[j] > arr[i] for j<i then we don't need to track that element
            }else{
                while(!s.empty() && s.peek() >= arr.get(i)){
                    s.pop();
                }

                if(!s.empty()){
                    result.add(s.peek());
                }else {
                    result.add(-1);
                }
            }

            s.push(arr.get(i));

        }

        return result;


    }

    public static void main(String[] args){

        Nearest n = new Nearest();
        ArrayList<Integer> ip = new ArrayList<Integer>(Arrays.asList(3,2,1));
        ArrayList<Integer> result = new ArrayList<Integer>();

        result = n.prevSmaller(ip);

        int m = 5;

    }
}
