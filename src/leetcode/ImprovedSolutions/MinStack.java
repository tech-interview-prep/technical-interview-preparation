package leetcode.algorithms;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/
 * @author bkoteshwarreddy
 */

class MinStack {
    /**
     * Design a stack that supports push, pop, top, and retrieving the minimum
     * element in constant time.
     *
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     *
     * Example:
     *   MinStack minStack = new MinStack();
     *   minStack.push(-2);
     *   minStack.push(0);
     *   minStack.push(-3);
     *   minStack.getMin();   --> Returns -3.
     *   minStack.pop();
     *   minStack.top();      --> Returns 0.
     *   minStack.getMin();   --> Returns -2.
     */

    private Stack<Integer> s = new Stack<Integer>();
    /**
     * Standard solution, two ss
     * a minStack to store minimums
     */
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) { // even smaller
            minStack.push(x);
        }
    }

    public void pop() {
        if (s.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return (int) s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * DP, one stack
 * build a static wrapper class for items in stack
 * including its value and current min
 */
class MinStack2 {

    /**
     * Wrapper class for element in stack
     */
    static class Element {

        final int value;
        final int min;

        public Element(int x, int min) {
            this.value = x;
            this.min = min;
        }
    }

    Stack<Element> s;

    public void push(int x) {
        if (s == null) s = new Stack<Element>();
        int min = s.isEmpty() ? x : Math.min(x, s.peek().min);
        s.push(new Element(x, min));
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek().value;
    }

    public int getMin() {
        return s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
