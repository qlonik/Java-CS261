
import hashTable.HashException;
import hashTable.KeyedItem;
import hashTable.OpenHashTable;

/**
 *
 * @author qlonik
 */
public class OpenLinearHashTable<
              KT extends Comparable<? super KT>, 
              T extends KeyedItem<KT> & RandomStuffThatObjectMustDo
             > 
      extends OpenHashTable<KT, T> 
      implements hashTable.HashTableADT<KT, T> {

  public OpenLinearHashTable() {
  }

  public OpenLinearHashTable(int capacity) {
    super(capacity);
  }

  @Override
  public boolean tableIsEmpty() {
    return super.tableIsEmpty();
  }

  @Override
  public int tableLength() {
    return super.tableLength();
  }

  @Override
  public void tableInsert(KT key, T value) throws HashException {
//    super.tableInsert(key, value);
  }

  @Override
  public boolean tableDelete(KT searchKey) {
//    return super.tableDelete(searchKey);
    boolean result = false;
    T item = tableRetrieve(searchKey);
    if (item != null) {
      item.delete();
      result = true;
    }
    return result;
  }

  @Override
  public T tableRetrieve(KT searchKey) {
//    return super.tableRetrieve(searchKey);
  }

  @Override
  public boolean contains(KT key) {
//    return super.contains(key);
  }

  @Override
  public int hashIndex(KT key) {
    return super.hashIndex(key);
  }

  private void rehash() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public String toString() {
//    return super.toString();
  }
}
