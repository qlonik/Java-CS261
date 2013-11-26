
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
    Integer[] testDataOrig = new Integer[10000];
    int size = 0;
    try {
      size = readDataFile(testDataOrig);
    } catch (Exception ex) {
    }
  }

  public static int readDataFile(Integer[] testData) throws Exception {
    DataInputStream dis = new DataInputStream(new FileInputStream(new File("equipment.bin")));
    int howMany = 0;
    try {
      while (true) {
        int id = dis.readInt();
        testData[howMany++] = new Integer(id);
      }
    } catch (EOFException eof) {
      System.out.println("\nEnd-of-File >> Contains " + howMany + " items\n");
    }
    return howMany;
  }
}
