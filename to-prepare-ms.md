Circle algorithm
sorting a large list of numbers with limited memory

Q: What is the difference between a thread and a process?
A: A process is self-contained and gets its own virtual address space. A thread shares heap space with other threads in the same process, making communication easier and faster, and also conserving memory at the expense of isolation and stability.

Q: How would you communicate between threads?
A: One can communicate between threads using shared memory, or by using a mutex library such as pthreads that allows waiting and signaling on locks.

Q: How would you communicate between processes?
A: By opening a socket, using named pipes, or the filesystem.

how to calculate the height of a binary tree,
test whether it was full or not,
find the depth of a given node.
modify the node structure so that each node in a full binary tree would point to the node on its right.

###List of topics
- [How Companies Evaluate Technical Interviews](https://www.youtube.com/watch?v=jxAWQN5t6wg)
- [How to Approach Behavioral Questions](https://www.youtube.com/watch?v=tZxNNKqxXnw)
- [7 Steps to Solve Algorithm Problems](https://www.youtube.com/watch?v=GKgAVjJxh9w)
- [3 Algorithm Strategies](https://www.youtube.com/watch?v=84UYVCluClQ)
- [Big O](https://www.youtube.com/watch?v=v4cd1O4zkGw)
- [Bit MAnipulation](https://www.youtube.com/watch?v=NLKQEOgBAnw)
- Powers of 2 Table

Power of 2  | Exact Value (X)   | Approx. Value | X Bytes into MB, GB,e.t.c
------------| ------------------| --------------| ------------------------
7  | 128 | |
8  | 256 | |
10 | 1024 | 1 thousand | 1 KB
16 | 65,536 | | 64 KB
20 | 1,048,576 | 1 million | 1 MB
30 | 1,073,741,824 | 1 billion | 1 GB
32 | 4,294,967,296 | | 4 GB
40 | 1,099,511,627,776 | 1 trillion | 1 TB

#####**[Data Structures](https://www.coursera.org/learn/data-structures/home):**
- [Arrays](https://www.youtube.com/watch?v=NLAzwv4D5iI)
- Vectors
- [ArrayLists](https://www.youtube.com/watch?v=NLAzwv4D5iI)
- [Strings](https://www.youtube.com/watch?v=gbxodBVkElQ)
- [StringBuffer](https://www.youtube.com/watch?v=gbxodBVkElQ)
- [StringBuilder](https://www.youtube.com/watch?v=gbxodBVkElQ)
- [LinkedLists](https://www.youtube.com/watch?v=njTh_OwMljA)
- Hashset
- Hashmap
- [Hashtables](https://www.youtube.com/watch?v=shs0KM3wKv8)
- Dictionary
- [Stacks and Queues](https://www.youtube.com/watch?v=wjI1WNcIntg)
- [Heaps/Priority queues](https://www.youtube.com/watch?v=t0Cq6tVNRBA)
- [Trees](https://www.youtube.com/watch?v=oSWTXtMglKE) (Binary Tree, [Binary Search Tree](https://www.youtube.com/watch?v=i_Q0v_Ct5lY), kd Tree, 2-3 Tree, AVL)
- [Tries](https://www.youtube.com/watch?v=zIjfhVPRZCg)
- Graph
- Bloom Filter

#####**Sorting:**
- [Merge sort](https://www.youtube.com/watch?v=KF2j-9iSf4Q)/Poly phase merge sort
  - Applications
- [Quick sort](https://www.youtube.com/watch?v=SLauY6PpjW4)/ 3-Way Quick sort/Dual Pivot Quick sort
  - Applications
- Insertion sort
- [Bubble sort](https://www.youtube.com/watch?v=6Gv8vg0kcHc)
- Bucket sort
- Heap sort

#####**Searching:**
- [BFS](https://www.youtube.com/watch?v=zaBhtODEL0w)
- [DFS](https://www.youtube.com/watch?v=zaBhtODEL0w)
- [Binary Search](https://www.youtube.com/watch?v=P3YID7liBug)
  - Applications
- LinkedList insert / delete / find
- Tree insert / delete / find
- Heap insert / delete / find

#####**Algorithms:**
- Quick select
- 3 Way Partitioning
- Tree Balancing
- Divide and conquer
- [Dynamic programming / Memoization](https://www.youtube.com/watch?v=P8Xa2BitN3I)
- Recursion [Video - CtCI](https://www.youtube.com/watch?v=KEEKn7Me-ms), [Programcreek notes](http://www.programcreek.com/2012/10/iteration-vs-recursion-in-java/)
- Rsync algorithm
- [A* Search Algorithm](http://www.geeksforgeeks.org/a-search-algorithm/)

#####**Concepts:**
- [Scalability](http://www.lecloud.net/post/7295452622/scalability-for-dummies-part-1-clones)
- Memory limits
- Distributed computing and Design
- Networking (IPC, TCP/IP, OSI Model)
- Concurrency
  - process
  - threads
  - locks
  - mutexes
  - deadlock
  - livelock
  - scheduling
  - monitors
  - starvation
  - consistency
  - coherence
  - mutual exclusion
  - semaphore
  - synchronized vs unsynchronized
- Abstraction (understanding how OS, filesystem, and database works)
- Real-world performance (relative performance RAM, disk, your network, SSD)
- Availability and Reliability (durability, understanding how things can fail)
- Data storage (RAM vs. durable storage, compression, byte sizes)
- CAP Theorem
- Byte math

#####**Programming Concepts:**
- OOPS
  - Abstraction
  - Polymorphism
  - Inheritance
  - Encapsulation
- Interface
- Abstract class
- try, catch, finally
- throw, throws
- this, super
- final
- break, continue, return
- static
- virtual functions
- malloc, calloc, realloc
- free, new, delete
- classes, inner classes, objects
- variables
- override
- overload
- generics
- collections
- Autoboxing
- Wrapper class
- equals()
- hashcode()
- toString()
- finalize()
- notify()
- notifyAll()
- wait()
- Testing

#####**Project management Concepts:**
- Six sigma
- Lean
- Agile
- Scrum

#####**From resume:**
- OSPF
- BGP
- EIGRP
- AWS
- Google Docs
- Branch and Bound
- Randomized
- Hadoop, Map Reduce, HBase, Pipelines, Apache Crunch, Solr, Avro
- Maven
- Jersey, RestEasy, JSON
- Chef
- Javascript, D3 library

Fibonacci number


##Easy:
  - ~~1. Two Sum~~
  - ~~8.   String to Integer (atoi)~~
  - ~~13.  Roman to Integer~~
  - ~~20.  Valid Parentheses~~
  - ~~21.  Merge Two Sorted Lists~~
  - ~~24.  Swap Nodes in Pairs~~
  - ~~26.  Remove Duplicates from Sorted Array~~
  - ~~28.  Implement strStr()~~
  - 36.  Valid Sudoku
  - ~~88.  Merge Sorted Array~~
  - ~~101. Symmetric Tree~~
  - 102. Binary Tree Level Order Traversal
  - 104. Maximum Depth of Binary Tree
  - 107. Binary Tree Level Order Traversal II
  - 110. Balanced Binary Tree
  - 111. Minimum Depth of Binary Tree
  - 112. Path Sum
  - 121. Best Time to Buy and Sell Stock
  - 125. Valid Palindrome
  - ~~141. Linked List Cycle~~
  - 160. Intersection of Two Linked Lists
  - 165. Compare Version Numbers
  - 168. Excel Sheet Column Title
  - 171. Excel Sheet Column Number
  - 189. Rotate Array
  - 191. Number of 1 Bits
  - 204. Count Primes
  - 206. Reverse Linked List
  - 232. Implement Queue using Stacks
  - 235. Lowest Common Ancestor of a Binary Search Tree
  - ~~237. Delete Node in a Linked List~~
  - 258. Add Digits
  - 270. Closest Binary Search Tree Value

##Medium:
  - 2.   Add Two Numbers
  - 5.   Longest Palindromic Substring
  - 15.  3Sum
  - 22.  Generate Parentheses
  - 46.  Permutations
  - 47.  Permutations II
  - 48.  Rotate Image
  - 53.  Maximum Subarray
  - 54.  Spiral Matrix
  - 55.  Jump Game
  - 71.  Simplify Path
  - 73.  Set Matrix Zeroes
  - 75.  Sort Colors
  - 79.  Word Search
  - 91.  Decode Ways
  - 94.  Binary Tree Inorder Traversal
  - 98.  Validate Binary Search Tree
  - 103. Binary Tree Zigzag Level Order Traversal
  - 105. Construct Binary Tree from Preorder and Inorder Traversal
  - 106. Construct Binary Tree from Inorder and Postorder Traversal
  - 114. Flatten Binary Tree to Linked List
  - ~~116. Populating Next Right Pointers in Each Node~~
  - 144. Binary Tree Preorder Traversal
  - 151. Reverse Words in a String
  - 153. Find Minimum in Rotated Sorted Array
  - 162. Find Peak Element
  - 173. Binary Search Tree Iterator
  - 186. Reverse Words in a String II
  - ~~200. Number of Islands~~
  - 208. Implement Trie (Prefix Tree)
  - 213. House Robber II
  - 215. Kth Largest Element in an Array
  - 236. Lowest Common Ancestor of a Binary Tree
  - 238. Product of Array Except Self
  - 268. Missing Number
  - 285. Inorder Successor in BST
  - 300. Longest Increasing Subsequence
  - 314. Binary Tree Vertical Order Traversal
  - 333. Largest BST Subtree
  - 348. Design Tic-Tac-Toe
  - 365. Water and Jug Problem

##Hard:
  - 4.   Median of Two Sorted Arrays
  - 23.  Merge k Sorted Lists
  - 25.  Reverse Nodes in k-Group
  - 33.  Search in Rotated Sorted Array
  - 37.  Sudoku Solver
  - 56.  Merge Intervals
  - ~~117. Populating Next Right Pointers in Each Node II~~
  - 124. Binary Tree Maximum Path Sum
  - ~~138. Copy List with Random Pointer~~
  - 145. Binary Tree Postorder Traversal
  - 146. LRU Cache
  - 174. Dungeon Game
  - 212. Word Search II
  - 218. The Skyline Problem
  - 273. Integer to English Words
  - 297. Serialize and Deserialize Binary Tree

Longest Absolute File Path
LFU Cache
Minimum Genetic Mutation
Fizz Buzz
Sentence Screen Fitting
Design Hit Counter
Add Two Numbers II
Longest Substring with At Most K Distinct Characters
Minimum Moves to Equal Array Elements
Delete Node in a BST

84. Largest Rectangle in Histogram
85. Maximal Rectangle
223. Rectangle Area
302. Smallest Rectangle Enclosing Black Pixels
363. Max Sum of Rectangle No Larger Than K
391. Perfect Rectangle

Internet (What happens when you type URL)
Tower of Hanoi
