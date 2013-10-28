package sorting;

public class ShellSortKnuth<T extends Comparable<? super T>>
        implements SortAlgorithm<T> {

  private Long[] counter;

  @Override
  public void sort(T[] dataArray, int n) {
    counter = new Long[]{0L, 0L, 0L};
    int loc;
    T nextItem;
    System.gc();
    Long startTime = System.currentTimeMillis();

    int k = (int) Math.floor(Math.log(2 * n + 1) / Math.log(3));
    int startingGap = (int) (Math.pow(3, k) - 1) / 2;
    for (int gap = startingGap; gap > 0; gap = gap / 3) {
      for (int unsorted = gap; unsorted < n; ++unsorted) {
        nextItem = dataArray[unsorted];
        counter[1]++;
        loc = unsorted;

        while ((loc >= gap) && (dataArray[loc - gap].compareTo(nextItem) > 0)) {
          counter[0]++;
          dataArray[loc] = dataArray[loc - gap];
          counter[1]++;
          loc = loc - gap;
        }
        if (loc >= gap) {
          //cover case when this condition is true, but comparison is false
          //previously we missed one more comparison
          counter[0]++;
        }
        dataArray[loc] = nextItem;
      }
    }

    Long endTime = System.currentTimeMillis();
    counter[2] = endTime - startTime;
  }

  @Override
  public Long[] getCounter() {
    return counter;
  }
}
