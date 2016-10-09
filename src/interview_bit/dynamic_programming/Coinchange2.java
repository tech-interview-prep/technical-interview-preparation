package interview_bit.dynamic_programming;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by priyavivek on 12/12/15.
 *
 * Problem statement
 *
 * You are given a set of coins S. In how many ways can you make sum N assuming you have infinite amount of each coin in the set.

 Note : Coins in set S will be unique. Expected space complexity of this problem is O(N).

 Example :

 Input :
 S = [1, 2, 3]
 N = 4

 Return : 4

 Explanation : The 4 possible ways are
 {1, 1, 1, 1}
 {1, 1, 2}
 {2, 2}
 {1, 3}
 Note that the answer can overflow. So, give us the answer % 1000007
 */
public class Coinchange2 {
    public int coinchange2(ArrayList<Integer> a, int b) {

        //return numWays(a,a.size()-1,b);

        //Bottom-up method to compute number of ways to achieve a required sum

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i=0;i<b+1;i++){
            result.add(0);
        }

        result.set(0,1);


        for(int i=0;i<a.size();i++){

            for(int j = a.get(i);j<=b;j++){
                int valToInsert = (result.get(j) + result.get(j-a.get(i)))%1000007;
                result.set(j,valToInsert);

            }
        }

        return result.get(b);
    }


    /*public int numWays(ArrayList<Integer> a,int m,int N){
        if(N == 0 && m>=0){
            return 1;
        }

        if(N < 0){
            return 0;
        }

        if(N > 0 && m < 0){
            return 0;
        }



        return numWays(a,m,N - a.get(m)) + numWays(a,m-1,N);
    }*/

    public static void main(String[] args){

        Coinchange2 c = new Coinchange2();
        ArrayList<Integer> ip = new ArrayList<Integer>(Arrays.asList(18, 24, 23, 10, 16, 19, 2, 9, 5, 12, 17, 3, 28, 29, 4, 13, 15, 8 ));
        int result = c.coinchange2(ip,458);
        System.out.println("Number of ways : " +  result);


    }
}
