package dataStructures;
/**
 * Generic interface for hash tables.
 *
 */
public interface Hashtable {
    /**
     * Adds a value to the hash table.
     *
     * @param value The value to add.
     */
    public void add(Object value);

    /**
     * Determines if the hash table contains a specified value.
     *
     * @param value The value for which to search.
     * @return <code>true</code> if the value is found; otherwise <code>false</code>.
     */
    public boolean contains(Object value);

    /**
     * Obtains the number of values in the hash table.
     *
     * @return The number of value sin the hash table.
     */
    public int size();
}
