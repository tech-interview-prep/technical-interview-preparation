package interviewBit.stacksAndQueues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by priyavivek on 11/7/15.
 *
 * Problem statement
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Examples:

 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Evalexp {
    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> result = new Stack<Integer>();
        int topval,bottomval;

        //Assumptions : No divide by zero cases, no overflow or underflow.

        for(int i=0;i<a.size();i++){
            switch(a.get(i)){
                case "+": topval = result.pop();
                          bottomval = result.pop();
                          result.push(bottomval + topval);
                          break;

                case "-": topval = result.pop();
                          bottomval = result.pop();
                          result.push(bottomval - topval);
                          break;

                case "*": topval = result.pop();
                          bottomval = result.pop();
                          result.push(bottomval * topval);
                          break;

                case "/": topval = result.pop();
                          bottomval = result.pop();
                          result.push(bottomval / topval);
                          break;

                default: result.push(Integer.parseInt(a.get(i)));
                         break;



            }

        }

        return result.pop();


    }

    public  static void main(String[] args){
        Evalexp e = new Evalexp();
        ArrayList<String> s = new ArrayList<String>(Arrays.asList("4", "13", "5", "/", "+"));
        int result = e.evalRPN(s);
        System.out.println(result);



    }
}
