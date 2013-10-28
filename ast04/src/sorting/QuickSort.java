package sorting;

public class QuickSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {
  // Sorts the specified array into ascending order using the quick sort algorithm.

  protected T[] theArray;
  private Long[] counter;

  public void sort(T[] dataArray, int size) {
    theArray = dataArray;
    counter = new Long[]{0L, 0L, 0L};
    System.gc();
    Long startTime = System.currentTimeMillis();

    quickSort(0, size - 1);

    Long endTime = System.currentTimeMillis();
    counter[2] = endTime - startTime;
  }

  public T percentileSearch(T[] dataArray, int size, int percentile) {
    theArray = dataArray;
    counter = new Long[]{0L, 0L, 0L};
    Integer position = percentile * size / 100;
    System.gc();
    Long startTime = System.currentTimeMillis();

    T item = quickSortForPercentile(0, size - 1, position);

    Long endTime = System.currentTimeMillis();
    counter[2] = endTime - startTime;

    return item;
  }

  //  *********   Use recursion to partition and sort   *************
  private void quickSort(int first, int last) {
    int pivotIndex;
    if (first < last) // At least one item
    {
      pivotIndex = partition(first, last);  	// Create partitions
      quickSort(first, pivotIndex - 1);       // Sort the left side
      quickSort(pivotIndex + 1, last);       	// Sort the right side
    }
  } // method quickSort

  private T quickSortForPercentile(int first, int last, int position) {
    int pivotIndex;
    if (first < last) // At least one item
    {
      pivotIndex = partition(first, last);  	// Create partitions
      quickSort(first, pivotIndex - 1);       // Sort the left side
      quickSort(pivotIndex + 1, last);       	// Sort the right side
    }
    return null;
  }

  /**
   * ******************************************************************
   * Used by the quick sort algorithm to find the partition.
   * ******************************************************************
   */
  private int partition(int first, int last) {
    T pivot = theArray[first];      // use first element as pivot
    //increase access counter
    counter[1]++;

    // initially, everything but pivot is in "unknown"
    int lastS1 = first;          // index of last item in S1

    // move one item at a time until unknown region is empty
    // firstUnknown is the index of first item in unknown region
    for (int firstUnknown = first + 1; firstUnknown <= last; ++firstUnknown) {
      // Invariant: theArray[first+1..lastS1] < pivot
      //            theArray[lastS1+1..firstUnknown-1] >= pivot
      // move item from unknown to proper region
      //increase comparison counter
      counter[0]++;
      if (theArray[firstUnknown].compareTo(pivot) < 0) {
        // item from unknown belongs in S1
        ++lastS1;
        exchange(firstUnknown, lastS1);
      }  // end if
      // else item from unknown belongs in S2
    }  // end for

    exchange(first, lastS1);        // Move partition element to pivot index

    return lastS1;
  } // method partition

  private void exchange(int first, int second) {
    T tempItem = theArray[first];
    theArray[first] = theArray[second];
    theArray[second] = tempItem;
    counter[1] += 3;
  }

  public Long[] getCounter() {
    return counter;
  }
} // class Quicksort
