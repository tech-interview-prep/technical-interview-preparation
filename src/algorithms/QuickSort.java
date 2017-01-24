package algorithms;

/**
 * Quick sort an integer arrays
 *
 * Tags: Sort
 */
class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] input = { 1, 4, 2, 8, 5};
        q.sort(input, 0, input.length - 1);
        for (int n : input) System.out.print(n + ",");
    }

    /**
     * Partition the array according to middle index
     * Sort left half, from left to index - 1
     * Sort right half, from index to right
     */
    public void sort(int[] input, int left, int right) {
        int index = partition(input, left, right);
        if (left < index - 1) sort(input, left, index - 1);
        if (index < right) sort(input, index, right);
    }

    /**
     * Choose pivot
     * Init 2 pointers from both ends to do partition
     * Move left pointer if input[left] is smaller than pivot(skip smaller)
     * Move right pointer if input[right] is bigger than pivot(skip bigger)
     * Check if left <= right, if so, swap left and right, move them
     * Return left index
     */
    private int partition(int[] input, int left, int right) {
        int pivot = input[left + (right - left) / 2];
        while (left <= right) {
            while (input[left] < pivot) left++;
            while (input[right] > pivot) right--;
            if (left <= right) {
                int temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }
}
