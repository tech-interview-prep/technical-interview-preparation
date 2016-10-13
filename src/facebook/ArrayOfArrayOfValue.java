package facebook;

/**
 *
 * WAP to modify the array such that arr[I] = arr[arr[I]].
 * Do this in place i.e. with out using additional memory.
 *
 * example : if a = {2,3,1,0}
 * o/p = a = {1,0,3,2}
 *
 * Note : The array contains 0 to n-1 integers.
 *
 * (x + y*z)/z = y    provided x and y is less than z.
 * (x + y*z)%z = x    provided x and y is less than z.
 * This is the concept used here.
 * Example:
 * (3 + 4*5)/5 = 4
 * (3 + 4*5)%5 = 3
 *
 * arr[i] = arr[i] + arr[arr[i]]*size
 * so arr[i]/size = arr[arr[i]]
 *
 * In the code you see the author has used % below; this is done just to make sure arr[i] and arr[arr[i]]
 * is less than size as explained earlier.
 * arr[i] += (arr[arr[i]]%size)*size;
 *
 * http://www.careercup.com/question?id=4909367207919616
 */
public class ArrayOfArrayOfValue {
    void relocate(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            arr[i] += (arr[arr[i]] % size) * size;
        }
        for (int i = 0; i < size; i++) {
            arr[i] /= size;
        }
    }
}
