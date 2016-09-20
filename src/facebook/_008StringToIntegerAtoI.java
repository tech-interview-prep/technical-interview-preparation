/*
    convert string to int

    http://www.geeksforgeeks.org/write-your-own-atoi/
    http://www.geeksforgeeks.org/implement-itoa/
*/

package facebook;

public class _008StringToIntegerAtoI {
  public static void main(String[] args) {

  }
}

class Solution_AtoI {
    public static int atoi(String s){
        char[] chars = s.toCharArray();

        int current = 0;
        char sign = '+';

        //discard blanks
        while(current<s.length() && chars[current] ==' ' ){
            current++;
        }
        //reach the end, return 0
        if(current==s.length())
            return 0;

        char c = chars[current];
        //check the first non-zero char
        if(c!='-' && c!='+' && (c<=48 || c>57))
            return 0;

        if(c=='-')
            sign = '-';

        if(c=='-' || c=='+')
            current++;

        //reach the end or non-1-9, return 0
        if(current>=s.length() || chars[current]<=48 || chars[current]>57)
            return 0;

        long result = 0;
        while(current<s.length() && chars[current]>=48 && chars[current]<=57){
            result = result * 10 + chars[current]-48;
            if(result>=Integer.MAX_VALUE && sign =='+')
                return Integer.MAX_VALUE;
            if(result-1>=Integer.MAX_VALUE && sign =='-')
                return Integer.MIN_VALUE;
            current++;
        }

        if(sign=='-')
            result = result * -1;

        return	Long.valueOf(result).intValue();
    }
}
