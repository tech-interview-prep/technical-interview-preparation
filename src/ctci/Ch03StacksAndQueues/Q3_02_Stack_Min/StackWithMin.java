package ctci.Ch03StacksAndQueues.Q3_02_Stack_Min;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {
    private static final long serialVersionUID = 1L;

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}
