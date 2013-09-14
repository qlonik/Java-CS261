
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author qlonik
 */
public class FallFlavours {

  private ListArrayBased vault;

  public FallFlavours() {
    Scanner file = null;
    try {
      file = new Scanner(new File("fallEvents.txt"));
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
}
