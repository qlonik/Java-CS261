package sorting;

//  SortAlgorithm - rearrange an indexed collection into ascending order;
public interface SortAlgorithm<T extends Comparable> {

  void sort(T[] data, int size);

  Long[] getCounter();
}
