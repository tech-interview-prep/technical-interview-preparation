package interviewBit.binarySearch;

/**
 * Created by priyavivek on 10/20/15.
 *
 *
 * Problem statement
 *
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 If x is not a perfect square, return floor(sqrt(x))

 Example :

 Input : 11
 Output : 3
 DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY
 */
public class Sqrt {
    public int sqrt(int a) {

        if(a == 0){
            return 0;
        }


        return sqrt(1,a,a);


        //O(sqrt(N)) approach
        /*int i=1;
        while(i*i <=a){
            if(i*i == a){
                return i;
            }else if(i >= Integer.MAX_VALUE/i ){
                return i-1;
            }
            i++;
        }

        return i-1;*/


    }

    public int sqrt(int lo,int hi,int N){
        if(lo > hi){
            return -1;
        }else{

            int mid = (lo+hi)/2;
            if(mid == N/mid){
                return mid;
            }else if((mid < N/mid) && (mid+1) > N/(mid+1)){
                return mid;
            }
            else if(mid < N/mid){
                return sqrt(mid+1,hi,N);
            }else if(mid > N/mid){
                return sqrt(lo,mid-1,N);
            }else{
                return mid;
            }



        }


    }



    public static void main(String[] args){

        Sqrt s = new Sqrt();
        //933571041
        int result = s.sqrt(2147483647);
        System.out.println(result);


    }


}
