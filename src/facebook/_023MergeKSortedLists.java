/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Link: http://n00tc0d3r.blogspot.com/2013/04/merge-k-sorted-lists.html
 * Link: http://n00tc0d3r.blogspot.com/2013/04/merge-sorted-listsarrays-i.html
 * Link: https://github.com/yadongwen/leetcode/blob/master/Merge%20k%20Sorted%20Lists.java
 */

package facebook;

import java.util.ArrayList;

import utils.ListNode;
import utils.Utils;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * @author bkoteshwarreddy
 */
public class _023MergeKSortedLists {
  public static void main(String[] args) {
    Solution_MergeKSortedLists sol = new Solution_MergeKSortedLists();
    
    ArrayList<ListNode> lists = new ArrayList<ListNode>();
    for(int i=0;i<10;i++) {
      for(int j=0;j<20;j++) {
        
      }
    }
    
//    Utils.printIntListln(sol.mergeKLists(lists));
  }
}

class Solution_MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
       int last = lists.size() - 1;
       if (last < 0) return null;

       while (last > 0) {
         int cur = 0;
         while (cur < last) {
           lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(last--)));
         }
       }

       return lists.get(0);
     }

  /*
    Since this is an in-place merging, it takes O(m+n) time and O(1) space.
   */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(0);
      ListNode cur = head;

      while (l1 != null || l2 != null) {
        if (l2 == null || (l1 != null && l1.data <= l2.data)) {
          cur.next = l1;
          l1 = l1.next;
        } else {
          cur.next = l2;
          l2 = l2.next;
        }
        cur = cur.next;
      }

      return head.next;
    }

  public ListNode mergeKLists2(ArrayList<ListNode> lists) {
    if (lists.isEmpty()) {
      return null;
    }

    while (lists.size() > 1) {
      for (int i = 0, l = lists.size(); i < (l >> 1); i++) {
        lists.set(i, mergeLists(lists.get(i), lists.get(l - i - 1)));
        lists.remove(l - i - 1);
      }
    }

    return lists.get(0);
  }

  private static ListNode mergeLists(ListNode l1, ListNode l2) {
    ListNode dummyNode = new ListNode(0), insertNode = dummyNode;

    while (l1 != null && l2 != null) {
      if (l1.data < l2.data) {
        insertNode.next = l1;
        l1 = l1.next;
      } else {
        insertNode.next = l2;
        l2 = l2.next;
      }
      insertNode = insertNode.next;
    }

    if (l1 != null) {
      insertNode.next = l1;
    } else {
      insertNode.next = l2;
    }

    return dummyNode.next;
  }
}
