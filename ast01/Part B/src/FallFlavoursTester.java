
import java.util.Scanner;

/*
 * Student: Nikita Volodin    id: 127196
 * Assignment #1 - Part B     CS261
 * 
 * Class tests FallFlavours class
 */
public class FallFlavoursTester {

  private Scanner kb;
  private FallFlavours ff;

  /**
   * Constructor for tester
   *
   * @param filePath String path for file with FallEvents
   */
  public FallFlavoursTester(String filePath) {
    ff = new FallFlavours(filePath);
    kb = new Scanner(System.in);
  }

  /**
   * Asks user to add new FallEvent into vault
   */
  public void addItem() {
    System.out.print("Write name for event (use \"qzx\" to quit add manager): ");
    String name = kb.nextLine();
    if (!name.equals("qzx")) {
      System.out.print("Write date for event: ");
      String date = kb.nextLine();

      if (ff.exist(name, date)) {
        System.out.println("This element already exists. Adding was cancelled");
      } else {
        int eventNum = -1;
        boolean done = false;
        System.out.print("Type in event number: ");

        while (!done) {
          String eventNumString = kb.nextLine();
          try {
            eventNum = Integer.parseInt(eventNumString);
            done = true;
          } catch (Exception exception) {
            System.out.print("Wrong number. Try again: ");
          }
        }

        System.out.print("Type in region: ");
        String region = kb.nextLine();
        System.out.print("Type in location: ");
        String location = kb.nextLine();
        System.out.print("Type in description: ");
        String description = kb.nextLine();
        System.out.print("Type in category (only one letter): ");
        char category = kb.nextLine().toUpperCase().charAt(0);

        double admissionFee = -1;
        done = false;
        System.out.print("Type in event admission fee: ");

        while (!done) {
          String eventNumString = kb.nextLine();
          try {
            admissionFee = Double.parseDouble(eventNumString);
            done = true;
          } catch (Exception exception) {
            System.out.print("Wrong number. Try again: ");
          }
        }

        FallEvent newFallEvent = new FallEvent(eventNum, date, region, location,
                name, description, category, admissionFee);
        ff.addEvent(newFallEvent);
        System.out.println("New event was added");
      }
    }
  }

  /**
   * Asks user to delete FallEvent from vault
   */
  public void deleteItem() {
    int eventNum = 0;
    boolean done = false;

    do {
      System.out.print("Write event number (use \"-1\" to cancel deletion): ");
      String eventNumString = kb.nextLine();
      try {
        eventNum = Integer.parseInt(eventNumString);
        done = true;
      } catch (NumberFormatException ex) {
        System.out.println("Wrong number. Try again.");
      }
    } while (!done && (eventNum != -1));

    if (eventNum != -1) {
      ff.deleteEvent(eventNum);
      System.out.println("Deleted event #" + eventNum);
    } else {
      System.out.println("Nothing deleted");
    }
  }

  /**
   * Shows help for user
   */
  public void showHelp() {
    System.out.println("Use \"a\" to start new element manager");
    System.out.println("Use \"d\" to start deletion manager");
    System.out.println("Use \"p\" to print schedule");
    System.out.println("Use \"q\" to quit program");
    System.out.println("Use \"h\" to print this help");
  }

  public void print() {
    System.out.println(ff);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    FallFlavoursTester fft = new FallFlavoursTester("fallEvents_new.txt");
    String userInput;
    Scanner kb = new Scanner(System.in);

    fft.showHelp();
    System.out.print("Enter command (q for quit, h for help): ");
    userInput = kb.nextLine();

    while (!userInput.equals("q")) {
      switch (userInput) {
        case "a":
          fft.addItem();
          break;
        case "d":
          fft.deleteItem();
          break;
        case "p":
          fft.print();
        case "h":
        default:
          fft.showHelp();
          break;
      }

      System.out.print("Enter command (q for quit, h for help): ");
      userInput = kb.nextLine();
    }
  }
}