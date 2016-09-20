package interview_bit.two_pointers;
import java.util.*;

/**
 * Created by priyavivek on 10/22/15.
 *
 * Problem statement
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 Return the sum of the three integers.
 You may assume that each input would have exactly one solution.

 Example:
 given array S = {-1 2 1 -4},
 and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 */
public class Threesum {
    public int threeSumClosest(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int len = a.size();
        int result = a.get(0) +  a.get(1) + a.get(len -1);
        if(len == 3){
            return result;
        }
        //Have 2 pointers. One at the lower end and the other at the higher end
        int p1,p2;


        int threeSum = 0;

        for(int i=0;i<len-1;i++){
            p1 = i+1;
            p2 = len-1;

            while(p2 > p1){

                threeSum = a.get(i) + a.get(p1) + a.get(p2);

                if(threeSum == b){
                    return b;

                }else if(threeSum > b){
                    p2--;
                    //threeSum = a.get(i) + a.get(p1) + a.get(p2);


                }else{
                    p1++;
                    //threeSum = a.get(i) + a.get(p1) + a.get(p2);

                }

                if(Math.abs(b - threeSum) < Math.abs(b - result)){
                    result = threeSum;
                }
            }


        }

        return result;



    }

    public static void main(String[] args){
        Threesum t = new Threesum();
        //ArrayList<Integer> ip = new ArrayList<Integer>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3));
        ArrayList<Integer> ip = new ArrayList<Integer>(Arrays.asList(2, 1, -9, -7, -8, 2, -8, 2, 3, -8));
        int result = t.threeSumClosest(ip,-1);
        System.out.println(result);

    }

}
