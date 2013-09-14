
import java.text.NumberFormat;

/**
 *
 * @author qlonik
 */
public class FallEvent extends FestivalActivity
        implements Comparable<FestivalActivity> {

    private int eventNum;
    private String date, region, location;

    public FallEvent() {
        super();
        eventNum = 0;
        date = "";
        region = "";
        location = "";
    }

    public FallEvent(int eventNum, String date, String region, String location) {
        this.eventNum = eventNum;
        this.date = date;
        this.region = region;
        this.location = location;
    }

    public FallEvent(String name, String description, char category, double admissionFee) {
        super(name, description, category, admissionFee);
    }

    public FallEvent(int eventNum, String date, String region, String location,
            String name, String description, char category, double admissionFee) {
        super(name, description, category, admissionFee);
        this.eventNum = eventNum;
        this.date = date;
        this.region = region;
        this.location = location;
    }

    public int getEventNum() {
        return eventNum;
    }

    public String getDate() {
        return date;
    }

    public String getRegion() {
        return region;
    }

    public String getLocation() {
        return location;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

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

    @Override
    public int compareTo(FestivalActivity fa) {
        FallEvent fe = (FallEvent) fa;
        return Integer.compare(eventNum, fe.getEventNum());
    }

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
