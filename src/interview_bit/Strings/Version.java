package interview_bit.strings;

/**
 * Created by priyavivek on 10/24/15.
 *
 * Problem statement
 *
 * Compare two version numbers version1 and version2.

 If version1 > version2 return 1,
 If version1 < version2 return -1,
 otherwise return 0.
 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 */
public class Version {
    public int compareVersion(String A, String B) {
        int l1 = A.length();
        int l2 = B.length();
        int l = Math.min(l1,l2);
        for (int i = 0; i < l; i++) {
            if (A.charAt(i) == '.' && B.charAt(i) == '.') {
                continue;
            }
            if (A.charAt(i) == '.' && B.charAt(i) != '.') {
                return -1;
            }
            if (A.charAt(i) != '.' && B.charAt(i) == '.') {
                return 1;
            }
            if (A.charAt(i) > B.charAt(i)) {
                return 1;
            }
            if (B.charAt(i) > A.charAt(i)) {
                return -1;
            }
        }
        if (l1 > l2) {
            return 1;
        }
        if (l2 > l1) {
            return -1;
        }
        return 0;
    }


    public static void main(String[] args){
        Version v = new Version();
        int result = v.compareVersion("1.0","1");
        System.out.println(result);
    }
}
