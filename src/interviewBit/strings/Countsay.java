package interviewBit.strings;

/**
 * Created by priyavivek on 10/25/15.
 * Problem statement
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...
 1 is read off as one 1 or 11.
 11 is read off as two 1s or 21.

 21 is read off as one 2, then one 1 or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.

 Example:

 if n = 2,
 the sequence is 11.
 */
public class Countsay {
    public String countAndSay(int a) {

        StringBuilder s = new StringBuilder();
        s.append('1');

        int count = 1;
        while(count < a){
            StringBuilder temp = new StringBuilder();

            int i = 0;

            while(i < s.length()){
                char c = s.charAt(i);
                int charCount = 0;
                //Count number of repeating characters
                while(i < s.length()){
                    if(s.charAt(i) == c) {
                        charCount++;
                    }else{
                        break;
                    }
                    i++;
                }
                //Append count and character
                temp.append(String.valueOf(charCount)+c);
            }


            s = temp;
            count++;
        }

        return s.toString();

    }

    public static void main(String[] args){
        Countsay c = new Countsay();
        String result = c.countAndSay(6);
        System.out.println(result);
    }
}
