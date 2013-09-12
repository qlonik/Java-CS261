
/**
 *
 * @author qlonik
 */
public class FallFlavoursTester {

    /**
     * @param args the command line arguments
     */    
    public static void main(String[] args) {
        FestivalActivity fa1 = new FestivalActivity("test", "test", 'A', 0.01);
        Object obj = new Object();
        String b = "hi";
        FestivalActivity fa2 = new FestivalActivity("test2", "test2", 'B', 0.01);
        
        System.out.println(fa1.equals(obj));
    }
}
