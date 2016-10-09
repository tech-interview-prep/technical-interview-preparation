package facebook;

/**
 * Input [2,3,1,4]
 * Output [12,8,24,6]
 *
 * Multiply all fields except it's own position.
 *
 * Restrictions:
 *     1. no use of division
 *     2. complexity in O(n)
 *
 *  http://www.careercup.com/question?id=5179916190482432
 */
public class MultiplyExceptItsPosition {
    int [] product (int [] input) {
        int [] front = new int[input.length];
        int [] rear = new int[input.length];
        int [] output = new int[input.length];
        front[0] = 1;
        rear[input.length - 1] = 1;

        for (int i = 1; i < input.length; i++) {
            front[i] = front[i - 1] * input[i - 1];
        }

        for (int i = input.length - 2; i >= 0; i--) {
            rear[i] = rear[i + 1] * input[i + 1];
        }

        for (int i = 0; i < input.length; i++) {
            output[i] = front[i] * rear[i];
        }

        return output;
    }
}
