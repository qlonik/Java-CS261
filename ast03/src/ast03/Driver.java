package ast03;

import collection.OrderedCollection;
import collection.Ticket;

/**
 *
 * @author qlonik
 */
public class Driver {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    OrderedCollection<Ticket> newOC = new OrderedCollection<>();
    newOC.add(new Ticket("b", "c", 3, ""));
    newOC.add(new Ticket("b", "c", 2, ""));
    newOC.add(new Ticket("b", "b", 2, "abc"));
    newOC.add(new Ticket("b", "b", 2, "abc"));
    newOC.add(new Ticket("a", "b", 1, ""));
    newOC.add(new Ticket("a", "b", 1, ""));
    newOC.add(new Ticket("b", "c", 2, ""));
    newOC.add(new Ticket("c", "c", 2, ""));
    
    System.out.println(newOC);
//    newOC.contains(new Ticket("b", "c", 3, ""));
  }
}
