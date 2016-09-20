package interview_bit.strings;

/**
 * Created by priyavivek on 10/24/15.
 *
 *
 * Problem Statement
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 Example:

 Given s = "Hello World",

 return 5 as length("World") = 5.

 Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 */
public class Lengthlast {
    public int lengthOfLastWord(final String a) {

        int length = 0;
        int resetFlag=0;

        int count = 0;
        while(count < a.length()){
            if(a.charAt(count) != ' ' && resetFlag==1){
                length=1;
                resetFlag = 0;
                //continue;
            }else if(a.charAt(count) != ' ' && resetFlag==0){
                length++;
            }else{
                resetFlag = 1;
            }

            count++;
        }
        return length;


    }
}
