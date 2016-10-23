package interviewBit.hashing;

import java.util.HashMap;

/**
 * Created by priyavivek on 11/18/15.
 *
 * Problem statement
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 Example :

 Given numerator = 1, denominator = 2, return "0.5"
 Given numerator = 2, denominator = 1, return "2"
 Given numerator = 2, denominator = 3, return "0.(6)"
 */
public class Fraction {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign;
        if((numerator <0 && denominator >0) || (numerator>0 && denominator < 0)){
            sign = "-";
        }else {
            sign="";
        }

        //Calculate the absolute values of the numerator and denominator
        long num = Math.abs(numerator*-1L);
        long den = Math.abs(denominator*-1L);

        //Calculate the integer part of the fraction
        long intPart = num/den;


        long remainder = num % den;
        if(remainder == 0){
            return sign + String.valueOf(intPart);
        }

        HashMap<Long,Integer> remainderMap = new HashMap<>();
        StringBuilder fractionPart = new StringBuilder();

        //i is the index of the fractional part
        int i = 0;

        /*Calculate the fractional part
        To calculate the fractional part
        remainder = remainder * 10
        Append remainder/den to fractional part
        remainder = remainder % den*/

        while(remainder != 0){
            remainder*=10;
            //If a remainder that has previously been seen, is encountered we have a recurring fractional part
            if(remainderMap.containsKey(remainder)){
                fractionPart.append(')');
                int startRepeatInd = remainderMap.get(remainder);
                fractionPart.insert(startRepeatInd, '(');
                break;
            }else {
                remainderMap.put(remainder, i);
            }
            fractionPart.append((int )(remainder/den));
            remainder = remainder % den;
            i++;
        }

        //Return the string representation of the fraction
        return sign + String.valueOf(intPart) + '.' + fractionPart.toString();



    }

    public static void main(String[] args){

        Fraction f = new Fraction();
        String result = f.fractionToDecimal(-1,-2147483648);
        System.out.println(result);


    }
}
