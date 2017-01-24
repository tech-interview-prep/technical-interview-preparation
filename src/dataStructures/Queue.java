package dataStructures;

import java.util.*;

class Queue<E> {

    private class Element<E>{
        // The data value of the element
        private E data;
        // The next element in the queue
        private Element<E> next;

        Element(E data) {
            this.data = data;
            this.next = null;
        }
    }

    // The first element in the queue
    private Element<E> front;
    // The last element in the queue
    private Element<E> back;

    /** Create an empty queue **/
    public Queue() {
        this.front = null;
        this.back = null;
    }

    /** @return true if the queue is empty, false if it is not.
    **/
    public boolean isEmpty() {
        return front == null || back == null;
    }

    /**
        Enqueues a value into the queue.
        @param value The data to be enqueued.
     **/
    public void enqueue(E value) {
        // Create new element
        Element<E> newElement = new Element<E>(value);

        // If the queue is empty
        if (isEmpty()) {
            this.front = newElement;
        }
        else { // Queue is not empty
               // Link the old last element to the new last element
            this.back.next = newElement;
        }

        // Set new back element regardless of whether or not queue is empty
        this.back = newElement;
    }

    /**
        Dequeues the queue's first element.
        @return the data associated with the queue's dequeued element.
        @throws NoSuchElementException if the queue contains no elements.
     **/
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Element<E> head = front;
        this.front = front.next;

        return head.data;
    }

    /**
        'View' the element at the front of the queue.
        @return the data associated with the queue's first element.
        @throws NoSuchElementException if the queue contains no elements.
     **/
    public E peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return front.data;
    }

    /**
        'View' the element at the tail of the queue.
        @return the data associated with the queue's first element.
        @throws NoSuchElementException if the queue contains no elements.
     **/
    public E peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return back.data;
    }
}
