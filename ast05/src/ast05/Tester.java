package ast05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author qlonik
 */
public class Tester {

  private MembershipList list;
  private final String PATHNAME = "confederationCentre.txt";

  public Tester() throws FileNotFoundException {
    File file = new File(PATHNAME);
    Scanner input = new Scanner(file);
    list = new MembershipList(input);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException, IOException {
    Tester t = new Tester();

    Scanner kb = new Scanner(System.in);
    System.out.println("Type command (q to quit, h for help): ");
    System.out.print(">>> ");
    String userInput = kb.nextLine();


    while (!userInput.equalsIgnoreCase("q")) {
      switch (userInput.toLowerCase()) {
        case "a":
          t.add(kb);
          break;
        case "d":
          t.delete(kb);
          break;
        case "f":
          t.find(kb);
          break;
        case "h":
          t.showHelp();
          break;
        case "p":
          t.probe();
          break;
        case "r":
          t.report();
          break;
        case "s":
          t.sponsorhip(kb);
          break;
        case "u":
          t.update(kb);
          break;
        case "q":
          System.exit(0);
          break;
        default:
          System.out.println("Invalid command or missing key. Try again.");
          break;
      }

      System.out.println("Type command (q to quit, h for help): ");
      System.out.print(">>> ");
      userInput = kb.nextLine();
    }
  }

  private String getFirstName(Scanner kb) {
    System.out.print("Type first name: ");
    String firstName = kb.nextLine().trim();

    while (firstName.equals("")) {
      System.out.print("First name cannot be empty. Try again: ");
      firstName = kb.nextLine().trim();
    }

    return firstName;
  }

  private String getLastName(Scanner kb) {
    System.out.print("Type last name: ");
    String lastName = kb.nextLine().trim();

    while (lastName.equals("")) {
      System.out.print("Last name cannot be empty. Try again: ");
      lastName = kb.nextLine().trim();
    }

    return lastName;
  }

  private double getDonated(Scanner kb, String msg) {
    System.out.print(msg);
    double donated = 0;
    boolean done = false;
    while (!done) {
      try {
        donated = Double.parseDouble(kb.nextLine().trim());
        done = true;
      } catch (Exception e) {
        System.out.print("Wrong input data. Try again: ");
      }
    }
    return donated;
  }

  private int getYear(Scanner kb) {
    System.out.print("Type year joined: ");
    int year = 0;
    boolean done = false;
    while (!done) {
      try {
        year = Integer.parseInt(kb.nextLine().trim());
        done = true;
      } catch (Exception e) {
        System.out.print("Wrong input data. Try again: ");
      }
    }
    return year;
  }

  private String getQuery(Scanner kb) {
    System.out.print("Type query: ");
    String query = kb.nextLine().trim();

    while (query.equals("")) {
      System.out.print("Query cannot be empty. Try again: ");
      query = kb.nextLine().trim();
    }

    return query;
  }

  public void showHelp() {
    System.out.println("A: ADD a new Member;\n" + "D: DELETE a Member;\n"
            + "F: FIND a Member;\n" + "H: HELP;\n" + "P: Probing efficiency;\n"
            + "R: REPORT on membership;\n" + "S: SPONSORSHIP query;\n"
            + "U: UPDATE a Member;\n" + "Q: QUIT;");
  }

  public void add(Scanner kb) {
    String firstName = getFirstName(kb);
    String lastName = getLastName(kb);

    Member member = list.find(Member.createKey(lastName, firstName));
    if (member == null) {
      double donated = getDonated(kb, "Type amount donated: ");
      int membershipYear = getYear(kb);
      list.add(new Member(firstName, lastName, donated, membershipYear));
      System.out.println("New member successfully added.");
    } else {
      System.out.println("Member already exist. Cancel addition...");
    }
  }

  public void delete(Scanner kb) {
    String firstName = getFirstName(kb);
    String lastName = getLastName(kb);

    boolean result = list.delete(Member.createKey(lastName, firstName));
    if (result) {
      System.out.println("Successfully deleted.");
    } else {
      System.out.println("Member not found. Cancel deletion...");
    }
  }

  public void find(Scanner kb) {
    String firstName = getFirstName(kb);
    String lastName = getLastName(kb);

    Member found = list.find(Member.createKey(lastName, firstName));
    if (found != null) {
      System.out.println(found.toString());
    } else {
      System.out.println("Member is not found...");
    }
  }

  public void sponsorhip(Scanner kb) {
    String input = getQuery(kb);
    Iterator<Member> iterator = list.getInOrderIterator();

    int year = 0, count = 0;
    try {
      year = Integer.parseInt(input);
    } catch (Exception e) {
    }

    while (iterator.hasNext()) {
      Member item = iterator.next();
      if (year == 0 && item.getMembership().equals(input)) {
        System.out.println(item.toString());
        count++;
      }
      if (item.getMembershipYear() == year) {
        System.out.println(item.toString());
        count++;
      }
    }

    System.out.println("Here is " + count
            + (count == 1 ? " person" : " people"));
  }

  public void update(Scanner kb) {
    String firstName = getFirstName(kb);
    String lastName = getLastName(kb);

    Member updateMember = list.find(Member.createKey(lastName, firstName));
    if (updateMember != null) {
      double donated = getDonated(kb, "Type updated donated amount: ");
      list.update(updateMember, donated);
    } else {
      System.out.println("Member is not found. Cancelling update...");
    }
  }

  public void probe() {
    System.out.println("The height of the tree is: " + list.getHeight());
  }

  /**
   * Display corresponding member information (alphabetical order) the number of
   * members listed and total monies donated.
   *
   */
  public void report() {
    Iterator<Member> iterator = list.getInOrderIterator();
    double totalDonated = 0;
    int totalMembers = 0;

    while (iterator.hasNext()) {
      Member item = iterator.next();
      totalMembers++;
      totalDonated += item.getDonated();
      System.out.println(item.toString());
    }
    System.out.println("Donated $" + totalDonated + " by "
            + totalMembers + " members");
  }
}
