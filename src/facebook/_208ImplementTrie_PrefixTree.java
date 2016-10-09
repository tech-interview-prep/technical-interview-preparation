/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * @author bkoteshwarreddy
 */
public class _208ImplementTrie_PrefixTree {
}

class TrieNode {
    List<TrieNode> kids = new ArrayList<TrieNode>();
    HashMap<Character, Integer> index = new HashMap<Character, Integer>();
    char c = '0';
    boolean isLeaf = false;

    // Initialize your data structure here.
    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            // prefix not exist
            if (!node.index.containsKey(word.charAt(i))) {
                TrieNode cur = new TrieNode(word.charAt(i));
                node.kids.add(cur);
                node.index.put(word.charAt(i), node.kids.size() - 1);
            }
            node = node.kids.get(node.index.get(word.charAt(i)));
        }
        node.isLeaf = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            if (!node.index.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.kids.get(node.index.get(word.charAt(i)));
        }
        return node.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); ++i) {
            if (!node.index.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.kids.get(node.index.get(prefix.charAt(i)));
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
