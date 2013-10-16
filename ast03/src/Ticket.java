
/*
 * Ticket.java    Author: Nikita Volodin (127196)
 * CS261, Assignment 3
 * 
 * Class represents ticket in the system
 */
public class Ticket implements Comparable<Ticket> {

  private String lastName, firstName, comment;
  private int membership;

  /**
   * Creates new ticket with specified parameters
   *
   * @param lastName Last Name of person who ordering ticket
   * @param firstName First Name of person
   * @param membership Membership number
   * @param comment Comment for the ticket
   */
  public Ticket(String lastName, String firstName, int membership, String comment) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.comment = comment;
    this.membership = membership;
  }

  /**
   * Method returns full name of ticket holder
   *
   * @return Name of ticket holder
   */
  public String getName() {
    return lastName + " " + firstName;
  }

  /**
   * Method returns membership number of ticket holder
   *
   * @return int membership number
   */
  public int getMembership() {
    return membership;
  }

  /**
   * Method returns result of comparison of two Tickets
   *
   * @param o ticket that method compare with
   * @return difference between Tickets
   */
  @Override
  public int compareTo(Ticket o) {
    return getName().compareTo(o.getName());
  }

  /**
   * Method compares current object with other object
   *
   * @param obj Object method compare with
   * @return TRUE if two objects are the same
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;

    if (this.getClass() == obj.getClass()) {
      if (getName().equals(((Ticket) obj).getName())) {
        result = true;
      }
    }

    return result;
  }

  /**
   * Method returns String representation of Ticket
   *
   * @return String representation
   */
  @Override
  public String toString() {
    return "Name: " + lastName + " " + firstName + ", membership #" + membership
            + (comment.equals("") ? "" : (" (" + comment + ")"));
  }
}
