package sorting;

public class SelectionSort<T extends Comparable<? super T>> implements SortAlgorithm<T> {

  private Long[] counter;

  public void sort(T[] dataArray, int size) {
    counter = new Long[]{0L, 0L, 0L};
    System.gc();
    long startTime = System.currentTimeMillis();

    selectionSort(dataArray, 0, size - 1);

    Long endTime = System.currentTimeMillis();
    counter[2] = endTime - startTime;
  }

  public void sortRange(T[] dataArray, int begin, int end) {
    counter = new Long[]{0L, 0L, 0L};
    selectionSort(dataArray, begin, end);
  }

  private void selectionSort(T[] dataArray, int begin, int end) {
    for (int last = end; last > begin; last--) {
      int largest = begin;
      for (int currIndex = begin + 1; currIndex <= last; ++currIndex) {
        counter[0]++;
        if (dataArray[currIndex].compareTo(dataArray[largest]) > 0) {
          largest = currIndex;
        }
      }

      /* Swap the values */
      T temp = dataArray[largest];
      dataArray[largest] = dataArray[last];
      dataArray[last] = temp;
      counter[1] += 3;
    }
  }

  public Long[] getCounter() {
    return counter;
  }
}