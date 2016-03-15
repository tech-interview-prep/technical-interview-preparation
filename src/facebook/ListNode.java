package facebook;

public class ListNode {
    int data;
    ListNode next;

    ListNode() {
        this.data = 0;
        this.next = null;
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
