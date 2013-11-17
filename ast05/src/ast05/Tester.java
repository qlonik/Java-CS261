package ast05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

  public void showHelp() {
    System.out.println("A: ADD a new Member;\n" + "D: DELETE a Member;\n"
            + "F: FIND a Member;\n" + "H: HELP;\n" + "P: Probing efficiency;\n"
            + "R: REPORT on membership;\n" + "S: SPONSORSHIP query;\n"
            + "U: UPDATE a Member;\n" + "Q: QUIT;");
  }

  public void add(Scanner kb) {
    System.out.print("Type first name: ");
    String firstName = kb.nextLine();
    System.out.print("Type last name: ");
    String lastName = kb.nextLine();

    Member member = list.find(Member.createKey(lastName, firstName));
    if (member == null) {

      System.out.print("Type amount donated: ");
      double donated = Double.parseDouble(kb.nextLine());
      System.out.print("Type membership year: ");
      int membershipYear = Integer.parseInt(kb.nextLine());

      list.add(new Member(firstName, lastName, donated, membershipYear));
      System.out.println("New member successfully added.");
    } else {
      System.out.println("Member already exist. Cancel addition...");
    }
  }

  public void delete(Scanner kb) {
    System.out.print("Type first name: ");
    String firstName = kb.nextLine();
    System.out.print("Type last name: ");
    String lastName = kb.nextLine();

    boolean result = list.delete(Member.createKey(lastName, firstName));
    if (result) {
      System.out.println("Successfully deleted.");
    } else {
      System.out.println("Member not found. Cancel deletion...");
    }
  }

  public void find(Scanner kb) {
    System.out.print("Type first name: ");
    String firstName = kb.nextLine();
    System.out.print("Type last name: ");
    String lastName = kb.nextLine();

    Member found = list.find(Member.createKey(lastName, firstName));
    if (found != null) {
      System.out.println(found.toString());
    } else {
      System.out.println("Member is not found...");
    }
  }

  public void sponsorhip(Scanner kb) {
    System.out.print("Type query: ");
    String input = kb.nextLine();
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
    System.out.print("Type first name: ");
    String firstName = kb.nextLine();
    System.out.print("Type last name: ");
    String lastName = kb.nextLine();

    Member updateMember = list.find(Member.createKey(lastName, firstName));
    if (updateMember != null) {
      System.out.print("Type updated donated amount: ");
      double donated = Double.parseDouble(kb.nextLine());

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
