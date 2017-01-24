package dataStructures;

/**
 * Heap in which the parent key is greater than or equal to (>=) the child keys are called max-heaps
 */
public class MaxIntHeap extends AbstractHeap {
    public MaxIntHeap() {
        this.items = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public MaxIntHeap(int capacity) {
        this.items = new int[capacity];
        this.size = 0;
    }

    protected void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int biggerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                biggerChildIndex = getRightChildIndex(index);
            }

            if (items[index] > items[biggerChildIndex]) {
                break;
            } else {
                swap(index, biggerChildIndex);
            }
            index = biggerChildIndex;
        }
    }
}
