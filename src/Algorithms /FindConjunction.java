import java.util.*;

public class FindConjunction {

        public static void main(String[] args){

                String[] names = {"Alex","Alice", "Halloween", "LOL"};
                System.out.println(findConjunction(names, 2));
        }
        
        public static String findConjunction(String[] names, int limit){
            if(names == null || names.length == 0 || limit == 0 || limit < -1) throw new IllegalArgumentException("Invalid entry");
            
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < limit;++i){
                str.append(names[i] + ", ");
            }
            str.append("and " + (names.length-limit) + " more ");
            return str.toString();
        }
}
