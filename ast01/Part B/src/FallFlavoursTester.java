
import java.util.Scanner;

/**
 *
 * @author qlonik
 */
public class FallFlavoursTester {

  private Scanner kb;
  private FallFlavours ff;

  public FallFlavoursTester(String filePath) {
    ff = new FallFlavours(filePath);
    kb = new Scanner(System.in);
  }

  public void addItem() {
    System.out.print("Write name for event (use \"qzx\" to quit add manager): ");
    String name = kb.nextLine();
    if (!name.equals("qzx")) {
      System.out.print("Write date for event: ");
      String date = kb.nextLine();

      FallEvent[] allEvents = ff.listAllEvents();
      int i = 0;
      boolean exists = false;

      while (i < allEvents.length && !exists) {
        if (allEvents[i].getName().equals(name)
                && allEvents[i].getDate().equals(date)) {
          exists = true;
        }
        i++;
      }

      if (exists) {
        System.out.println("This element already exists. Adding was cancelled");
      } else {
        FallEvent newFallEvent = new FallEvent();
        ff.addEvent(newFallEvent);
        System.out.println("New event was added");
      }
    }
  }

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

  public void showHelp() {
    System.out.println("Use \"a\" to start new element manager");
    System.out.println("Use \"d\" to start deletion manager");
    System.out.println("Use \"q\" to quit program");
    System.out.println("Use \"h\" to print this help");
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    FallFlavoursTester fft = new FallFlavoursTester("fallEvents.txt");
    String userInput;
    Scanner kb = new Scanner(System.in);

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