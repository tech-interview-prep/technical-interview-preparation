package interviewBit.backtracking;

import java.util.ArrayList;

/**
 * Created by priyavivek on 11/13/15.
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 There might be multiple gray code sequences possible for a given n.
 Return any such sequence.
 *
 */
public class Graycode {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> grayCode(int a) {

        ArrayList<String> ip = new ArrayList<String>();
        ip.add("0");
        ip.add("1");
        getGrayCode(ip,1,a);
        return result;

    }

    public void getGrayCode(ArrayList<String> prev,int n,int N){

        if(n == N){
            for(int i=0;i<prev.size();i++){
                result.add(getStringVal(prev.get(i)));
            }

            return;
        }

        //G(n+1) = 0G(n) + 1R(n) i.e, gray code of n+1 bits is 0 prefixed with G(n) along with 1 prefixed the reverse of G(n) or R(n)
        ArrayList<String> curr = new ArrayList<>();
        for(int i=0;i<prev.size();i++){
            curr.add("0" + prev.get(i));
        }

        for(int i=prev.size()-1;i>=0;i--){
            curr.add("1" + prev.get(i));
        }


        //Start from n=1 and recursively build the gray code until n=N
        getGrayCode(curr,n+1,N);


    }

    //Function to convert binary strings to nums
    public int getStringVal(String s){
        int strLen = s.length();
        int val = 0;
        for(int i=0;i<strLen;i++){
            val+=Math.pow(2,strLen-1-i)*Character.getNumericValue(s.charAt(i));

        }

        return val;
    }

    public static void main(String[] args){
        Graycode g = new Graycode();
        ArrayList<Integer> result = new ArrayList<>();
        result = g.grayCode(3);

        int m = 9;


    }
}
