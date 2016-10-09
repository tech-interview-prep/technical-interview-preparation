package interview_bit.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import utils.TreeNode;

/**
 * Created by priyavivek on 11/15/15.
 *
 * In-order, pre-order and post-order traversal
 */
public class Treetraversal {
    public ArrayList<Integer> arrayIn = new ArrayList<>();
    public ArrayList<Integer> arrayPre = new ArrayList<>();
    public ArrayList<Integer> arrayPost = new ArrayList<>();

    public void inOrderRecursive(TreeNode a) {

        if (a == null) {
            return;
        }
        inOrderRecursive(a.left);
        arrayIn.add(a.data);
        inOrderRecursive(a.right);

    }

    public ArrayList<Integer> inOrderIterative(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || a != null) {
            if (a != null) {
                stack.push(a);
                a = a.left;

            } else {
                TreeNode temp = stack.pop();
                result.add(temp.data);
                a = temp.right;

            }
        }

        return result;
    }


    public void preOrderRecursive(TreeNode a) {
        if (a == null) {
            return;
        }
        arrayPre.add(a.data);
        preOrderRecursive(a.left);
        preOrderRecursive(a.right);

    }

    public void postOrderRecursive(TreeNode a) {
        if (a == null) {
            return;
        }
        postOrderRecursive(a.left);
        postOrderRecursive(a.right);
        arrayPost.add(a.data);

    }

    public static void main(String[] args) {

        ArrayList<String> s = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"));
        TreeNode root = CreateBST.insertElements(s);

        Treetraversal t = new Treetraversal();
        t.inOrderRecursive(root);
        t.preOrderRecursive(root);
        t.postOrderRecursive(root);

        System.out.println("Printing in-order");
        for (int i = 0; i < t.arrayIn.size(); i++) {
            System.out.println(t.arrayIn.get(i));
        }

        System.out.println("Printing pre-order");
        for (int i = 0; i < t.arrayPre.size(); i++) {
            System.out.println(t.arrayPre.get(i));
        }

        System.out.println("Printing post-order");
        for (int i = 0; i < t.arrayPost.size(); i++) {
            System.out.println(t.arrayPost.get(i));
        }

    }
}
