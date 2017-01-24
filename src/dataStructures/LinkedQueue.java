package dataStructures;

public class LinkedQueue<T>{
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void enqueue(Node<T> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }

    public Object dequeue() {
        if (head == null) return null;
        Node<T> t = head;
        head = head.next;
        size--;
        return t.item;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            builder.append(node.item).append(", ");
            node = node.next;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedQueue<String> lq = new LinkedQueue<>();
        System.out.println("queue is empty ? " + lq.empty());
        lq.enqueue(new Node<String>("Z"));
        lq.enqueue(new Node<String>("T"));
        lq.enqueue(new Node<String>("o"));
        lq.enqueue(new Node<String>("n"));
        lq.enqueue(new Node<String>("g"));
        System.out.println("queue size = " + lq.size());
        System.out.println(lq.toString());
        System.out.println("deque: " + lq.dequeue());
        System.out.println("deque: " + lq.dequeue());
        lq.dequeue();
        lq.dequeue();
        lq.dequeue();
        System.out.println("queue is empty ? " + lq.empty());
        System.out.println("deque: " + lq.dequeue());
    }

}

class Node<E> {
	Node<E> next;
	Object item;
	
	public Node() {
		this.item = null;
		this.next = null;
	}
	
	public Node(E item) {
		this.item = item;
		this.next = null;
	}
}
