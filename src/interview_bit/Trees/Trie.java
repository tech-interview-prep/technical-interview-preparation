package interview_bit.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by priyavivek on 11/21/15.
 *
 * A basic Trie datastructure with insert and search
 */
public class Trie {
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        HashMap<Character,TrieNode> children = root.children;
        for(int i=0;i<word.length();i++){
            char currChar = word.charAt(i);
            TrieNode t;
            if(children.containsKey(currChar)){
                t = children.get(currChar);
            }else {
                t = new TrieNode(currChar);
                children.put(currChar,t);
            }

            children = t.children;

            if(i == word.length()-1){
                t.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if(t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }

        return t;
    }


    class TrieNode{
        Character c;
        HashMap<Character,TrieNode> children = new HashMap<>();
        boolean isLeaf;

        public TrieNode(){

        }

        public TrieNode(char c){
            this.c = c;
        }
    }
}
