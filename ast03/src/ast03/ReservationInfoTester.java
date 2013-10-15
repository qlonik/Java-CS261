package ast03;

import collection.Ticket;
import collection.exceptions.ElementNotFoundException;
import collection.exceptions.EmptyCollectionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author qlonik
 */
public class ReservationInfoTester {

  private final String OUTPUT_FILE_PATH = "reservationsCurrent.txt";
  private TicketReservations collection;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException {
    JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
    File file = null;
    int status = chooser.showOpenDialog(null);
    if (status == JFileChooser.CANCEL_OPTION) {
      System.out.println("---> No Data File Chosen");
      System.exit(0);
    } else {
      file = chooser.getSelectedFile();
    }

    ReservationInfoTester rit = new ReservationInfoTester(file);
    Scanner kb = new Scanner(System.in);

    System.out.print("Type command for system "
            + "(\"q\" for quit, \"h\" for help)\n"
            + ">>> ");
    String userInput = kb.nextLine();

    while (!userInput.equalsIgnoreCase("q")) {
      switch (userInput.toLowerCase()) {
        case "n":
          rit.addReservation();
          break;
        case "d":
          rit.deleteReservation();
          break;
        case "s":
          rit.queryReservation();
          break;
        case "or":
          rit.showReservations();
          break;
        case "oq":
          rit.showQueue();
          break;
        default:
          System.out.println(rit.showHelp());
          break;
      }

      System.out.println("");
      System.out.print("Type command for system "
              + "(\"q\" for quit, \"h\" for help)\n"
              + ">>> ");
      userInput = kb.nextLine();
    }

    rit.writeToFile();
  }

  public ReservationInfoTester(File inputFile) throws FileNotFoundException {
    collection = new TicketReservations();
    parseFile(inputFile);
  }

  /**
   * Method parses file and creates collection of reservations and queue for
   * tickets
   *
   * @param inputFile file that is being parsed
   * @throws FileNotFoundException if file is not found
   */
  private void parseFile(File inputFile) throws FileNotFoundException {
    Scanner file = new Scanner(inputFile);

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
        if (membership != 0) {
          collection.addReservation(newTicket);
        } else {
          collection.addToQueue(newTicket);
        }
      }
    }

    collection.updateQueue();
  }

  /**
   * Method returns help string
   *
   * @return String with help for user
   */
  public String showHelp() {
    return "This is the help for reservation system.\n"
            + "Type \"n\" to start new ticket reservation manager.\n"
            + "Type \"d\" to start deletion manager.\n"
            + "Type \"s\" to search in reservations.\n"
            + "Type \"or\" to show reservations.\n"
            + "Type \"oq\" to show queue.\n"
            + "Type \"h\" to show this help.\n"
            + "Type \"q\" to exit program.";
  }

  public void showReservations() {
    System.out.println(collection.getReservationsList());
  }

  public void showQueue() {
    System.out.println(collection.getQueueList());
  }

  /**
   * Method asks user to enter last name, first name, membership and comment.
   * Then method adds ticket into reservations. Method reports to user result of
   * operation
   */
  public void addReservation() {
    Scanner kb = new Scanner(System.in);

    //ask user once to insert his last name, keep asking if he enters empty line
    String lastName = "";
    do {
      System.out.print("Type last name: ");
      lastName = kb.nextLine();
      if (lastName.equals("")) {
        System.out.println("You cannot type empty last name");
      }
    } while (lastName.equals(""));

    String firstName = "";
    do {
      System.out.print("Type first name: ");
      firstName = kb.nextLine();
      if (firstName.equals("")) {
        System.out.println("You cannot type empty first name");
      }
    } while (firstName.equals(""));

    int membership = 0;
    String membershipS;
    do {
      System.out.print("Type membership number: ");
      membershipS = kb.nextLine();
      try {
        membership = Integer.parseInt(membershipS);
      } catch (NumberFormatException ex) {
        System.out.println("Invalid membership number");
        membershipS = "";
      }
    } while (membershipS.equals(""));

    System.out.print("Type comment (ENTER to leave empty): ");
    String comment = kb.nextLine();

    Ticket ticket = new Ticket(lastName, firstName, membership, comment);
    ArrayList<Ticket> reservations = collection.query(ticket.getName());
    if (reservations.isEmpty()) {
      boolean addedToCollection = collection.addReservation(ticket);
      if (addedToCollection) {
        System.out.println("Ticket was successfully reserved");
      } else {
        System.out.println("Ticket was successfully added into queue");
      }
    } else {
      System.out.println("Ticket was not added since this name already exists");
    }
  }

  /**
   * Method asks user last name and first name. Then it deletes ticket with
   * these parameters and reports to user result of operation
   */
  public void deleteReservation() {
    Scanner kb = new Scanner(System.in);

    String lastName = "";
    do {
      System.out.print("Type last name: ");
      lastName = kb.nextLine();
      if (lastName.equals("")) {
        System.out.println("You cannot type empty last name");
      }
    } while (lastName.equals(""));

    String firstName = "";
    do {
      System.out.print("Type first name: ");
      firstName = kb.nextLine();
      if (firstName.equals("")) {
        System.out.println("You cannot type empty first name");
      }
    } while (firstName.equals(""));

    int membership = 0;
    String comment = "";
    boolean result = false;
    Ticket ticket = new Ticket(lastName, firstName, membership, comment);

    try {
      collection.deleteReservation(ticket);
      result = true;
    } catch (ElementNotFoundException | EmptyCollectionException ex) {
    }

    if (result) {
      System.out.println("Ticket was deleted successfully");
    } else {
      System.out.println("Ticket was not deleted");
    }
  }

  /**
   * Method asks user to input search string. Then it searches for this string
   * among reservations. It reports result of operation to user
   */
  public void queryReservation() {
    Scanner kb = new Scanner(System.in);

    String queryString = "";
    do {
      System.out.print("Type search string: ");
      queryString = kb.nextLine();
      if (queryString.equals("")) {
        System.out.println("You cannot search empty string");
      }
    } while (queryString.equals(""));

    ArrayList<Ticket> tickets = collection.query(queryString);

    if (!tickets.isEmpty()) {
      System.out.println("Found tickets: ");
      for (int i = 0; i < tickets.size(); i++) {
        System.out.println(tickets.get(i));
      }
    } else {
      System.out.println("Not found.");
    }
  }

  /**
   * Method writes all updated reservations and current queue into file.
   * @throws FileNotFoundException 
   */
  public void writeToFile() throws FileNotFoundException {
    File outputFile = new File(OUTPUT_FILE_PATH);
    if (outputFile.exists()) {
      outputFile.delete();
    }
    PrintWriter pw = new PrintWriter(outputFile);

    pw.println("Reservations: ");
    pw.println(collection.getReservationsList());
    pw.println();
    pw.println("Queue: ");
    pw.println(collection.getQueueList());
    
    pw.close();
  }
}
