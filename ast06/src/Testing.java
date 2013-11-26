
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 * @author qlonik
 */
public class Testing {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ItemForRent[] testDataOrig = new ItemForRent[10000];
    int size = 0;
    try {
      size = readDataFile(testDataOrig, "equipment.bin");
    } catch (Exception ex) {
    }
    System.out.println("out");
    for (int i = 0; i < 10; i++) {
      System.out.println(testDataOrig[i]);
    }
    System.out.println("");

    double loadFactor;
    int capacity;

    loadFactor = 0.75;
    capacity = (int) Math.ceil(size / loadFactor);
    while (!isPrime(capacity)) {
      capacity++;
    }
    OpenLinearHashTable<Integer, ItemForRent> lt = new OpenLinearHashTable<>(capacity);
    for (int i = 0; i < size; i++) {
      ItemForRent item = testDataOrig[i];
      lt.tableInsert(item.getKey(), item);
    }
//    lt.printToFile();
    System.out.println("retrieve linear");
    System.out.println(lt.tableRetrieve(218818));
    System.out.println(lt.tableRetrieve(445299));
    System.out.println("");

    loadFactor = 0.75;
    capacity = (int) Math.ceil(size / loadFactor);
    while (!isPrime(capacity)) {
      capacity++;
    }
    OpenDoubleHashTable<Integer, ItemForRent> dt = new OpenDoubleHashTable<>(capacity);
    for (int i = 0; i < size; i++) {
      ItemForRent item = testDataOrig[i];
      dt.tableInsert(item.getKey(), item);
    }
//    dt.printToFile();
    System.out.println("retrieve double");
    System.out.println(dt.tableRetrieve(218818));
    System.out.println(dt.tableRetrieve(445299));
    System.out.println("");

    loadFactor = 0.75;
    capacity = (int) Math.ceil(size / loadFactor);
    while (!isPrime(capacity)) {
      capacity++;
    }
    OpenQuadraticHashTable<Integer, ItemForRent> qt = new OpenQuadraticHashTable<>(capacity);
    for (int i = 0; i < size; i++) {
      ItemForRent item = testDataOrig[i];
      qt.tableInsert(item.getKey(), item);
    }
//    qt.printToFile();
    System.out.println("retrieve quadratic");
    System.out.println(qt.tableRetrieve(218818));
    System.out.println(qt.tableRetrieve(445299));
    System.out.println("");

    loadFactor = 0.75;
    capacity = (int) Math.ceil(size / loadFactor);
    while (!isPrime(capacity)) {
      capacity++;
    }
    ChainedHashTable<Integer, ItemForRent> ct = new ChainedHashTable<>(capacity);
    for (int i = 0; i < size; i++) {
      ItemForRent item = testDataOrig[i];
      ct.tableInsert(item.getKey(), item);
    }
//    qt.printToFile();
    System.out.println("retrieve quadratic");
    System.out.println(ct.tableRetrieve(218818));
    System.out.println(ct.tableRetrieve(445299));
    System.out.println("");
  }

  public static int readDataFile(ItemForRent[] testData, String filepath) throws Exception {
    DataInputStream dis = new DataInputStream(new FileInputStream(new File(filepath)));
    int howMany = 0;
    try {
      while (true) {
        int id = dis.readInt();
        testData[howMany++] = new ItemForRent(id);
      }
    } catch (EOFException eof) {
      System.out.println("\nEnd-of-File >> Contains " + howMany + " items\n");
    }
    return howMany;
  }

  public static boolean isPrime(int num) {
    if (num % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= num; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
