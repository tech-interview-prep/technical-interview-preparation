package leetcode.algorithms;

/**
 * @author bkoteshwarreddy
 */
public class _169MajorityElement {
    /*
    Majority Element
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.

     http://www.geeksforgeeks.org/majority-element/
     */
    public int majorityElement(int[] num) {
        int now = num[0];
        int count = 1;
        for (int i = 1; i < num.length; i++)
            if (now == num[i])
                count++;
            else if (count > 0)
                count--;
            else {
                now = num[i];
                count = 1;
            }
        return now;
    }

    public static void main(String[] args) {
        _169MajorityElement m = new _169MajorityElement();
        int[] a = {1, 2, 3, 3, 3, 3, 10, 2, 2, 2, 2, 2, 2};
        System.out.println(m.majorityElement(a));
    }
}
