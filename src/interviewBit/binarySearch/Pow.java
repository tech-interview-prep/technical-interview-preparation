package interviewBit.binarySearch;

/**
 * Created by priyavivek on 10/22/15.
 *
 * Problem statement
 *
 * Implement pow(x, n) % d.

 In other words, given x, n and d,

 find (xn % d)

 Note that remainders on division cannot be negative.
 In other words, make sure the answer you return is non negative.

 Input : x = 2, n = 3, d = 3
 Output : 2

 2^3 % 3 = 8 % 3 = 2.
 */
public class Pow {
    public int pow(int x, int n, int d) {

        if(n == 0 && d>1){
            return 1;
        }else if(n == 0 && d==1){
            return 0;
        }

        long result = 1;
        long square = x;

        while(n > 0){
            if(n%2 == 1){
                result = (result*square)%d;

            }

            square = (square*square) % d;

            n/=2;


        }

        result = (result + d) % d;

        return (int )result;



    }




    public static void main(String[] args){
        Pow p = new Pow();
        int result = p.pow(79161127,99046373,57263970);
        //int result = p.pow(2,3,3);
        System.out.println(result);


    }
}
