
import hashTable.HashTableADT;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author qlonik
 */
public class Testing {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ItemForRent[] equipmentData = new ItemForRent[100000];
    int sizeEquipmentData = 0;
    ItemForRent[] verifyData = new ItemForRent[100000];
    int sizeVerifyData = 0;
    try {
      sizeEquipmentData = readDataFile(equipmentData, "equipment.bin");
      sizeVerifyData = readDataFile(verifyData, "verifyID.bin");
    } catch (Exception ex) {
    }

    final double loadFactor75 = 0.75;
    final double loadFactor90 = 0.90;
    final double loadFactor50 = 0.50;

    int capacity_75 = getCapacity(sizeEquipmentData, loadFactor75);
    int capacity_90 = getCapacity(sizeEquipmentData, loadFactor90);
    int capacity_50 = getCapacity(sizeEquipmentData, loadFactor50);

    OpenLinearHashTable<Integer, ItemForRent> lt_75 = new OpenLinearHashTable<>(capacity_75),
            lt_90 = new OpenLinearHashTable<>(capacity_90);
    OpenDoubleHashTable<Integer, ItemForRent> dt_75 = new OpenDoubleHashTable<>(capacity_75),
            dt_90 = new OpenDoubleHashTable<>(capacity_90);
    OpenQuadraticHashTable<Integer, ItemForRent> qt_75 = new OpenQuadraticHashTable<>(capacity_75),
            qt_90 = new OpenQuadraticHashTable<>(capacity_90);
    ChainedHashTable<Integer, ItemForRent> ct_75 = new ChainedHashTable<>(capacity_75),
            ct_90 = new ChainedHashTable<>(capacity_90),
            ct_50 = new ChainedHashTable<>(capacity_50);

    fillTable(lt_75, equipmentData, sizeEquipmentData);
    fillTable(lt_90, equipmentData, sizeEquipmentData);
    fillTable(dt_75, equipmentData, sizeEquipmentData);
    fillTable(dt_90, equipmentData, sizeEquipmentData);
    fillTable(qt_75, equipmentData, sizeEquipmentData);
    fillTable(qt_90, equipmentData, sizeEquipmentData);
    fillTable(ct_75, equipmentData, sizeEquipmentData);
    fillTable(ct_90, equipmentData, sizeEquipmentData);
    fillTable(ct_50, equipmentData, sizeEquipmentData);

    System.out.println("Number of items in Equipment: " + sizeEquipmentData);
    System.out.println("Number of items to verify: " + sizeVerifyData);

    printResults(lt_75, verifyData, sizeVerifyData, loadFactor75);
    printResults(lt_90, verifyData, sizeVerifyData, loadFactor90);
    printResults(dt_75, verifyData, sizeVerifyData, loadFactor75);
    printResults(dt_90, verifyData, sizeVerifyData, loadFactor90);
    printResults(qt_75, verifyData, sizeVerifyData, loadFactor75);
    printResults(qt_90, verifyData, sizeVerifyData, loadFactor90);
    printResults(ct_75, verifyData, sizeVerifyData, loadFactor75);
    printResults(ct_90, verifyData, sizeVerifyData, loadFactor90);
    printResults(ct_50, verifyData, sizeVerifyData, loadFactor50);
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
//      System.out.println("\nEnd-of-File >> Contains " + howMany + " items\n");
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

  public static int getCapacity(int size, double loadFactor) {
    int capacity = (int) Math.ceil(size / loadFactor);
    while (!isPrime(capacity)) {
      capacity++;
    }
    return capacity;
  }

  public static void fillTable(HashTableADT<Integer, ItemForRent> table,
          ItemForRent[] data, int dataSize) {
    for (int i = 0; i < dataSize; i++) {
      ItemForRent item = data[i];
      table.tableInsert(item.getKey(), item);
    }
  }

  public static ArrayList<ArrayList<Integer>> checkTable(HashTableADT<Integer, ItemForRent> table,
          ItemForRent[] verifyData, int sizeVerifyData) {
    ArrayList<Integer> sucProbes = new ArrayList<>(),
            unsucProbes = new ArrayList<>();

    for (int i = 0; i < sizeVerifyData; i++) {
      ItemForRent item = table.tableRetrieve(verifyData[i].getKey());
      if (item == null) {
        unsucProbes.add(table.getCounter());
      } else {
        sucProbes.add(table.getCounter());
      }
    }
    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
    out.add(sucProbes);
    out.add(unsucProbes);
    return out;
  }

  public static int summation(ArrayList<Integer> list) {
    int out = 0;
    for (int i = 0; i < list.size(); i++) {
      out += list.get(i);
    }
    return out;
  }

  public static int max(ArrayList<Integer> list) {
    int out = list.get(0);
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) > out) {
        out = list.get(i);
      }
    }
    return out;
  }

  public static void printResults(HashTableADT<Integer, ItemForRent> table,
          ItemForRent[] verifyData, int sizeVerifyData, double factor) {
    DecimalFormat fmt = new DecimalFormat("#.00");
    ArrayList<ArrayList<Integer>> results = checkTable(table, verifyData, sizeVerifyData);
    ArrayList<Integer> sucProbes = results.get(0);
    ArrayList<Integer> unsucProbes = results.get(1);
    System.out.println("*****************************************************");
    System.out.println(table.getClass() + " with load factor " + factor);
    System.out.println("Amount of successful searches: " + sucProbes.size());
    System.out.println("Average number of probes among successful searches: "
            + fmt.format(((double) summation(sucProbes) / (double) sucProbes.size())));
    System.out.println("Maximum number of probes among successful searches: "
            + max(sucProbes));
    System.out.println("");
    System.out.println("Amount of unsuccessful searches: " + unsucProbes.size());
    System.out.println("Average number of probes among unsuccessful searches: "
            + fmt.format(((double) summation(unsucProbes) / (double) unsucProbes.size())));
    System.out.println("Maximum number of probes among unsuccessful searches: "
            + max(unsucProbes));
    System.out.println("*****************************************************");
    System.out.println("");
  }
}
