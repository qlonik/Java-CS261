
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
                vault.add(vault.size(), element);
            }
        }
    }
}
