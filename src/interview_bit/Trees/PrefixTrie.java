package interview_bit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by priyavivek on 11/21/15.
 *
 * Problem statement
 *
 * Find shortest unique prefix to represent each word in the list.

 Example:

 Input: [zebra, dog, duck, dove]
 Output: {z, dog, du, dov}
 where we can see that
 zebra = z
 dog = dog
 duck = du
 dove = dov

 */
public class PrefixTrie extends Trie {
    public void insert(ArrayList<String> stringList){
        for(int i=0;i<stringList.size();i++){
            super.insert(stringList.get(i));
        }
    }

    public ArrayList<String> prefix(ArrayList<String> stringList) {

        ArrayList<String> result = new ArrayList<>();

        //Iterate through the list of words
        for(int i=0;i<stringList.size();i++){
            Map<Character, TrieNode> children = root.children;
            String currString = new String();
            currString = stringList.get(i);

            int subStringInd = 1;

            //For each word, iterate through all the characters and check its Trie to see where a node has multiple children.
            //The unique prefix will be all characters from the start to the point just after where a node has multiple children with all
            //nodes that follow having just one child.
            for(int j=0;j<currString.length();j++){
                char c = currString.charAt(j);
                TrieNode t = children.get(c);
                if(children.size() > 1){
                    subStringInd = j + 1;
                }
                children = t.children;
            }

            result.add(currString.substring(0,subStringInd));
        }
        return result;
    }

    public static void main(String[] args){
        PrefixTrie p = new PrefixTrie();
        ArrayList<String> input = new ArrayList<String>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ArrayList<String> result = new ArrayList<>();

        p.insert(input);
        result = p.prefix(input);
    }
}
