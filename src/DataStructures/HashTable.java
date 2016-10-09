//Collision resolving by separate chaining or linear probing. 
// Chaining - each slot of the array contains a link to a singly-linked list containing key-value pairs with the same hash.
// New key-value pairs are added to teh end of the list. Lookup algo. searches through the list to find the matching key. 
// List is being created when value with the certain hash is added for the first time. 
//Big o - constant for insert, removal, and lookup http://www.algolist.net/Data_structures/Hash_table/Chaining

//While, open addressing(like linear probing) doesnt waste memory space of storing the structure of linked list. All
//key-value pairs are stored in the hash table itself and no need of extra data structure. 
//http://www.algolist.net/Data_structures/Hash_table/Open_addressing

class HashEntry {
	private int key;
	private int value;

	HashEntry(int key, int value){
		this.key = key;
		this.value = value;
	}
	public int getKey(){
		return key;
	}
	public int getValue(){
		return value;
	}
}


public class HashTable {
	private final static int TABLE_SIZE = 128;

	HashEntry[] table;
	HashTable() {
		table = new HashEntry[TABLE_SIZE];
		for(int i = 0; i < TABLE_SIZE; i++){
			table[i] = null;
		}
	}

	//hash function that generates the hashing value based on the key as an input 
	public int get(int key){
		int hash = (key % TABLE_SIZE);
		while(table[hash] != null && table[hash].getKey() != key){
			hash = (hash + 1) % TABLE_SIZE;
		}
		if(table[hash] == null) return -1;
		else return table[hash].getValue();
	}

	public void put(int key, int value){
		int hash = (key % TABLE_SIZE);
		while(table[hash] != null && table[hash].getKey() != key){
			hash = (hash + 1) % TABLE_SIZE;
		}
		table[hash] = new HashEntry(key,value);
	}

}