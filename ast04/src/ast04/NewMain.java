package ast04;

import java.util.ArrayList;
import java.util.Random;
import sorting.*;

/**
 *
 * @author qlonik
 */
public class NewMain {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
//    double convertor = Math.pow(10, 9);
    double convertor = Math.pow(10, 3);

    long seed = 123L;
    int len = (int) 50000;
    int iterations = 500;

    Integer[] data = new Integer[len];
    Random rnd = new Random();
    ArrayList<SortAlgorithm<Integer>> sa = new ArrayList<>();
//    SortAlgorithm<Integer> sa = new InsertionSort<>();
//    SortAlgorithm<Integer> sa = new SelectionSort<>();
    sa.add((SortAlgorithm<Integer>) new QuickSort<>());
    sa.add((SortAlgorithm<Integer>) new MergeSort<>());
    sa.add((SortAlgorithm<Integer>) new MergeSortMod<>());
    sa.add((SortAlgorithm<Integer>) new MergeSortMod2<>());
    sa.add((SortAlgorithm<Integer>) new ShellSort<>());
    sa.add((SortAlgorithm<Integer>) new ShellSortKnuth<>());


    for (int k = 0; k < sa.size(); k++) {
//    for (int k = 0; k < 1; k++) {
      long sum = 0L;
      String type = "";

      for (int j = 0; j < iterations; j++) {
        for (int i = 0; i < len; i++) {
          int rndNum = 300000 + rnd.nextInt(500000);
          data[i] = rndNum;
        }

        SortAlgorithm<Integer> sorter = sa.get(k);
        sorter.sort(data, len);
        Long[] counter = sorter.getCounter();
        sum += counter[2];
        type = "" + sorter.getClass();

//      print(data);
//      System.out.println("" + sa.getClass() + "\n"
//              + "\tcomparisons:\t" + counter[0] + "\n"
//              + "\taccesses:\t" + counter[1] + "\n"
//              + "\ttime:\t\t" + (counter[2] / convertor) + " s\n");
      }

      System.out.println(type);
      System.out.println("Mean of " + iterations + " runs: ");
      System.out.println("\t" + (sum / convertor / iterations));
      System.out.println();
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
