package interviewBit.hashing;
import java.util.HashMap;

/**
 * Created by priyavivek on 11/18/15.
 *
 * Problem statement
 *
 * For Given Number N find if its COLORFUL number or not

 Return 0/1

 COLORFUL number:

 A number can be broken into different sub-sequence parts.
 Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 And this number is a COLORFUL number, since product of every digit of a sub-sequence are different
 Example:

 N = 23
 2 3 23
 2 -> 2
 3 -> 3
 23 -> 6
 this number is a COLORFUL number since product of every digit of a sub-sequence are different.

 Output : 1
 */
public class Colorful {
    public int colorful(int a) {
        HashMap<Integer,Integer> products = new HashMap<>();
        //Convert number to string. Makes computations easier
        String s = String.valueOf(a);

        //Test all possible substrings, starting from length = 1 to length = s.length() i.e the entire string
        for(int i=1;i<=s.length();i++){
            for(int j=0;j <= s.length()-i;j++){
                String subString = new String();
                subString = s.substring(j,j+i);
                int currProduct = getProducts(subString);
                //Check if number is colorful
                if(products.containsKey(currProduct)){
                    return 0;
                }else {
                    products.put(currProduct,1);
                }
            }

        }

        return 1;


    }

    //Compute the product of digits in a number (represented as a string)
    public int getProducts(String s){
        int result = 1;
        for(int i=0;i<s.length();i++){
            result*=Character.getNumericValue(s.charAt(i));
        }

        return result;
    }

    public static void main(String[] args){

        Colorful c = new Colorful();
        int result = c.colorful(263);
        System.out.println(result);
    }
}
