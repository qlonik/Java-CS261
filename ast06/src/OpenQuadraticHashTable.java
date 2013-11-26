
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
public class OpenQuadraticHashTable<
              KT extends Comparable<? super KT>, T extends KeyedItem<KT>>
        extends OpenHashTable<KT, T>
        implements hashTable.HashTableADT<KT, T> {

  private int counter;

  public OpenQuadraticHashTable() {
  }

  public OpenQuadraticHashTable(int capacity) {
    super(capacity);
  }

  @Override
  public void tableInsert(KT key, T value) throws HashException {
    int hash = hashIndex(key);
    if (table[hash] == null) {
      table[hash] = value;
    } else {
      int i = 1;
      hash += 2 * i - 1;
      while (hash >= size) {
        hash -= size;
      }
      while (table[hash] != null) {
        i++;
        hash += 2 * i - 1;
        while (hash >= size) {
          hash -= size;
        }
      }
      table[hash] = value;

//        System.out.println(table[hash]);
    }
  }

  @Override
  public T tableRetrieve(KT searchKey) {
    counter = 0;
    int hash = hashIndex(searchKey);
    if (table[hash].getKey().equals(searchKey)) {
      counter++;
      return table[hash];
    } else {
      counter++;
      int i = 1;
      hash += 2 * i - 1;
      while (hash >= size) {
        hash -= size;
      }
      while (table[hash] != null && !table[hash].getKey().equals(searchKey)) {
        counter++;
        i++;
        hash += 2 * i - 1;
        while (hash >= size) {
          hash -= size;
        }
      }
      counter++;
      return table[hash];
    }
  }

  public void printToFile() {
    try {
      FileWriter fw = new FileWriter(new File("Quadratic_table_output.txt"));
      for (int i = 0; i < size; i++) {
        fw.write("" + table[i] + "\n");
      }
      fw.close();
    } catch (IOException exception) {
    }
  }

  public int getCounter() {
    return counter;
  }
}
