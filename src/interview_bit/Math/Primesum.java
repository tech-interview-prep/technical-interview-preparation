package interview_bit.math;

import java.util.*;

/**
 * Created by priyavivek on 10/18/15.
 * Problem statement
 *
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

 NOTE A solution will always exist. read Goldbach’s conjecture

 Example:


 Input : 4
 Output: 2 + 2 = 4

 If there are more than one solutions possible, return the lexicographically smaller solution.

 If [a, b] is one solution with a <= b,
 and [c,d] is another solution with c <= d, then

 [a, b] < [c, d]

 If a < c OR a==c AND b < d.
 *
 */
public class Primesum {

    public ArrayList<Integer> primesum(int a) {
        ArrayList<ArrayList<Integer>> allPrimeSums = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> temp;
        for(int i=2;i<=a;i++){
            temp = new ArrayList<Integer>();
            if(isPrime(i) && isPrime(a-i)){
                temp.add(Math.min(i,a-i));
                temp.add(Math.max(i,a-i));
                allPrimeSums.add(temp);
            }
        }

        int x,y;

        x=allPrimeSums.get(0).get(0);
        y=allPrimeSums.get(0).get(1);

        if(allPrimeSums.size() > 1){
            for(int i=0;i<allPrimeSums.size();i++){
                if(allPrimeSums.get(i).get(0) < x && allPrimeSums.get(i).get(1) <y){
                    x = allPrimeSums.get(i).get(0);
                    y = allPrimeSums.get(i).get(1);
                }
            }

            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(x);
            result.add(y);
            return result;

        }else{
            return allPrimeSums.get(0);
        }



    }

    public static boolean isPrime(int x){
        if(x <= 1) {
            return false;
        }else if(x <= 3){
            return true;
        }else if( (x%2 == 0) || (x%3 == 0)){
            return false;
        }

        int i=5;

        while(i*i <= x){
            if(x%i == 0 || x%(i + 2) == 0) {
                return false;
            }
            i = i + 6;

        }

        return true;

    }


    public static void main(String[] args){
        int a = 88;
        Primesum ps = new Primesum();
        ArrayList<Integer> result = new ArrayList<Integer>();
        result = ps.primesum(a);

        int m=9;


    }

}
