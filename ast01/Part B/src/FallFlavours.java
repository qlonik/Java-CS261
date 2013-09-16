
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Student: Nikita Volodin    id: 127196
 * Assignment #1 - Part B     CS261
 * 
 * Class models all FallEvents in program
 */
public class FallFlavours {

  private ListArrayBased vault;

  /**
   * Constructor for FallFlavours object.
   *
   * @param filePath Path to file with all FallEvents
   */
  /*
   * Constructor creates vault object and stores there all FallEvents from file
   */
  public FallFlavours(String filePath) {
    Scanner file = null;
    try {
      file = new Scanner(new File(filePath));
    } catch (FileNotFoundException ex) {
      System.out.println("File not found. Place it near class files");
      System.err.println("File is missing");
    }

    vault = new ListArrayBased();

    while (file.hasNext()) {
      String line = file.nextLine().trim();
      if (!line.equals("")) {
        String[] firstLine = line.split(" +");
        String secondLine = file.nextLine();
        String[] thirdLine = file.nextLine().split(" +");

        int eventNumI = Integer.parseInt(firstLine[0]);
        double feeD = Double.parseDouble(firstLine[2]);
        char categoryC = firstLine[3].toUpperCase().charAt(0);

        FallEvent element = new FallEvent(eventNumI, thirdLine[0],
                thirdLine[1], thirdLine[2], firstLine[1],
                secondLine, categoryC, feeD);

        try {
          if (vault.get(eventNumI) != null) {
            vault.remove(eventNumI);
          }
        } catch (ListIndexOutOfBoundsException ex) {
        }
        vault.add(eventNumI, element);
      }
    }
  }

  /**
   * Search FallEvents by description
   *
   * @param toFindString String to search
   * @return String representation of all matching FallEvents
   */
  public String search(String toFindString) {
    String result = "";
    toFindString = toFindString.toLowerCase();

    for (int i = 0; i < vault.size(); i++) {
      FallEvent fe = (FallEvent) vault.get(i);
      String description = fe.getDescription().toLowerCase();
      if (description.indexOf(toFindString) != -1) {
        result += fe + "\n\n";
      }
    }

    return result;
  }

  /**
   * Search FallEvents by category
   *
   * @param toFindCharacter Character to find
   * @return String representation of all matching FallEvents
   */
  public String search(Character toFindCharacter) {
    String result = "";
    toFindCharacter = Character.toUpperCase(toFindCharacter);

    for (int i = 0; i < vault.size(); i++) {
      FallEvent fe = (FallEvent) vault.get(i);
      char category = fe.getCategory();
      if (category == toFindCharacter) {
        result += fe + "\n\n";
      }
    }

    return result;
  }

  /**
   * Method lists all Events
   *
   * @return Array representation of all FallEvents
   */
  public FallEvent[] listAllEvents() {
    FallEvent[] result = new FallEvent[vault.size()];

    for (int i = 0; i < vault.size(); i++) {
      result[i] = (FallEvent) vault.get(i);
    }

    return result;
  }

  /**
   * Adds new Event into vault
   *
   * @param fe FallEvent that is being added
   * @return TRUE if addition was successful
   */
  public boolean addEvent(FallEvent fe) {
    boolean result = false;

    try {
      int eventNumI = fe.getEventNum();
      deleteEvent(eventNumI);
      vault.add(eventNumI, fe);
      result = true;
    } catch (ListIndexOutOfBoundsException ex) {
    } catch (ListException ex) {
    }

    return result;
  }

  /**
   * Deletes Event from vault
   *
   * @param eventNumI Number of event to delete
   * @return TRUE if deletion was successful
   */
  public boolean deleteEvent(int eventNumI) {
    boolean result = false;

    try {
      vault.remove(eventNumI);
      result = true;
    } catch (ListIndexOutOfBoundsException ex) {
    }

    return result;
  }

  /**
   * String representation of all FallFlavours
   * 
   * @return String of all FallFlavours
   */
  @Override
  public String toString() {
    String result = "";

    for (int i = 0; i < vault.size(); i++) {
      result += vault.get(i) + "\n\n";
    }

    return result;
  }
}
