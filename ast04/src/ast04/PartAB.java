package ast04;

import sorting.*;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;

/*
 * PartAB.java    Nikita Volodin
 * CS261,         Assignment 4
 * 
 * Class answers parts A and B of assignment. It sorts array using modified
 * Shell Sort and modified Merge Sort
 */
public class PartAB {

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

    { //part A
      testData = testDataOrig.clone();
      ShellSortKnuth<Integer> shk = new ShellSortKnuth<>();

      shk.sort(testData, size);

      counter = shk.getCounter();
      System.out.println("Part A:");
      System.out.println("" + shk.getClass().toString());
      print(testData);
      System.out.println("\tcomparisons:\t" + counter[0] + "\n"
              + "\taccesses:\t" + counter[1] + "\n"
              + "\ttime:\t\t" + (counter[2] / CONVERT_VALUE) + " s\n");
    }

    { //part B
      testData = testDataOrig.clone();
      MergeSortMod2<Integer> msm2 = new MergeSortMod2<>();

      msm2.sort(testData, size);

      counter = msm2.getCounter();
      System.out.println("Part B:");
      System.out.println("" + msm2.getClass().toString());
      print(testData);
      System.out.println("\tcomparisons:\t" + counter[0] + "\n"
              + "\taccesses:\t" + counter[1] + "\n"
              + "\ttime:\t\t" + (counter[2] / CONVERT_VALUE) + " s\n");
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
