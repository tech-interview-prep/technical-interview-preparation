package dataStructures;

public class ArrayQueue<T>{
    public static final int INIT_CAPACITY = 1024;

    private int firstIdx;
    private int lastIdx;
    private T[] array;

    public ArrayQueue() {
        this(INIT_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        firstIdx = 0;
        lastIdx = 0;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return lastIdx - firstIdx;
    }

    public boolean empty() {
        return size() == 0;
    }

    public boolean enqueue(T value) {
        if (array.length - size() <= 1) return false;
        array[lastIdx % array.length] = value;
        lastIdx++;
        return true;
    }

    public T dequeue() {
        T t = array[firstIdx % array.length];
        array[firstIdx % array.length] = null;
        firstIdx++;

        if (size() <= 0) {
            firstIdx = 0;
            lastIdx = 0;
        }
        return t;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = firstIdx; i < lastIdx; i++) {
            builder.append(array[i % array.length]).append(", ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayQueue<String> aq = new ArrayQueue<>();
        System.out.println("queue is empty ? " + aq.empty());
        aq.enqueue("Z");
        aq.enqueue("T");
        aq.enqueue("o");
        aq.enqueue("n");
        aq.enqueue("g");
        System.out.println("queue size = " + aq.size());
        System.out.println(aq.toString());
        System.out.println("deque: " + aq.dequeue());
        System.out.println("deque: " + aq.dequeue());
        aq.dequeue();
        aq.dequeue();
        aq.dequeue();
        System.out.println("queue is empty ? " + aq.empty());
        System.out.println("deque: " + aq.dequeue());
    }

}
