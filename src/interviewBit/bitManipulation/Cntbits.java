package interviewBit.bitManipulation;
import java.util.ArrayList;

/**
 * Created by priyavivek on 10/21/15.
 *
 * Problem statement
 *
 *
 * We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

 You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

 For example,

 A=[1, 3, 5]

 We return

 f(1, 1) + f(1, 3) + f(1, 5) +
 f(3, 1) + f(3, 3) + f(3, 5) +
 f(5, 1) + f(5, 3) + f(5, 5) =

 0 + 1 + 1 +
 1 + 0 + 2 +
 1 + 2 + 0 = 8
 */
public class Cntbits {
    private static final long  MODVAL = 1000000007;

    public int cntBits(ArrayList<Integer> A) {

        long numZeros, numOnes;
        long result = 0;

        for(int i=0;i<31;i++){
            numZeros=0;
            numOnes=0;
            for(int j=0;j<A.size();j++){
                if(A.get(j)%2 == 0){
                    numZeros++;
                }else{
                    numOnes++;
                }
                A.set(j,A.get(j)/2);
            }

            result = (result + (2*numZeros*numOnes)) % MODVAL;
        }

        return (int)result;

    }


    public static void main(String[] args){
        Cntbits c = new Cntbits();
        ArrayList<Integer> ip = new ArrayList<Integer>();
        ip.add(1);
        ip.add(3);
        ip.add(5);
        int result;

        result = c.cntBits(ip);
        System.out.println(result);



    }
}
