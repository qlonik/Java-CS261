package sorting;

public class MergeSortMod<T extends Comparable<? super T>> implements SortAlgorithm<T> {

  //****   Sorts the specified array of objects using the merge sort algorithm.
  protected T[] theArray;
  private Long[] counter;
  SelectionSort<T> ss;

  public MergeSortMod() {
    this.ss = new SelectionSort<>();
  }

  public void sort(T[] dataArray, int size) {
    counter = new Long[]{0L, 0L, 0L};
    theArray = dataArray;
    System.gc();
    Long startTime = System.currentTimeMillis();

    mergeSort(0, size - 1);

    Long endTime = System.currentTimeMillis();
    counter[2] = endTime - startTime;
  }  // method sort

  private void mergeSort(int first, int last) {
    if (first < last) // at least two elements.
    {
      int mid = (first + last) / 2;		// midpoint of the list

      if (mid - first + 1 <= 20) {
        ss.sortRange(theArray, first, mid);
      } else {
        mergeSort(first, mid); 			// sort left half of list
      }
      if (last - mid + 1 <= 20) {
        ss.sortRange(theArray, mid, last);
      } else {
        mergeSort(mid + 1, last); 		// sort right half of list
      }
      
//      if (last - first + 1 <= 20) {
//        ss.sortRange(theArray, first, mid);
//      } else {
//        mergeSort(first, mid); 			// sort left half of list
//        mergeSort(mid + 1, last); 		// sort right half of list
//      }

      merge(first, mid, last);			// merge the sorted sublists
    }
  } // method mergeSort

  private void merge(int first, int mid, int last) {
    int size = last - first + 1;		// find the length of the list

    T[] tempArray = (T[]) (new Comparable[size]);   // create temporary storage

    // copy sorted sublists into workspace
    // 	theArray[first]..theArray[mid] is first;
    //	theArray[mid+1]..theArray[last] is second.

    for (int index = 0; index < size; index++) {
      tempArray[index] = theArray[first + index];
      counter[1]++;
    }

    // merge the two sorted lists.

    int left = 0;
    int right = mid + 1 - first;		// "mid" is on left sublist

    for (int index = 0; index < size; index++) {
      if (right <= size - 1) // right side is non-empty 
      {
        if (left <= (size - 1) / 2) // left side is non-empty
        {
          counter[0]++;
          if (tempArray[left].compareTo(tempArray[right]) > 0) {
            theArray[index + first] = tempArray[right++];    // right is smaller
            counter[1]++;
          } else {
            theArray[index + first] = tempArray[left++];    // left is smaller
            counter[1]++;
          }
        } else {
          theArray[index + first] = tempArray[right++];  // left is empty; copy right
          counter[1]++;
        }
      } else {
        theArray[index + first] = tempArray[left++];    // right is empty; copy left
        counter[1]++;
      }
    } // for

  } // method merge

  public Long[] getCounter() {
    return counter;
  }
} // class MergeSort