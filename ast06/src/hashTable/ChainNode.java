package hashTable;

//***********************************************************************
//  ChainNode.java                	Authors: Prichard & Carrano
//
//  	Represents a node in a linked structure.
//		Chained node has two fields: key + value
//***********************************************************************
class ChainNode<K, V> {

  private K key;
  private V value;
  ChainNode<K, V> next;

  //  Creates a node storing the key and its asspcaiated value
  //----------------------------------------------------------------
  public ChainNode(K newKey, V newValue) {
    key = newKey;
    value = newValue;
    next = null;
  }  // end constructor

  //   Creates a node storing the specified items and next reference
  //----------------------------------------------------------------
  public ChainNode(K newKey, V newValue, ChainNode<K, V> nextNode) {
    key = newKey;
    value = newValue;
    next = nextNode;
  }  // end constructor

  //  Returns the value associated with the key
  //----------------------------------------------------------------
  public V getValue() {
    return value;
  }  // end getValue

  //  Returns the key
  //----------------------------------------------------------------
  public K getKey() {
    return key;
  }  // end getKey
} // end ChainNode