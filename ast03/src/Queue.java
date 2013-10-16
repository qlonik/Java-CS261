
/*
 * Queue.java       Author: Nikita Volodin (127196)
 * CS261, Assignment 3
 * 
 * Class represents Queue ADT
 */
public class Queue<T> implements QueueInterface<T> {

  ListReferenceBased queue;

  public Queue() {
    queue = new ListReferenceBased();
  }

  /**
   * Enqueue new element
   *
   * @param element element that is being enqueued
   */
  @Override
  public void enqueue(T element) {
    queue.add(queue.size(), element);
  }

  /**
   * Dequeue element
   *
   * @return dequeued element
   * @throws EmptyCollectionException if queue is empty
   */
  @Override
  public T dequeue() throws EmptyCollectionException {
    T element = peek();
    queue.remove(0);
    return element;
  }

  /**
   * Delete all list
   */
  @Override
  public void dequeueAll() {
    queue.removeAll();
  }

  /**
   * Peek on next element in queue
   *
   * @return element that is peeked
   * @throws EmptyCollectionException if collection is empty
   */
  @Override
  public T peek() throws EmptyCollectionException {
    if (queue.isEmpty()) {
      throw new EmptyCollectionException("Queue");
    }

    return (T) queue.get(0);
  }

  /**
   *
   * @return TRUE if collection is empty
   */
  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  /**
   *
   * @return size of the queue
   */
  @Override
  public int size() {
    return queue.size();
  }

  /**
   *
   * @return String representation of queue
   */
  @Override
  public String toString() {
    String result = "";

    for (int i = 0; i < queue.size(); i++) {
      result += "" + (T) queue.get(i) + "\n";
    }

    result = result.substring(0, result.lastIndexOf("\n"));
    return result;
  }
}
