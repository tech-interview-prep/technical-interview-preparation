package geeksForGeeks;

public class MajorityElement {
    /*
        A majority element in an array A[] of size n is an element that appears more than n/2 times
        (and hence there is at most one such element).

        Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as follows:

        I/P : 3 3 4 2 4 4 2 4 4
        O/P : 4

        I/P : 3 3 4 2 4 4 2 4
        O/P : NONE
     */
    /* Function to find the candidate for Majority */
    int findCandidate(int a[], int size) {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < size; i++) {
            if (a[maj_index] == a[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more
       than n/2 times */
    boolean isMajority(int a[], int size, int cand) {
        int i, count = 0;
        for (i = 0; i < size; i++) {
            if (a[i] == cand) {
                count++;
            }
        }
        if (count > size / 2) {
            return true;
        } else {
            return false;
        }
    }
}
