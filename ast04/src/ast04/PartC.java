package ast04;

import java.util.Scanner;
import sorting.QuickSort;

/**
 *
 * @author qlonik
 */
public class PartC {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Integer[] testDataOrig = new Integer[100000];
    int size = 0;
    try {
      size = PartAB.readDataFile(testDataOrig);
    } catch (Exception ex) {
    }

    Scanner kb = new Scanner(System.in);
    Integer[] testData;
    boolean convert;

    { //part C
      System.out.println("Part C:\n");
      double[] percentiles = {0, 50, 80, 90, 100};
      for (int i = 0; i < percentiles.length; i++) {
        testData = testDataOrig.clone();
        searchPercentile(testData, size, percentiles[i]);
      }
    }

    do {
      System.out.print("Do you want to find other percentiles? [y/N] ");
      String input = kb.nextLine();

      if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
        convert = true;
      } else {
        convert = false;
      }

      if (convert) {
        boolean validParse;
        double percentile = 0;
        testData = testDataOrig.clone();

        do {
          try {
            System.out.print("Type percentile number: ");
            input = kb.nextLine();
            percentile = Double.parseDouble(input);
            validParse = true;
          } catch (NumberFormatException ex) {
            System.out.println("Wrong input. Try again.");
            validParse = false;
          }
        } while (!validParse);

        searchPercentile(testData, size, percentile);
      }
    } while (convert);

  }

  public static void searchPercentile(Integer[] testData, int size, double percentile) {
    final double CONVERT_VALUE = 1000;
    Long[] counter;
    QuickSort<Integer> qs = new QuickSort<>();

    Integer item = qs.percentileSearch(testData, size, percentile);

    counter = qs.getCounter();
    System.out.println("" + percentile + "th\t: " + item
            + " .. time: " + (counter[2] / CONVERT_VALUE) + " s\n");
//    System.out.println("" + qs.getClass().toString() + "\n"
//            + "\tcomparisons:\t" + counter[0] + "\n"
//            + "\taccesses:\t" + counter[1] + "\n"
//            + "\ttime:\t\t" + (counter[2] / CONVERT_VALUE) + " s\n");
  }
}
