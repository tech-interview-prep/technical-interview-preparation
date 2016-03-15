package facebook;


import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main (String[] args) throws java.lang.Exception {
        List<String> ss = new ArrayList<String>();
        ss.add("abc");
        ss.add("acb");
        ss.add("bac");
        ss.add("bca");
        ss.add("cab");
        ss.add("cba");
        ss.add("abc");

        int checker = 0;

//        System.out.println(((0 | (1 << (Integer.MAX_VALUE-1))) & ( 1 << (Integer.MAX_VALUE-1))) > 0);

//        for(String s:ss) {
//            if((checker & (1 << s.hashCode())) > 0) {
//                System.out.println(checker);
//                System.out.println(s.hashCode());
//                System.out.println(s);
//            }
            for(int i= 1; i<=500; i++){
            System.out.println(i);
            System.out.println((checker & (1 << 10000000 + i)));
            checker |= (1 << 10000000 + i);
            System.out.println(checker);
            System.out.println("-----------------");

//            System.out.println((checker & (1 << s.hashCode())));
//            System.out.println(s.hashCode());
//            System.out.println(s);
//            checker = checker | (1 << s.hashCode());
        }
	}
}
