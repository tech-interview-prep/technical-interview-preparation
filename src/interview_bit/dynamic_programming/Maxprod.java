package interview_bit.dynamic_programming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by priyavivek on 12/13/15.
 *
 * Problem statement
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 Return an integer corresponding to the maximum product possible.

 Example :

 Input : [2, 3, -2, 4]
 Return : 6

 Possible with [2, 3]
 */
public class Maxprod {
    public int maxProduct(final List<Integer> a) {

        if(a == null) {
            return 0;
        }


        int localMin = a.get(0);
        int localMax = a.get(0);
        int globalMax = a.get(0);

        for(int i=1;i<a.size();i++){
            int temp = localMax;
            localMax = Math.max(Math.max(a.get(i),temp * a.get(i)),a.get(i) * localMin);
            localMin = Math.min(Math.min(a.get(i),temp * a.get(i)),a.get(i) * localMin);
            globalMax = Math.max(globalMax,localMax);
        }

        return globalMax;



    }


    public static void main(String[] args){

        Maxprod m = new Maxprod();
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(-4,0,-5,0));


        int result = m.maxProduct(a);
        System.out.println(result);


    }
}
