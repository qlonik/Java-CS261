
import java.text.NumberFormat;

/*
 * Student: Nikita Volodin    id: 127196
 * Assignment #1 - Part B     CS261
 * 
 * Class models information for a festival activity
 */
public class FestivalActivity implements Comparable<FestivalActivity> {

  private final double EPSILON = 0.0000001;
  private String name, description;
  private char category;
  private double admissionFee;

  /**
   * Empty constructor for FestivalActivity object
   */
  public FestivalActivity() {
    name = "";
    description = "";
    category = ' ';
    admissionFee = 0;
  }

  /**
   * Constructor for object FestivalActivity
   *
   * @param name Name of activity
   * @param description Description of activity
   * @param category Category of activity
   * @param admissionFee Fee for activity
   */
  public FestivalActivity(String name, String description,
          char category, double admissionFee) {
    this.name = name;
    this.description = description;
    this.category = category;
    this.admissionFee = admissionFee;
  }

  /**
   * Returns name of the current FestivalActivity
   *
   * @return String representation of activity name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns description of the current FestivalActivity
   *
   * @return String representation of description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Returns category of the current FestivalActivity
   *
   * @return character representation of category
   */
  public char getCategory() {
    return category;
  }

  /**
   * Returns admission fee for the current FestivalActivity
   *
   * @return double representation of admission
   */
  public double getAdmissionFee() {
    return admissionFee;
  }

  /**
   * Compares two FestivalActivities by their name
   *
   * @param fa FestivalActivity that is being compared to
   * @return int value of difference between names
   */
  @Override
  public int compareTo(FestivalActivity fa) {
    return name.compareTo(fa.getName());
  }

  /**
   * Compares if two FestivalActivity object are the same by comparing all the
   * fields of both objects
   *
   * @param obj Object that is being compared to
   * @return TRUE if objects are same
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;

    if (this.getClass() == obj.getClass()) {
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

  /**
   * Return String of Festival Activity
   *
   * @return String representation of FestivalActivity object
   */
  @Override
  public String toString() {
    String result = "";
    NumberFormat fmt = NumberFormat.getCurrencyInstance();

    result += "Event: " + name + "; Category: " + category + "; Fee: "
            + fmt.format(admissionFee) + "\n" + description;

    return result;
  }
}
