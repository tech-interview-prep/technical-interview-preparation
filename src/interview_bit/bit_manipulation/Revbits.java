package interview_bit.bit_manipulation;

/**
 * Created by priyavivek on 10/21/15.
 */
public class Revbits {
    public long reverse(long a) {
        long result=0;
        for(int i=0;i<32;i++){
            result+=(a%2)*Math.pow(2,31-i);
            a/=2;

        }

        return result;


    }

    public static void main(String[] args){
        Revbits r = new Revbits();
        long a = 4294967295L;
        long result = r.reverse(a);
        System.out.println(result);


    }

}
