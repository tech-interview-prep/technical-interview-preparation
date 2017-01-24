package dataStructures;

/**
 * Heap in which the parent key is smaller than or equal to (<=) the child keys are called max-heaps
 */
public class MinIntHeap extends AbstractHeap {
    public MinIntHeap() {
        this.items = new int[INITIAL_CAPACITY];
        this.size = 0;
    }

    public MinIntHeap(int capacity) {
        this.items = new int[capacity];
        this.size = 0;
    }

    protected void heapifyUp() {
        int index = this.size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;

        }
    }
}
