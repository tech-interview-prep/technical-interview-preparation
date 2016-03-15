package leetcode_online_judge;

import java.util.Random;

public class ListNode {
    
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static void print(ListNode root) {
        ListNode node = root;
        while (node != null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode getSampleList(int length) {
        return getSampleList(1, length);
    }

    public static ListNode getSampleList(int start, int length) {
        if (length == 0) {
            return null;
        }

        ListNode root = new ListNode(start);
        ListNode pre = root;
        for (int i = 1; i < length; i++) {
            pre.next = new ListNode(start + i);
            pre = pre.next;
        }

        return root;
    }

    public static ListNode getSampleRandomList(int length) {
        if (length == 0) {
            return null;
        }

        Random r = new Random();
        ListNode root = new ListNode(r.nextInt(10 * length));
        ListNode pre = root;
        for (int i = 1; i < length; i++) {
            pre.next = new ListNode(r.nextInt(10 * length));
            pre = pre.next;
        }

        return root;
    }
}
