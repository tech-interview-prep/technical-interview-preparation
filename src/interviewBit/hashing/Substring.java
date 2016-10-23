package interviewBit.hashing;
//import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by priyavivek on 11/14/15.
 * Problem statement
 *
 * You are given a string, S, and a list of words, L, that are all of the same length.

 Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

 Example :

 S: "barfoothefoobarman"
 L: ["foo", "bar"]
 You should return the indices: [0,9].
 (order does not matter).
 */
public class Substring {

    ArrayList<String> perms = new ArrayList<>();
    HashMap<String,Integer> permCounts = new HashMap<>();
    public ArrayList<Integer> findSubstring(String a, final List<String> b) {

        ArrayList<Integer> result = new ArrayList<>();


        //Pre-processing
        //In this portion check the number of unique substrings in 'b'. Add the lengths of those sub-strings.
        //If this length is greater than the length of 'a' the input string, then return an empty list
        HashMap<String,Integer> uniqueSubstrings = new HashMap<>();
        int subLen = 0;
        for(int i=0;i<b.size();i++){
            String currString = b.get(i);
            if(!uniqueSubstrings.containsKey(currString)){
                uniqueSubstrings.put(currString,1);
                subLen+=currString.length();
            }
        }

        if(subLen > a.length()){
            return result;

        }

        //Store all possible unique permutations of sub-strings in a hashmap
        getPerms(b, "");
        //Put all the unique substrings in a list
        for(Map.Entry<String,Integer> x : permCounts.entrySet()){
            perms.add(x.getKey());
        }

        //Check to see if the substring exists in the input string and if so, get its starting index
        for(int i=0;i<perms.size();i++){
            int strlen = perms.get(i).length();
            if(strlen > a.length()){
                break;
            }
            String currString = perms.get(i);
            for(int j=0;j<=a.length()-strlen;j++){
                if(currString.equals(a.substring(j,j+strlen))){
                    result.add(j);
                }
            }

        }

        return result;

    }

    //Compute all possible permutations of substrings
    public void getPerms(List<String> subList,String prev){

        if(subList.size() == 1){
            String s = prev + subList.get(0);
            if(!permCounts.containsKey(s)){
                permCounts.put(s,1);
            }
            return;
        }

        for(int i=0;i<subList.size();i++){
            List<String> subStrings = new ArrayList<>();
            for(int j=0;j<subList.size();j++){
                if(j!=i){
                    subStrings.add(subList.get(j));
                }
            }

            getPerms(subStrings,prev + subList.get(i));



        }
    }

    public static void main(String[] args){
        Substring s = new Substring();
        List<String> b = new ArrayList<>(Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa"));
        ArrayList<Integer> result = new ArrayList<>();
        result = s.findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",b);

        ArrayList<Integer> expectedResult = new ArrayList<>();
        for(int i=0;i<99;i++){
            expectedResult.add(i);

        }


//        assertEquals("Expected result",expectedResult,result);

    }
}
