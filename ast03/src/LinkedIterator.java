
import java.util.Iterator;
import java.util.NoSuchElementException;

//****************************************************************
//  LinkedIterator.java       			    Authors: Lewis/Chase
//
//  Represents an iterator for a linked list of linear nodes.
//****************************************************************
public class LinkedIterator<T> implements Iterator<T> {

  private int count;  	// the number of elements
  private Node<T> current;  	// the current position

  //  Constructor
  public LinkedIterator(Node<T> collection, int size) {
    current = collection;
    count = size;
  }

  //************************************************************
  //  Returns true if this iterator has at least one more element
  //  to deliver in the iteration.
  public boolean hasNext() {
    return (current != null);
  }

  //************************************************************
  //  Returns the next element in the iteration.
  //      If there are no  more elements in this iteration,
  //      a NoSuchElementException isthrown.
  public T next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }

    T result = current.getElement();
    current = current.getNext();
    return result;
  }

  //************************************************************
  //  The remove operation is not supported.
  public void remove() throws UnsupportedOperationException {
    throw new UnsupportedOperationException();
  }
}  // class LinkedIterator
