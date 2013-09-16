
import java.text.NumberFormat;

/*
 * Student: Nikita Volodin    id: 127196
 * Assignment #1 - Part B     CS261
 * 
 * Class models information for a fall event
 */
public class FallEvent extends FestivalActivity
        implements Comparable<FestivalActivity> {

  private int eventNum;
  private String date, region, location;

  /**
   * Empty constructor for FallEvent objects
   */
  public FallEvent() {
    super();
    eventNum = 0;
    date = "";
    region = "";
    location = "";
  }

  /**
   * FallEvent constructor
   *
   * @param eventNum Integer number of event
   * @param date String date of event
   * @param region Region of event
   * @param location Location of event
   */
  public FallEvent(int eventNum, String date, String region, String location) {
    this.eventNum = eventNum;
    this.date = date;
    this.region = region;
    this.location = location;
  }

  /**
   * FallEvent constructor
   *
   * @param name Name of event
   * @param description Description of event
   * @param category Category of event
   * @param admissionFee Admission Fee of event
   */
  public FallEvent(String name, String description,
          char category, double admissionFee) {
    super(name, description, category, admissionFee);
  }

  /**
   * FallEvent constructor
   *
   * @param eventNum Integer number of event
   * @param date String date of event
   * @param region Region of event
   * @param location Location of event
   * @param name Name of event
   * @param description Description of event
   * @param category Category of event
   * @param admissionFee Admission Fee of event
   */
  public FallEvent(int eventNum, String date, String region, String location,
          String name, String description, char category, double admissionFee) {
    super(name, description, category, admissionFee);
    this.eventNum = eventNum;
    this.date = date;
    this.region = region;
    this.location = location;
  }

  /**
   * Returns event number
   *
   * @return Integer representation of FallEvent
   */
  public int getEventNum() {
    return eventNum;
  }

  /**
   * Returns date of FallEvent
   *
   * @return String representation of date
   */
  public String getDate() {
    return date;
  }

  /**
   * Returns region of event
   *
   * @return String representation of region
   */
  public String getRegion() {
    return region;
  }

  /**
   * Returns location of event
   *
   * @return String representation of location
   */
  public String getLocation() {
    return location;
  }

  /**
   * Sets number of FallEvent
   * 
   * @param eventNum Integer number of event
   */
  public void setEventNum(int eventNum) {
    this.eventNum = eventNum;
  }

  /**
   * Compares if two FallEvent object are the same by comparing all the
   * fields of both objects
   *
   * @param obj Object that is being compared to
   * @return TRUE if objects are same
   */
  @Override
  public boolean equals(Object obj) {
    boolean result = false;

    if (this.getClass() == obj.getClass()) {
      FallEvent fe = (FallEvent) obj;
      if (super.equals(fe)
              && eventNum == fe.getEventNum()
              && date.equals(fe.getDate())
              && region.equals(fe.getRegion())
              && location.equals(fe.getLocation())) {
        result = true;
      }
    }

    return result;
  }

  /**
   * Compares two FallEvent objects by their event number
   * 
   * @param fa FallEvent that is being compared to
   * @return 
   */
  @Override
  public int compareTo(FestivalActivity fa) {
    FallEvent fe = (FallEvent) fa;
    return Integer.compare(eventNum, fe.getEventNum());
  }

  /**
   * Returns string representation of FallEvent object
   * 
   * @return String of FallEvent
   */
  @Override
  public String toString() {
    String categoryString = "";
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    String result = "";

    switch (super.getCategory()) {
      case 'A':
        categoryString = "Culinary Adventure";
        break;
      case 'C':
        categoryString = "Culinary Event";
        break;
      case 'R':
        categoryString = "Restaurant Dining";
        break;
      case 'S':
        categoryString = "Signature Event";
        break;
      default:
        categoryString = "NOT ASSIGNED";
        break;
    }

    result += "Event #" + eventNum + " - " + super.getName()
            + " - " + categoryString + "\n" + super.getDescription()
            + "\nFee: " + fmt.format(super.getAdmissionFee())
            + " @ " + location + ", " + region + " (" + date + ")";
    return result;
  }
}
