package interview_bit.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Problem statement
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.

 For example:

 Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

 Note: The result may be very large, so you need to return a string instead of an integer.
 *
 *
 */
public class Largestnum {
    public String largestNumber(final List<Integer> a) {

        if (a.size() == 1) {
            return String.valueOf(a.get(0));
        }

        String[] aToString = new String[a.size()];
        int count = 0;

        //Convert to String array
        for (Integer i : a) {
            aToString[count] = String.valueOf(i);
            count++;
        }

        //Sort the strings
        Arrays.sort(aToString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return -s1.compareTo(s2);
            }
        });


        StringBuffer sb = new StringBuffer();
        for (String s : aToString) {
            sb.append(s);
        }

        String result = sb.toString();

        //Account for the case where input could be a list of 0's.
        if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }


    }

    public static void main(String[] args) {
        String s1 = "3";
        String s2 = "34";
        String o1 = s1 + s2;
        String o2 = s2 + s1;

        System.out.println("334 vs 343" + o2.compareTo(o1));



    }

}
