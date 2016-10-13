package facebook;

/**
 * Design a data structure that supports the following two operations:
 *     void addWord(word)
 *     bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means
 * it can represent any one letter.
 *
 * For example:
 *     addWord("bad")
 *     addWord("dad")
 *     addWord("mad")
 *     search("pad") -> false
 *     search("bad") -> true
 *     search(".ad") -> true
 *     search("b..") -> true
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * You should be familiar with how a Trie works. If not, please work on this problem:
 * (Implement Trie -Prefix Tree)[https://leetcode.com/problems/implement-trie-prefix-tree/] first.
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class _211AddandSearchWord_DataStructureDesign {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("word");
        wordDictionary.search("pattern");
    }
}

class WordDictionary {
    TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isLeaf = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(root, word);
    }

    public boolean dfs(TrieNode root, String word) {
        if (word.equals("")) {
            return root.isLeaf;
        } else if (word.charAt(0) == '.') {
            for (int i = 0; i < 26; ++i) {
                if (root.children[i] != null &&
                        dfs(root.children[i], word.substring(1)))
                    return true;
            }
            return false;
        } else {
            TrieNode node = root.children[word.charAt(0) - 'a'];
            return node != null && dfs(node, word.substring(1));
        }
    }

    class TrieNode {
        public TrieNode[] children;
        public boolean isLeaf;

        public TrieNode() {
            children = new TrieNode[26];
            isLeaf = false;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
