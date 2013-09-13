
/**
 *
 * @author qlonik
 */
public class FallEvent extends FestivalActivity
        implements Comparable<FestivalActivity> {

    private int eventNum;
    private String date, region, location;

    public FallEvent() {
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
    
    @Override
    public int compareTo(FestivalActivity fa) {
        FallEvent fe = (FallEvent) fa;
        return Integer.compare(eventNum, fe.getEventNum());
    }
    
    
}
