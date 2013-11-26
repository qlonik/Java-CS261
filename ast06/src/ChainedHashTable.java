
import hashTable.HashException;
import hashTable.HashTable;
import hashTable.HashTableADT;
import hashTable.ChainNode;

/**
 *
 * @author qlonik
 */
public class ChainedHashTable<KT, V> extends HashTable<KT, V>
        implements HashTableADT<KT, V> {

  public ChainedHashTable() {
  }

  public ChainedHashTable(int capacity) {
    super(capacity);
  }

  @Override
  public void tableInsert(KT key, V value) throws HashException {
//    if (contains(key)) {
//      throw new HashException("Duplicate item.");
//    }
    int hash = hashIndex(key);
    table[hash] = new ChainNode(key, value, table[hash]);
  }

  @Override
  public V tableRetrieve(KT searchKey) {
    int hash = hashIndex(searchKey);
    ChainNode<KT, V> node = table[hash];
    while (node != null) {
      if (node.getKey().equals(searchKey)) {
        return node.getValue();
      }
      node = node.next;
    }
    return null;
  }
}
