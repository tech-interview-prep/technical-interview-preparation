- [Amazon most asked questions - Set 1](http://quiz.geeksforgeeks.org/amazons-asked-interview-questions/)
- [Amazon most asked questions - Set 2](http://quiz.geeksforgeeks.org/amazons-most-frequently-asked-interview-questions-set-2/)
- **Arrays/Strings:**
  - [ ] Determine if a string is a palindrome
  - [ ] Merge two sorted arrays
  - [ ] Reverse an array in place
  - [ ] Find substring
  - [ ] All sorting algorithms
  - [ ] Binary search in a sorted rotated array
  - [ ] Max profit stock problem
  - [ ] Matrix multiplication
  - [ ] Find all duplicates in an array
  - [ ] Print a matrix in a spiral manner
- **Linked List:**
  - [ ] Reverse a singly linked list
  - [ ] Delete/Insert a node in a linked list
  - [ ] Detect if there is a cycle in the list and return its starting point
  - [ ] Merge two sorted lists
  - [ ] Split a list into two lists one has even indexes other has odd indexes
- **Trees:**
  - [ ] Check if tree is balanced
  - [ ] All traversals, recursive and iterative implementations
  - [ ] BFS/DFS
  - [ ] Construct a BST from a sorted array
  - [ ] Check if two trees are mirror image of each other
  - [ ] Find max path sum in the tree, negative nodes possible
  - [ ] Lowest common ancestor of 2 nodes in a tree
- **Backtracking:**
  - [ ] Find all permutations or combinations
  - [ ] Find all possible subsets
  - [ ] N queens problem
  - [ ] Convert numbers into words according to letters on an old phone keypad
- **Hashtables:**
  - [ ] Questions where you need to keep track of multiple occurences of same object
  - [ ] Questions where you want to have a 2 tuple as a key
- **Dynamic programming:**
  - [ ] Given you can climb 1,2, or 3 stairs in one step, how many ways of reaching the
top
  - [ ] How many ways to go from top left of a grid to bottom right of the grid with some
obstacles in between
  - [ ] Implement both bottom up and top down solutions for both of the above

-----------------------------------------------------------------------------------------------------------------------

- https://itsrough.wordpress.com/2012/10/20/must-read-problems-of-leetcode/

Amazon interview preparation
Tree formation:
```
class Node
{
public:
  Node(value) { nValue = value; pLeft = pRight = NULL; }

  Node* pLeft;
  Node* pRight;
  int nValue;  // or any other data
}

class Tree
{
public:
  Node* pRoot;
  Tree() { pRoot = NULL; }

  Node* search(int value); //...
  void createLeaf(int value); //...
  // ...
}
```
Geeks for geeks (Update: Feb 15, 2013)

http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/

http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

http://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/

http://www.geeksforgeeks.org/majority-element/

http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/

http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/

LeetCode must read problems:

http://www.leetcode.com/2010/04/how-to-determine-if-point-is-inside.html

http://www.leetcode.com/2010/04/rotating-array-in-place.html

http://www.leetcode.com/2010/09/fun-with-bit-operations.html

http://www.leetcode.com/2010/09/number-of-1-bits.html

http://www.leetcode.com/2010/09/printing-binary-tree-in-level-order.html

http://www.leetcode.com/2010/09/determine-if-binary-tree-is-binary.html

http://www.leetcode.com/2010/09/printing-binary-tree-in-zig-zag-level_18.html

http://www.leetcode.com/2010/10/print-edge-nodes-boundary-of-binary.html

http://www.leetcode.com/2010/11/stack-that-supports-push-pop-and-getmin.html

http://www.leetcode.com/2010/11/largest-binary-search-tree-bst-in_22.html

http://www.leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html

http://www.leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html

http://www.leetcode.com/2011/05/determine-if-two-rectangles-overlap.html

http://www.leetcode.com/2011/07/lowest-common-ancestor-of-a-binary-tree-part-ii.html

http://www.leetcode.com/2011/08/reverse-bits.html
GeeksForGeeks data structure link:

http://www.geeksforgeeks.org/forum/tags/data-structures
Cool questions:

http://www.geeksforgeeks.org/forum/topic/given-inorder-and-postorder-traversals-construct-a-binary-tree

http://www.geeksforgeeks.org/archives/category/linked-list

Diameter of tree: http://www.geeksforgeeks.org/archives/5687

Three way partitioning: ( low and high are the numbers you want to partition by. p and q are regular quick sort counters. Check anything lower than low and swap it with the number placed at p and increment p, parallely, check anything more than high and swap it with the number placed at q and decrement q

```
void threeWayPartition(int data[], int size, int low, int high) {
  int p = -1;
  int q = size;
  for (int i = 0; i < q;) {
    if (data[i] < low) {
      swap(data[i], data[++p]);
      ++i;
    } else if (data[i] >= high) {
      swap(data[i], data[--q]);
    } else {
      ++i;
    }
  }
}
```

2 way partitioning:
```
Low = 0 , High = n-1
A[low] = 0.. Lo++, 1.. A[lo]><A[high] & low++ & high--
```

3 way partitioning:
```
Low = 0, Mid = 0, High = n-1
A[mid] = 0.. a[low]><A[mid] & low++ & mid++, 1.. mid++, 2.. a[mid]><a[high] & mid++ & high--
```
