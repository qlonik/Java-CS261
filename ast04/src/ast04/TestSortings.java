package ast04;

import java.util.ArrayList;
import sorting.*;

/**
 *
 * @author qlonik
 */
public class TestSortings {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    double convertor = 1000;
    Integer[] testData;

    Integer[] testDataOrig = new Integer[100000];
    int size = 0;
    try {
      size = PartAB.readDataFile(testDataOrig);
    } catch (Exception ex) {
    }

    ArrayList<SortAlgorithm<Integer>> sa = new ArrayList<>();
    sa.add((SortAlgorithm<Integer>) new SelectionSort<>());
    sa.add((SortAlgorithm<Integer>) new InsertionSort<>());
    sa.add((SortAlgorithm<Integer>) new QuickSort<>());
    sa.add((SortAlgorithm<Integer>) new MergeSort<>());
    sa.add((SortAlgorithm<Integer>) new MergeSortMod<>());
    sa.add((SortAlgorithm<Integer>) new MergeSortMod2<>());
    sa.add((SortAlgorithm<Integer>) new ShellSort<>());
    sa.add((SortAlgorithm<Integer>) new ShellSortKnuth<>());

    for (int k = 0; k < sa.size(); k++) {
      testData = testDataOrig.clone();
      SortAlgorithm<Integer> sorter = sa.get(k);

      sorter.sort(testData, size);

      Long[] counter = sorter.getCounter();
      System.out.println("" + sorter.getClass() + "\n"
              + "\tcomparisons:\t" + counter[0] + "\n"
              + "\taccesses:\t" + counter[1] + "\n"
              + "\ttime:\t\t" + (counter[2] / convertor) + " s\n");
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
}
