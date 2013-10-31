package sorting;

//  SortAlgorithm - rearrange an indexed collection into ascending order;
public interface SortAlgorithm<T extends Comparable> {

  void sort(T[] data, int size);

  /**
   * Method returns array of counters: in position [0] it is number of
   * comparisons, in position [1] - number of accesses, in position [2] - time
   * taken by this algorithm
   *
   * @return array of counted values
   */
  Long[] getCounter();
}
