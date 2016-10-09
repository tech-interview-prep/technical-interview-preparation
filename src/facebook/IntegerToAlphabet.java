package facebook;
// A Java program to print all interpretations of an integer array
import java.util.Arrays;

public class IntegerToAlphabet {
    /*
    Given a mapping of alphabets to integers as follows:

        1 = A
        2 = B
        3 = C
        ...
        26 = Z

        Given any combination of the mapping numbers as string, return the number of ways in which the input string can be split into sub-strings and represented as character strings. For e.g. given
        "111" -> "AAA", "AK", "KA" -> 3
        Valid combinations are ({1,1,1}, {1,11},{11,1}) = 3
        "11" -> "AA", "K" -> 2
        Valid combinations are ({1,1},{11}) = 2
        "123" -> "ABC", "LC", "AW" -> 3
        Valid combinations are ({1,2,3},{1,23},{12,3}) = 3

        You don't have to return all the mappings, only the number of valid mappings.


         http://www.careercup.com/question?id=5705619461898240
              https://gist.github.com/bittib/5693820
    */
    public int mappingsCount(String str) {

        char[] arr = str.toCharArray();

        int preCount = 1;
        int count = 1;

        if ( arr[arr.length - 1] == '0' ) {
            count = 0;
        }

        for ( int i = arr.length - 2; i >= 0; i-- ) {
            int value = arr[i] - '0';
            int curCount = 0;

            if ( value != 0 ) {
                curCount += count;

                value = value * 10 + arr[i + 1] - '0';

                if ( value < 27 ) {
                    curCount += preCount;
                }
            }

            preCount = count;
            count = curCount;
        }

        return count;
    }

    // http://www.geeksforgeeks.org/find-all-possible-interpretations/

    // Method to create a binary tree which stores all interpretations
    // of arr[] in lead nodes
    public Node createTree(int data, String pString, int[] arr) {

        // Invalid input as alphabets maps from 1 to 26
        if (data > 26)
            return null;

        // Parent String + String for this node
        String dataToStr = pString + alphabet[data];

        Node root = new Node(dataToStr);

        // if arr.length is 0 means we are done
        if (arr.length != 0) {
            data = arr[0];

            // new array will be from index 1 to end as we are consuming
            // first index with this node
            int newArr[] = Arrays.copyOfRange(arr, 1, arr.length);

            // left child
            root.left = createTree(data, dataToStr, newArr);

            // right child will be null if size of array is 0 or 1
            if (arr.length > 1) {

                data = arr[0] * 10 + arr[1];

                // new array will be from index 2 to end as we
                // are consuming first two index with this node
                newArr = Arrays.copyOfRange(arr, 2, arr.length);

                root.right = createTree(data, dataToStr, newArr);
            }
        }
        return root;
    }

    // To print out leaf nodes
    public void printleaf(Node root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            System.out.print(root.getDataString() + "  ");

        printleaf(root.left);
        printleaf(root.right);
    }

    // The main function that prints all interpretations of array
    public void printAllInterpretations(int[] arr) {

        // Step 1: Create Tree
        Node root = createTree(0, "", arr);

        // Step 2: Print Leaf nodes
        printleaf(root);

        System.out.println();  // Print new line
    }

    // For simplicity I am taking it as string array. Char Array will save space
    private final String[] alphabet = {"", "a", "b", "c", "d", "e",
                                       "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                                       "s", "t", "u", "v", "w", "x", "v", "z"
                                      };
}

//A Binary Tree node
class Node {

    String dataString;
    Node left;
    Node right;

    Node(String dataString) {
        this.dataString = dataString;
        //Be default left and right child are null.
    }

    public String getDataString() {
        return dataString;
    }
}
