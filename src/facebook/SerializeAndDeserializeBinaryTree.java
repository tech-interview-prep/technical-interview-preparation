package facebook;

import java.util.StringTokenizer;

/*
	Given a normal binary tree, write a function to serialize the tree into a string representation
	(returning the string), and also a function to deserialize a serialized string into the original binary tree.
	
	Link: http://www.careercup.com/question?id=5729456584916992
	      https://gist.github.com/bittib/5620951

*/	
public class SerializeAndDeserializeBinaryTree {
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

    public TreeNode deserialize(String s){
        if (s == null || s.length() == 0) return null;
        StringTokenizer st = new StringTokenizer(s, " ");
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
