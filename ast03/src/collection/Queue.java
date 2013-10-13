package collection;

import collection.exceptions.EmptyCollectionException;

/**
 *
 * @author qlonik
 */
public class Queue<T> implements QueueInterface<T> {

  @Override
  public void enqueue(T element) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public T dequeue() throws EmptyCollectionException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void dequeueAll() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public T peek() throws EmptyCollectionException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean isEmpty() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public int size() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
