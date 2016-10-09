package interview_bit.backtracking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by priyavivek on 11/10/15.
 */
public class Palinpart {

    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<String> currPartition = new ArrayList<>();
        getPalins(a,currPartition);


        //Sort the results by length
        Collections.sort(result, new Comparator<ArrayList<String>>(){
           @Override
           public int compare(ArrayList<String> a,ArrayList<String> b){
               int an = a.size();
               int bn = b.size();
               for (int i = 0; i < Math.min(an, bn); i++) {
                   int cmp = Integer.compare(a.get(i).length(), b.get(i).length());
                   if (cmp != 0)
                       return cmp;
               }
               return Integer.compare(an, bn);
           }
        });


        return result;
    }


    public void getPalins(String a,ArrayList<String> currPartition){
        if(a.equals("")){
            result.add(currPartition);
            return;
        }

        int i=0;
        int count = 1;
        //Get all possible substrings starting from a given index and check if they are palindromes
        while(count <= a.length()) {

            String s = a.substring(i, i + count);
            if (s.equals(reverseString(s))) {
                ArrayList<String> temp = new ArrayList<>();
                temp.addAll(currPartition);
                temp.add(s);
                if (i + count >= a.length()) {
                    getPalins("", temp);
                } else {
                    getPalins(a.substring(i + count, a.length()), temp);
                }

            }
            count++;
        }



    }

    public String reverseString(String a){
        StringBuilder b = new StringBuilder();
        for(int i=a.length()-1;i>=0;i--){
            b.append(a.charAt(i));
        }

        return b.toString();
    }

    public static void main(String[] args){
        Palinpart p = new Palinpart();
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        result = p.partition("aab");

    }

}
