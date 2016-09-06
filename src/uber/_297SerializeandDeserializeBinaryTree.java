/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the
same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be
serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as (how LeetCode OJ serializes a binary tree)[https://leetcode.com/faq/#binary-tree]. You do not necessarily
need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms
should be stateless.

Link: http://www.careercup.com/question?id=5729456584916992
Link: https://gist.github.com/bittib/5620951
*/

package uber;

import java.util.StringTokenizer;

import utils.TreeNode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * @author bkoteshwarreddy
 */

public class _297SerializeandDeserializeBinaryTree {
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode x, StringBuilder sb){
        if (x == null) {
            sb.append("# ");
        } else {
            sb.append(x.data + " ");
            serialize(x.left, sb);
            serialize(x.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        if (data == null || data.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    private TreeNode deserialize(StringTokenizer st){
        if (!st.hasMoreTokens())
            return null;
        String val = st.nextToken();
        if (val.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
