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
    final double CONVERT_VALUE = 1000;

    Integer[] testDataOrig = new Integer[100000];
    int size = 0;
    try {
      size = readDataFile(testDataOrig);
    } catch (Exception ex) {
    }
    Integer[] testData;
    Long[] counter;

//    SortAlgorithm<Integer> sa = new InsertionSort<>();
//    SortAlgorithm<Integer> sa = new MergeSort<>();
//    SortAlgorithm<Integer> sa = new MergeSortMod<>();
//    SortAlgorithm<Integer> sa = new QuickSort<>();
//    SortAlgorithm<Integer> sa = new SelectionSort<>();
//    SortAlgorithm<Integer> sa = new ShellSort<>();
//    SortAlgorithm<Integer> sa = new ShellSortKnuth<>();

//    sa.sort(testData, size);
//    Long[] counter = sa.getCounter();

//    System.out.println("" + sa.getClass().toString() + "\n"
//            + "\tcomparisons:\t" + counter[0] + "\n"
//            + "\taccesses:\t" + counter[1] + "\n"
//            + "\ttime:\t\t" + (counter[2] / convertValue) + " s\n");

    { //part A
      testData = testDataOrig.clone();
      ShellSortKnuth<Integer> shk = new ShellSortKnuth<>();

      shk.sort(testData, size);

      counter = shk.getCounter();
      System.out.println("Part A:");
      System.out.println("" + shk.getClass().toString() + "\n"
              + "\tcomparisons:\t" + counter[0] + "\n"
              + "\taccesses:\t" + counter[1] + "\n"
              + "\ttime:\t\t" + (counter[2] / CONVERT_VALUE) + " s\n");
    }

    { //part B
      testData = testDataOrig.clone();
      MergeSortMod2<Integer> msm2 = new MergeSortMod2<>();

      msm2.sort(testData, size);

      counter = msm2.getCounter();
      System.out.println("Part B:");
      System.out.println("" + msm2.getClass().toString() + "\n"
              + "\tcomparisons:\t" + counter[0] + "\n"
              + "\taccesses:\t" + counter[1] + "\n"
              + "\ttime:\t\t" + (counter[2] / CONVERT_VALUE) + " s\n");
    }

    { //part C
      double[] percentiles = {0, 50, 80, 90, 100};
      for (int i = 0; i < percentiles.length; i++) {
        testData = testDataOrig.clone();
        QuickSort<Integer> qs = new QuickSort<>();

        Integer item = qs.percentileSearch(testData, size, percentiles[i]);

        counter = qs.getCounter();
        System.out.println("Part C:");
        System.out.println("" + percentiles[i] + "th percentile: " + item);
        System.out.println("" + qs.getClass().toString() + "\n"
                + "\tcomparisons:\t" + counter[0] + "\n"
                + "\taccesses:\t" + counter[1] + "\n"
                + "\ttime:\t\t" + (counter[2] / CONVERT_VALUE) + " s\n");
      }
    }
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
