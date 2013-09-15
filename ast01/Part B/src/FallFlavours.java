
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author qlonik
 */
public class FallFlavours {

  private ListArrayBased vault;

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

  public FallEvent[] listAllEvents() {
    FallEvent[] result = new FallEvent[vault.size()];

    for (int i = 0; i < vault.size(); i++) {
      result[i] = (FallEvent) vault.get(i);
    }

    return result;
  }

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

  public boolean deleteEvent(int eventNumI) {
    boolean result = false;

    try {
      vault.remove(eventNumI);
      result = true;
    } catch (ListIndexOutOfBoundsException ex) {
    }

    return result;
  }

  @Override
  public String toString() {
    String result = "";

    for (int i = 0; i < vault.size(); i++) {
      result += vault.get(i) + "\n\n";
    }

    return result;
  }
}
