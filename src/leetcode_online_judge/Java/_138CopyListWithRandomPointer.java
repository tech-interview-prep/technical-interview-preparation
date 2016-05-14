package leetcode_online_judge.Java;

import utils.RandomListNode;

public class _138CopyListWithRandomPointer {
    /*
    A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

    Return a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode node, copyNode;
        for (node = head; node != null;
             copyNode = new RandomListNode(node.label), copyNode.next = node.next, node.next = copyNode, node = copyNode.next);

        for (node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }

        RandomListNode dummyNode = new RandomListNode(0), currentNode = dummyNode;
        for (node = head; node != null; node = node.next ) {
            currentNode.next = node.next;
            node.next = node.next.next;
            currentNode = currentNode.next;
        }

        return dummyNode.next;
    }

    private static void test() {
        RandomListNode node = RandomListNode.constructRandomList(5);
        node.print();

        copyRandomList(node).print();

        System.out.println("-----------");

        node = RandomListNode.constructRandomList(1);
        node.print();

        copyRandomList(node).print();
    }

    public static void  main(String[] args) {
        test();
    }
}
