//*************************************************************************
//  HashTable.java                			Authors: Prichard & Carrano
//							Implemented By:
//
// Assumption:
//	A table contains at most one item with a given search key at any time.
//
// Note: This code will compile with a warning about the use of unchecked
//	 or unsafe operations. This is due to the cast in method tableRetrieve.
//	 Exercise X asks you to rewrite this implementation using ArrayList
//	 to avoid this warning.
//*************************************************************************

// package hashTable;
public class HashTable<KT, V> implements HashTableADT<KT, V> {

  public /* final */ int HASH_TABLE_SIZE = 101;
  private ChainNode[] table;     // hash table
  private int size = 0;          // size of ADT table

  public HashTable() {
    table = new ChainNode[HASH_TABLE_SIZE];
  }  // end default constructor

  //  Creates an empty hash table using the specified capacity
  //-----------------------------------------------------------------
  public HashTable(int capacity) {
    table = new ChainNode[capacity];  // note delete <KT, V>

    for (int i = 0; i < capacity; i++) {
      table[i] = null;
    }
  } // constructor

  // table operations
  public boolean tableIsEmpty() {
    return size == 0;
  }  // end tableIsEmpty

  public int tableLength() {
    return size;
  }  // end tableLength

// Implement the following methods.
  public void tableInsert(KT key, V value)
          throws HashException {
    // ...
  }  // end tableInsert

  public boolean tableDelete(KT searchKey) {

    // ...
    return true;  // added for compilation
  }  // end tableDelete

  public V tableRetrieve(KT searchKey) {
    // ...
    return null;  // added for compilation
  } // end tableRetrieve

  //------------------------------------------------------------------
  //  	Returns true if this hash table contains the specified element.
  //------------------------------------------------------------------
  public boolean contains(KT key) {
    //	...
    return false;	// added for compilation
  }

  public int hashIndex(KT key) {
    // ...
    return key.hashCode();
  }  // end hashIndex
}  // end HashTable