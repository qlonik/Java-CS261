package ast04;

import sorting.*;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

public class Driver {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    double convertValue = 1000;

    Integer[] testData = new Integer[100000];
    int size = 0;
    try {
      size = readDataFile(testData);
    } catch (Exception ex) {
    }


//    SortAlgorithm<Integer> sa = new InsertionSort<>();
//    SortAlgorithm<Integer> sa = new MergeSort<>();
//    SortAlgorithm<Integer> sa = new MergeSortMod<>();
    SortAlgorithm<Integer> sa = new QuickSort<>();
//    SortAlgorithm<Integer> sa = new SelectionSort<>();
//    SortAlgorithm<Integer> sa = new ShellSort<>();
//    SortAlgorithm<Integer> sa = new ShellSortKnuth<>();

    sa.sort(testData, size);
    Long[] counter = sa.getCounter();

    System.out.println("" + sa.getClass().toString() + "\n"
            + "\tcomparisons:\t" + counter[0] + "\n"
            + "\taccesses:\t" + counter[1] + "\n"
            + "\ttime:\t\t" + (counter[2] / convertValue) + " s\n");
  }

  public static void print(Integer[] arr) {
    for (int i = 0; i < 300; i++) {
      System.out.print(arr[i] + " ");
      if (i % 10 == 9) {
        System.out.println();
      }
    }
    System.out.println();
  }

  public static int readDataFile(Integer[] testData) throws Exception {
    DataInputStream dis = new DataInputStream(new FileInputStream(new File("Ast04.bin")));
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
