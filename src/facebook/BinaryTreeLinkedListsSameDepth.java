package facebook;

import java.util.ArrayList;
import java.util.LinkedList;

/*
    Given a binary search tree, design an algorithm which creates a linked list of all the
    nodes at each depth (eg, if you have a tree with depth D, you’ll have D linked lists).

     https://gist.github.com/zac-xin/2627331

*/
public class BinaryTreeLinkedListsSameDepth {
    public static ArrayList<LinkedList<BTNode<Integer>>>
    findLevelLinkedList(BTNode<Integer> root) {

        int level = 0;
        ArrayList<LinkedList<BTNode<Integer>>> result =
            new ArrayList<LinkedList<BTNode<Integer>>>();
        LinkedList<BTNode<Integer>> list = new LinkedList<BTNode<Integer>>();
        list.add(root);
        result.add(list);

        while (true) {
            list = new LinkedList<BTNode<Integer>>();
            for (int i = 0; i < result.get(level).size(); i++) {
                BTNode<Integer> node = result.get(level).get(i);
                if (node.getLeft() != null)
                    list.add(node.getLeft());
                if (node.getRight() != null)
                    list.add(node.getRight());
            }
            if (list.size() > 0) {
                result.add(list); // or  result.add(level+1, list)
                level++;
            } else
                break;
        }

        return result;
    }
}

class BTNode<E> implements Cloneable {
    private E data;
    private BTNode<E> left;
    private BTNode<E> right;

    public BTNode(E data, BTNode<E>  left, BTNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BTNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public E getData() {
        return data;
    }

    public BTNode<E> getLeft() {
        return left;
    }

    public BTNode<E> getRight() {
        return right;
    }

    public E getLeftmostData() {
        if (left == null)
            return data;
        else
            return left.getLeftmostData();
    }

    public E getRightmostData() {
        if (right == null)
            return data;
        else
            return right.getRightmostData();
    }

    public void inorderPrint() {
        if (left != null)
            left.inorderPrint();
        System.out.println(data);
        if (right != null)
            right.inorderPrint();
    }

    public void preorderPrint() {
        System.out.println(data);
        if (left != null)
            left.preorderPrint();
        if (right != null)
            right.preorderPrint();
    }

    public void postorderPrint() {
        if (left != null)
            left.postorderPrint();
        if (right != null)
            right.postorderPrint();
        System.out.println(data);
    }

    public boolean isLeaf() {
        return ((left == null) && (right == null));
    }

    public BTNode<E> removeLeftmost() {

        if (left == null)
            return right;
        else {
            left = left.removeLeftmost();
            return this;
        }
    }

    public BTNode<E> removeRightmost() {

        if (right == null)
            return left;
        else {
            right = right.removeRightmost();
            return this;
        }
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setLeft(BTNode<E> left) {
        this.left = left;
    }

    public void setRight(BTNode<E> right) {
        this.right = right;
    }

    public static <E> BTNode<E> treecopy(BTNode<E> source) {
        BTNode<E> copyLeft, copyRight;

        if (source == null)
            return null;
        else {
            copyLeft = treecopy(source.left);
            copyRight = treecopy(source.right);
            return new BTNode<E>(source.data, copyLeft, copyRight);
        }
    }

    public static <E> int treeSize(BTNode<E> root) {
        if (root == null)
            return 0;
        else {
            return 1 + treeSize(root.left) + treeSize(root.right);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data);
        return sb.toString();
    }
}
