package hashTable;

//***********************************************************************
//  KeyedItem.java                	Authors: Prichard & Carrano
//
//
//  Represents an Item with a "key" field
//	The key is used when searching for an item in a collection
//***********************************************************************
public abstract class KeyedItem<KT extends Comparable<? super KT>> {

  private KT searchKey;

  public KeyedItem(KT key) {
    searchKey = key;
  }  // end constructor

  public KT getKey() {
    return searchKey;
  } // end getKey
} // end KeyedItem
