package facebook;

import java.util.Stack;

/*
    Given a current absolute path, e.g., "/usr/bin/mail", and
	a relative one, e.g, "../../../etc/xyz/../abc"
	return the absolute path created from the combination of the first two paths.
	In the example strings, the answer should be "/etc/abc".

*/
public class PrintPath {
    public static String printPath(String ab, String rel){
        Stack<String> s = new Stack<String>();
        String[] temp = ab.split("/");
        for(String st : temp){
            if(!st.isEmpty())
                s.push(st);
        }

        temp = rel.split("/");
        for(String st : temp){
            if(st.equals(".."))
                s.pop();
            else{
                s.push(st);
            }
        }

        String result = "/";
        while(!s.isEmpty()){
            result = "/" + s.pop() + result;
        }
        return result;
    }
}
