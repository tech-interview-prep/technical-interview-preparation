package ctci.Ch01ArraysAndStrings.Q1_05_One_Away;

import utils.ListNode;

public class QuestionA {
    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    public static ListNode clone(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        ListNode temp, current = head;
        ListNode prev = dummy;
        while (current != null) {
            temp = new ListNode(current.data);
            prev.next = temp;
            prev = temp;
            current = current.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        String a = "pse";
        String b = "pale";
        boolean isOneEdit = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);

        ListNode h = ListNode.getSampleList(10);
        ListNode newHead = clone(h);

        ListNode.print(h);
        ListNode.print(newHead);

        System.out.println("long: " + 922337203685477580L);
        System.out.println("int: " + (int)922337203685477580L);
    }

}
