package ast03;

import collection.*;
import collection.exceptions.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author qlonik
 */
public class TicketReservations {

  private final int BUS_CAPACITY = 40;
  private OrderedCollection<Ticket> collection;
  private Queue<Ticket> queue;

  public TicketReservations(String filepathString) throws FileNotFoundException {
    collection = new OrderedCollection<>();
    queue = new Queue<>();
    parseFile(filepathString);
    boolean value = true;
  }

  private void parseFile(String filepath) throws FileNotFoundException {
    Scanner file = new Scanner(new File(filepath));

    while (file.hasNext()) {
      String readLine = file.nextLine().trim();
      if (!readLine.equals("")) {
        Scanner line = new Scanner(readLine);
        line.useDelimiter(" +");
        String lastName, firstName, membershipS, comment;
        lastName = line.next();
        firstName = line.next();
        membershipS = line.next();
        if (line.hasNext()) {
          comment = line.nextLine().trim();
        } else {
          comment = "";
        }
        int membership = Integer.parseInt(membershipS);

        Ticket newTicket = new Ticket(lastName, firstName, membership, comment);
        if (collection.size() < BUS_CAPACITY && membership != 0) {
          collection.add(newTicket);
        } else {
          queue.enqueue(newTicket);
        }
      }
    }

    updateQueue();
  }

  private void updateQueue() {
    while (collection.size() < BUS_CAPACITY) {
      collection.add(queue.dequeue());
    }
  }

  public void addReservation(Ticket ticket) {
    if (collection.size() < BUS_CAPACITY) {
      collection.add(ticket);
    } else {
      queue.enqueue(ticket);
    }
  }

  public void deleteReservation(Ticket ticket)
          throws EmptyCollectionException, ElementNotFoundException {
    collection.remove(ticket);
    updateQueue();
  }

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
}
