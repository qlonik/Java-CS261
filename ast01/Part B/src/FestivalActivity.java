
import java.text.NumberFormat;

/**
 * @author qlonik
 *
 * Class models information for a festival activity
 */
public class FestivalActivity implements Comparable<FestivalActivity> {

    private final double EPSILON = 0.0000001;
    private String name, description;
    private char category;
    private double admissionFee;
    
    public FestivalActivity() {
        name = "";
        description = "";
        category = ' ';
        admissionFee = 0;
    }

    public FestivalActivity(String name, String description, char category, double admissionFee) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.admissionFee = admissionFee;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public char getCategory() {
        return category;
    }

    public double getAdmissionFee() {
        return admissionFee;
    }

    @Override
    public int compareTo(FestivalActivity fa) {
        return name.compareTo(fa.getName());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj.getClass() == new FestivalActivity().getClass()) {
            FestivalActivity fa = (FestivalActivity) obj;

            if (name.equals(fa.getName())
                    && description.equals(fa.getDescription())
                    && category == fa.getCategory()
                    && Math.abs(admissionFee - fa.getAdmissionFee()) < EPSILON) {
                result = true;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        result += "Event: " + name + " (" + description + ") - " + category
                + "; admission: " + fmt.format(admissionFee);
        
        return result;
    }
}
