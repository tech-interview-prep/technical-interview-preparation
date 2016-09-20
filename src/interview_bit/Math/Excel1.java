package interview_bit.math;

/**
 * Created by priyavivek on 10/18/15.
 *
 * Problem statement
 *
 * Given a column title as appears in an Excel sheet, return its corresponding column number.

 Example:

 A -> 1

 B -> 2

 C -> 3

 ...

 Z -> 26

 AA -> 27

 AB -> 28
 */
public class Excel1 {
    public int titleToNumber(String a) {

        int result=0;
        int base =26;
        int x,y;

        for(int i=a.length()-1;i>=0;i--){
            x = ((int)a.charAt(i) - 64);
            y = (int)Math.pow(base,a.length()-1-i);
            result += x*y ;
        }

        return result;

    }

    public static void main(String[] args){
        String ip = "AB";
        int result;
        Excel1 e = new Excel1();
        result = e.titleToNumber(ip);
        System.out.println(result);



    }
}
