package interviewBit.stacksAndQueues;
import java.util.Stack;

/**
 * Created by priyavivek on 11/5/15.
 *
 * Problem statement
 *
 * Given an absolute path for a file (Unix-style), simplify it.

 Examples:

 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 Note that absolute path always begin with ‘/’ ( root directory )
 Path will not have whitespace characters.
 */
public class Simplifypath {
    public String simplifyPath(String a) {

        StringBuilder sb = new StringBuilder();
        Stack<String> result = new Stack<String>();
        Stack<String> reverseResult = new Stack<String>();

        int i=0;
        int j = 0;
        while(i<a.length()){

            if(i == a.length()-1){
                break;
            }

            if(a.charAt(i) == '/'){
                for(j = i+1;j<a.length();j++){
                    if(a.charAt(j) == '/'){
                        break;
                    }
                }
            }
            String currSubString = new String();
            currSubString = a.substring(i,j);

            if(currSubString.equals("/.") || currSubString.equals("/") || currSubString.equals("/ ")){
                //Do nothing in this case
                i=j;
                continue;
            }else if( currSubString.equals("/..") && !result.empty()){
                //Go 1 directory higher
                result.pop();
            }else if(!currSubString.equals("/.") &&  !currSubString.equals("/..")){
                result.push( currSubString);
            }

            i = j;

        }

        //Return root is stack is empty
        if(result.empty()){
            return "/";
        }


       //Reverse stack since result needs to be returned in reverse order
       while(!result.empty()){
            reverseResult.push(result.pop());
        }

        while (!reverseResult.empty()){
            sb.append(reverseResult.pop());
        }

        return sb.toString();


    }

    public static  void main(String[] args){
        Simplifypath sp = new Simplifypath();
        String result = sp.simplifyPath("/home//foo/");
        System.out.println(result);


    }


}
