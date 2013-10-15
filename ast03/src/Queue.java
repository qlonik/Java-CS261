
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
