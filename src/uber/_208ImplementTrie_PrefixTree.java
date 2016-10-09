/**
 * Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
package uber;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * @author bkoteshwarreddy
 */
public class _208ImplementTrie_PrefixTree {
}

class TrieNode {
    // Initialize your data structure here.
    public TrieNode() {

    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        this.setRoot(new TrieNode());
    }

    // Inserts a word into the trie.
    public void insert(String word) {

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return false;
    }

    public TrieNode getRoot() {
        return this.root;
    }

    public void setRoot(TrieNode root) {
        this.root = root;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
