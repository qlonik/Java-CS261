
import java.util.Scanner;

public class BisectionMethodTester {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Program to solve qubic equations");

    System.out.print("Type coefficients: a: ");
    Double x1 = kb.nextDouble();

    System.out.println();
    System.out.print("Type coefficients: b: ");
    Double x2 = kb.nextDouble();

    System.out.println();
    System.out.print("Type coefficients: c: ");
    Double x3 = kb.nextDouble();
    System.out.println();

    System.out.print("Type coefficients: d: ");
    Double x4 = kb.nextDouble();
    System.out.println();

    System.out.print("Type lower bound for interval: ");
    Double a = kb.nextDouble();
    System.out.println();

    System.out.print("Type upper bound for interval: ");
    Double b = kb.nextDouble();
    System.out.println();

    System.out.print("Type epsilon: ");
    Double epsilon = kb.nextDouble();
    System.out.println();

//    double x1 = 5;
//    double x2 = -2;
//    double x3 = 0;
//    double x4 = 3;
//    double a = -1;
//    double b = 1;
//    double epsilon = 0.0001;

    try {
      BisectionMethod bm = new BisectionMethod(x1, x2, x3, x4, a, b, epsilon);
      double solution = bm.solve();
      System.out.println("Solution for this equation on this interval is: "
              + solution);
    } catch (IntervalException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
