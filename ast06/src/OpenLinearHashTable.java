
import hashTable.HashException;
import hashTable.KeyedItem;
import hashTable.OpenHashTable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author qlonik
 */
public class OpenLinearHashTable<
              KT extends Comparable<? super KT>, T extends KeyedItem<KT>>
        extends OpenHashTable<KT, T>
        implements hashTable.HashTableADT<KT, T> {

  public OpenLinearHashTable() {
  }

  public OpenLinearHashTable(int capacity) {
    super(capacity);
  }

  @Override
  public void tableInsert(KT key, T value) throws HashException {
//    super.tableInsert(key, value);
    int hash = hashIndex(key);
    while (table[hash] != null) {
      hash += 1;
      while (hash >= size) {
        hash -= size;
      }
    }
    table[hash] = value;
  }

  @Override
  public T tableRetrieve(KT searchKey) {
//    return super.tableRetrieve(searchKey);
    int hash = hashIndex(searchKey);
    if (table[hash] == null) {
      return null;
    }
    int hashOrig = hash;
    while (table[hash] != null && !table[hash].getKey().equals(searchKey)) {
      hash += 1;
      while (hash >= size) {
        hash -= size;
      }
    }
    return table[hash];
  }

  public void printToFile() {
    try {
      FileWriter fw = new FileWriter(new File("Linear_table_output.txt"));
      for (int i = 0; i < size; i++) {
        fw.write("" + table[i] + "\n");
      }
      fw.close();
    } catch (IOException exception) {
    }
  }
}