package dataStructures;

public abstract class AbstractHeap {
    protected static final int INITIAL_CAPACITY = 10;
    protected int size = 0;
    protected int[] items;

    protected int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    protected int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    protected int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    protected boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    protected boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    protected boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    protected int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    protected int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    protected int parent(int index) {
        return items[getParentIndex(index)];
    }

    protected void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    protected void ensureExtraCapacity() {
        if (this.size == this.items.length) {
            int[] copy = new int[this.size << 1];
            System.arraycopy(this.items, 0, copy, 0, this.size);
            this.items = copy;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        return this.items[0];
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();

        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    protected abstract void heapifyUp();
    protected abstract void heapifyDown();
}
