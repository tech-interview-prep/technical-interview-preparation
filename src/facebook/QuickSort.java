package facebook;

/**
 * Quick Sort
 *
 * https://github.com/gaylemcd/ctci/blob/master/java/Chapter%2011/Introduction/Quicksort.java
 */
public class QuickSort {
    public static void quickSort(char[] data, int left, int right) {
        if (right - left > 0) {
            int pivot = partition(data, left, right);
            quickSort(data, left, pivot - 1);
            quickSort(data, pivot + 1, right);
        }
    }

    public static int partition(char[] data, int left, int right) {
        int pivot = data[left];
        char temp;
        int i = left + 1;

        for (int j = left + 1; j <= right; j++) {
            if (data[j] < pivot) {
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;
                i++;
            }
        }

        temp = data[i - 1];
        data[i - 1] = data[left];
        data[left] = temp;

        return i - 1;
    }

}
