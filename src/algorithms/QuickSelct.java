package algorithms;

class QuickSelect {
    public static void main(String[] args) {
        QuickSelect q = new QuickSelect();
        QuickSort qs = new QuickSort();
        int[] input = { 1, 4, 2, 8, 5};
        int result = q.select(input, 0);
        qs.sort(input, 0, input.length - 1);
        System.out.println(result);
        System.out.println(input[1]);
    }

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     */
    public int select(int[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IndexOutOfBoundsException("Selected element out of bounds");
        }

        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
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
