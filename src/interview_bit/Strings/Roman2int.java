package interview_bit.strings;
import java.util.HashMap;

/**
 * Created by priyavivek on 10/25/15.
 *
 * Problem statement
 *
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.

 Read more details about roman numerals at Roman Numeric System

 Example :

 Input : "XIV"
 Return : 14
 Input : "XX"
 Output : 20
 */
public class Roman2int {

    public int romanToInt(String a) {
        HashMap <Character,Integer> romanNumerals = new HashMap<Character,Integer>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V',5);
        romanNumerals.put('X',10);
        romanNumerals.put('L',50);
        romanNumerals.put('C',100);
        romanNumerals.put('D',500);
        romanNumerals.put('M',1000);


        long result = 0;
        int lena = a.length();
        for(int i=lena-1;i>=0;i--){
            char currChar = a.charAt(i);
            if(i != lena-1){
                char prevChar = a.charAt(i+1);
                if(romanNumerals.get(currChar)< romanNumerals.get(prevChar)){
                    result-=romanNumerals.get(currChar);
                }else{
                    result += romanNumerals.get(currChar);
                }

            }else{
                result += romanNumerals.get(currChar);
            }

        }



        return (int)result;
    }

    public static void main(String[] args){
        Roman2int r = new Roman2int();
        int result = r.romanToInt("LXXVII");
        System.out.println(result);
    }
}
