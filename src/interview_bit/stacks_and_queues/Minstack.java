package interview_bit.stacks_and_queues;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by priyavivek on 11/7/15.
 *
 * Problem statement
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) – Push element x onto stack.
 pop() – Removes the element on top of the stack.
 top() – Get the top element.
 getMin() – Retrieve the minimum element in the stack.
 Note that all the operations have to be constant time operations.

 Questions to ask the interviewer :

 Q: What should getMin() do on empty stack?
 A: In this case, return -1.

 Q: What should pop do on empty stack?
 A: In this case, nothing.

 Q: What should top() do on empty stack?
 A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the
 */
public class Minstack {

    public ArrayList<Integer> a = new ArrayList<Integer>();
    public int minVal;

    Minstack(ArrayList<Integer> a){
        this.a = a;
        this.minVal = Integer.MAX_VALUE;
        for(int i=0;i<a.size();i++){
            if(a.get(i) < minVal){
                minVal = a.get(i);
            }
        }
    }

    Minstack(){
        this.minVal = Integer.MAX_VALUE;
    }

    public void push(int x) {
        a.add(x);
        if(x < minVal){
            minVal = x;
        }

    }

    public void pop() {

        if(!a.isEmpty()) {
            int temp = a.get(a.size()-1);
            a.remove(a.size() - 1);

            if(temp == minVal) {

                minVal = Integer.MAX_VALUE;

                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i) < minVal) {
                        minVal = a.get(i);
                    }
                }
            }
        }



    }

    public int top() {
        if(a.isEmpty()){
            return -1;
        }else {
            return a.get(a.size() - 1);
        }

    }

    public int getMin() {
        if(a.isEmpty()){
            return -1;
        }else{
            return minVal;
        }

    }

    public static void main(String[] args){

        ArrayList ip = new ArrayList<Integer>(Arrays.asList(2,6,9,-45,5));
        Minstack m =new Minstack(ip);
        System.out.println(m.getMin());
        System.out.println(m.top());
        m.push(-89);
        System.out.println(m.top());
        System.out.println(m.getMin());



    }
}
