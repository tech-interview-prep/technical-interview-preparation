package dataStructures;

import java.util.*;

public class ResizableArray<E>{
    // Default Initial Capacity
    final private int _initialCapacity = 10;
    // Underlying array
    private Object[] items;
    // Number of elements in it
    private int size;

    public ResizableArray() {
        this.items = new Object[_initialCapacity];
        this.size = 0;
    }

    public ResizableArray(int capacity) {
        this.items = new Object[capacity];
        this.size = 0;
    }

    public void append(E element) {
        ensureExtraCapacity();
        this.items[size] = element;
        this.size++;
    }

    public void ensureExtraCapacity() {
        if (this.size == this.items.length) {
            Object[] copy = new Object[this.size << 1];
            System.arraycopy(this.items, 0, copy, 0, this.size);
            this.items = copy;
        }
    }

    public Object get(int index) {
        checkBounds(index);
        return this.items[index];
    }

    public void set(int index, E value) {
        checkBounds(index);
        this.items[index] = value;
    }

    public void checkBounds(int index) {
        if (index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }

    public void print() {
        System.out.print("[");

        if (this.size > 0) {
            for (int i = 0; i < this.size - 1; i++) {
                System.out.print(this.items[i] + ",");
            }
            System.out.println("]");
        }
    }

    public void print(String name) {
        System.out.print(name + ": ");
        print();
    }
}
