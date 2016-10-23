package interviewBit.strings;

/**
 * Created by priyavivek on 10/26/15.
 *
 * Problem statement
 *
 * Please Note:

 Another question which belongs to the category of questions which are intentionally stated vaguely.
 Expectation is that you will ask for correct clarification or you will state your assumptions before you start coding.

 Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ).
 Try not to use standard library string functions for this question.

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
 What should be the return value if the needle is empty?
 What if both haystack and needle are empty?
 For the purpose of this problem, assume that the return value should be -1 in both cases.
 */
public class Strstr {
    public int strStr(final String haystack, final String needle) {
        if(haystack.isEmpty() || needle.isEmpty()){
            return -1;
        }

        int needleLen = needle.length();
        int haystackLen = haystack.length();



        for(int i=0;i<haystackLen;i++){
            if(haystack.charAt(i) == needle.charAt(0) ){
                if(needleLen<2){
                    return i;
                }

                int j = 1;
                boolean found = false;
                while(j<needleLen && i+j < haystackLen){
                    if(haystack.charAt(i + j) != needle.charAt(j)){
                        break;
                    }

                    if(j == needleLen-1){
                        found = true;
                    }

                    j++;
                }

                if(found){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Strstr s = new Strstr();
        int result = s.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba","babaaa");
        System.out.println(result);
    }
}
