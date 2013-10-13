package collection;

import collection.exceptions.EmptyCollectionException;

/**
 *
 * @author qlonik
 */
public class Queue<T> implements QueueInterface<T> {

  ListReferenceBased queue;

  public Queue() {
    queue = new ListReferenceBased();
  }

  @Override
  public void enqueue(T element) {
    queue.add(queue.size(), element);
  }

  @Override
  public T dequeue() throws EmptyCollectionException {
    T element = peek();
    queue.remove(0);
    return element;
  }

  @Override
  public void dequeueAll() {
    queue.removeAll();
  }

  @Override
  public T peek() throws EmptyCollectionException {
    if (queue.isEmpty()) {
      throw new EmptyCollectionException("Queue");
    }

    return (T) queue.get(0);
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public int size() {
    return queue.size();
  }
}
