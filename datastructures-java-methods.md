##### *Arrays:*
- `static int	binarySearch(int[] a, int key)`
  - Searches the specified array of ints for the specified value using the binary search algorithm.

- `static int	binarySearch(int[] a, int fromIndex, int toIndex, int key)`
  - Searches a range of the specified array of ints for the specified value using the binary search algorithm.

- `static <T> int	binarySearch(T[] a, int fromIndex, int toIndex, T key, Comparator<? super T> c)`
  - Searches a range of the specified array for the specified object using the binary search algorithm.

- `static <T> int	binarySearch(T[] a, T key, Comparator<? super T> c)`
  - Searches the specified array for the specified object using the binary search algorithm.

- `static int[]	copyOf(int[] original, int newLength)
  - Copies the specified array, truncating or padding with zeros (if necessary) so the copy has the specified length.

- `static int[]	copyOfRange(int[] original, int from, int to)`
  - Copies the specified range of the specified array into a new array.

- `static boolean	equals(int[] a, int[] a2)
  - Returns true if the two specified arrays of ints are equal to one another.

- `static void	fill(int[] a, int val)`
  - Assigns the specified int value to each element of the specified array of ints.

- `static void	fill(int[] a, int fromIndex, int toIndex, int val)
  - Assigns the specified int value to each element of the specified range of the specified array of ints.

- `static void	sort(int[] a)`
  - Sorts the specified array into ascending numerical order.

- `static void	sort(int[] a, int fromIndex, int toIndex)
  - Sorts the specified range of the array into ascending order.

- `static String	toString(int[] a)`
  - Returns a string representation of the contents of the specified array.

##### *ArrayList:*
- `boolean	add(E e)`
  - Appends the specified element to the end of this list.

- `void	add(int index, E element)`
  - Inserts the specified element at the specified position in this list.

- `boolean	addAll(Collection<? extends E> c)`
  - Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.

- `boolean	addAll(int index, Collection<? extends E> c)`
  - Inserts all of the elements in the specified collection into this list, starting at the specified position.

- `void	clear()`
  - Removes all of the elements from this list.

- `Object	clone()`
  - Returns a shallow copy of this ArrayList instance.

- `boolean	contains(Object o)`
  - Returns true if this list contains the specified element.

- `void	ensureCapacity(int minCapacity)`
  - Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.

- `E	get(int index)`
  - Returns the element at the specified position in this list.

- `int	indexOf(Object o)`
  - Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.

- `boolean	isEmpty()`
  - Returns true if this list contains no elements.

- `Iterator<E>	iterator()`
  - Returns an iterator over the elements in this list in proper sequence.

- `int	lastIndexOf(Object o)`
  - Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element.

- `ListIterator<E>	listIterator()`
  - Returns a list iterator over the elements in this list (in proper sequence).

- `ListIterator<E>	listIterator(int index)`
  - Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list.

- `E	remove(int index)`
  - Removes the element at the specified position in this list.

- `boolean	remove(Object o)`
  - Removes the first occurrence of the specified element from this list, if it is present.

- `boolean	removeAll(Collection<?> c)`
  - Removes from this list all of its elements that are contained in the specified collection.

- `protected void	removeRange(int fromIndex, int toIndex)`
  - Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive.

- `boolean	retainAll(Collection<?> c)`
  - Retains only the elements in this list that are contained in the specified collection.

- `E	set(int index, E element)`
  - Replaces the element at the specified position in this list with the specified element.

- `int	size()`
  - Returns the number of elements in this list.

- `List<E>	subList(int fromIndex, int toIndex)`
  - Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.

- `Object[]	toArray()`
  - Returns an array containing all of the elements in this list in proper sequence (from first to last element).

- `<T> T[]	toArray(T[] a)`
  - Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.

- `void	trimToSize()`
  - Trims the capacity of this ArrayList instance to be the list's current size.

##### *Strings:*


##### *StringBuffer:*


##### *StringBuilder:*


##### *LinkedList:*


##### *Hashset:*


##### *Hashmap:*


##### *Hashtable:*


##### *Dictionary:*


##### *Stack:*


##### *Queue:*


##### *Heaps/Priority queue:*


##### *Tree:*


##### *Trie:*


##### *Graph:*


##### *Bloom Filter:*
