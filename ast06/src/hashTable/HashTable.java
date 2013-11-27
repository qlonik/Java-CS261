package hashTable;

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
public class HashTable<KT, V> implements HashTableADT<KT, V> {

  protected ChainNode<KT, V>[] table;     // hash table
  protected int size = 0;          // size of ADT table
  protected int counter = 0;       // number of probes to get item

  public HashTable() {
  }  // end default constructor

  //  Creates an empty hash table using the specified capacity
  //-----------------------------------------------------------------
  public HashTable(int capacity) {
    table = new ChainNode[capacity];  // note delete <KT, V>
    size = capacity;

    for (int i = 0; i < capacity; i++) {
      table[i] = null;
    }
  } // constructor

  // table operations
  @Override
  public boolean tableIsEmpty() {
    return size == 0;
  }  // end tableIsEmpty

  @Override
  public int tableLength() {
    return size;
  }  // end tableLength

// Implement the following methods.
  @Override
  public void tableInsert(KT key, V value) throws HashException {
    throw new UnsupportedOperationException("Not supported yet.");
  }  // end tableInsert

  @Override
  public boolean tableDelete(KT searchKey) {
    throw new UnsupportedOperationException("Not supported yet.");
  }  // end tableDelete

  @Override
  public V tableRetrieve(KT searchKey) {
    throw new UnsupportedOperationException("Not supported yet.");
  } // end tableRetrieve

  //------------------------------------------------------------------
  //  	Returns true if this hash table contains the specified element.
  //------------------------------------------------------------------
  @Override
  public boolean contains(KT key) {
    V item = tableRetrieve(key);
    return item != null;
  }

  @Override
  public int hashIndex(KT key) {
    return key.hashCode() % size;
  }  // end hashIndex

  @Override
  public int getCounter() {
    return counter;
  }
}  // end HashTable