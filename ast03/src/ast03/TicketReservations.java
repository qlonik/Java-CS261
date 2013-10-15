package ast03;

import collection.*;
import collection.exceptions.*;
import java.util.ArrayList;

/**
 *
 * @author qlonik
 */
public class TicketReservations {

  private final int BUS_CAPACITY = 40;
  private OrderedCollection<Ticket> collection;
  private Queue<Ticket> queue;

  public TicketReservations() {
    collection = new OrderedCollection<>();
    queue = new Queue<>();
  }

  /**
   * Method updates queue. It moves tickets from queue to reservation collection
   * if there is space available
   */
  public void updateQueue() {
    while (collection.size() < BUS_CAPACITY) {
      collection.add(queue.dequeue());
    }
  }

  /**
   * Method reserves new ticket into reservation list if possible and returns
   * TRUE. If it is not possible to add into reservation list, method adds new
   * ticket into queue and returns FALSE.
   *
   * @param ticket new ticket to reserve
   * @return TRUE if reservation was added. FALSE if reservation was added into
   * queue
   */
  public boolean addReservation(Ticket ticket) {
    boolean result = true;
    if (collection.size() < BUS_CAPACITY) {
      collection.add(ticket);
    } else {
      queue.enqueue(ticket);
      result = false;
    }
    return result;
  }
  
  /**
   * Method adds ticket into queue
   * @param ticket ticket that being added
   */
  public void addToQueue(Ticket ticket) {
    queue.enqueue(ticket);
  }

  /**
   * Method removes reservation for a ticket from ordered collection and updates
   * queue, so next ticket in queue get its place in ordered collection
   *
   * @param ticket ticket to be removed
   * @throws EmptyCollectionException if collection is empty
   * @throws ElementNotFoundException if element was not found in the ordered
   * collection
   */
  public void deleteReservation(Ticket ticket)
          throws EmptyCollectionException, ElementNotFoundException {
    collection.remove(ticket);
    updateQueue();
  }

  /**
   * Search in name (last + first) of the ticket reservation
   *
   * @param queryName exact or partial name to search for
   * @return list of all tickets found
   */
  public ArrayList<Ticket> query(String queryName) {
    ArrayList<Ticket> tickets = new ArrayList<>();


    for (Node<Ticket> current = collection.getHead(); current != null;
            current = current.getNext()) {
      Ticket currTicket = current.getElement();
      if (currTicket.getName().contains(queryName)) {
        tickets.add(currTicket);
      }
    }

    return tickets;
  }

  public String getReservationsList() {
    return "" + collection;
  }
  
  public String getQueueList() {
    return "" + queue;
  }
}
