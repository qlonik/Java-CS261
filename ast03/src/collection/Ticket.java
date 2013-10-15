package collection;

/**
 *
 * @author qlonik
 */
public class Ticket implements Comparable<Ticket> {

  private String lastName, firstName, comment;
  private int membership;

  public Ticket(String lastName, String firstName, int membership, String comment) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.comment = comment;
    this.membership = membership;
  }

  public String getName() {
    return lastName + " " + firstName;
  }

  public int getMembership() {
    return membership;
  }

  @Override
  public int compareTo(Ticket o) {
    return getName().compareTo(o.getName());
  }

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

  @Override
  public String toString() {
    return "Name: " + lastName + " " + firstName + ", membership #" + membership
            + (comment.equals("") ? "" : (" (" + comment + ")"));
  }
}
