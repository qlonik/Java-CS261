package sorting;

public class InsertionSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

  private Long[] counter;

  @Override
  public void sort(T[] theArray, int size) {
    counter = new Long[]{0L, 0L, 0L};
    System.gc();
    Long startTime = System.currentTimeMillis();

    //------------------------------------------------------------------------
    // Sorts the specified array of objects using an insertion sort algorithm.
    //------------------------------------------------------------------------

    for (int unsorted = 1; unsorted < size; ++unsorted) {
      T nextItem = theArray[unsorted];
      counter[1]++;
      int loc = unsorted;

      /*  Shift larger values to the right */
      while (loc > 0 && theArray[loc - 1].compareTo(nextItem) > 0) {
        counter[0]++;
        theArray[loc] = theArray[loc - 1];
        counter[1]++;
        loc--;
      }
      if (loc > 0) {
        //cover case when this condition is true, but comparison is false
        //previously we missed one more comparison
        counter[0]++;
      }

      theArray[loc] = nextItem;
      counter[1]++;
    }

    Long endTime = System.currentTimeMillis();
    counter[2] = endTime - startTime;
  }   // method insertionSort

  public Long[] getCounter() {
    return counter;
  }
} // class SelectionSort