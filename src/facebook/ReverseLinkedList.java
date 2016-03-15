package facebook;

/* 	
	Reverse a Linked-list.

	Link: http://www.mytechinterviews.com/reverse-a-linked-list

*/	
public class ReverseLinkedList {
    //    ListNode reversedHead = reverse(head, NULL);

    ListNode reverse(ListNode ptr , ListNode previous) {
        ListNode temp;
        if(ptr.next == null) {
            ptr.next = previous;
            return ptr;
        } else {
            temp = reverse(ptr.next, ptr);
            ptr.next = previous;
            return temp;
        }
    }

    ListNode reverse(ListNode ptr ) {
        ListNode temp;
        ListNode previous = null;
        while(ptr != null) {
            temp = ptr.next;
            ptr.next = previous;
            previous = ptr;
            ptr = temp;
        }
        return previous;
    }
}
