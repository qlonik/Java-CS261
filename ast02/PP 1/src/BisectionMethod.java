
class BisectionMethod {

  double a, b, c, d, lower, upper, epsilon;

  public BisectionMethod(double a, double b, double c, double d,
          double lower, double upper, double epsilon)
          throws IntervalException {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.lower = lower;
    this.upper = upper;
    this.epsilon = epsilon;

    if (lower > upper) {
      throw new IntervalException("Interval is not valid."
              + "\nLower bound is higher than upper");
    }
    if (Math.signum(func(lower)) == Math.signum(func(upper))) {
      throw new IntervalException("func(lower bound) and func(upper bound) have the same sign");
    }
  }

  private double func(double x) {
    return a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * Math.pow(x, 1) + d;
  }

  public double solve() {
    return recursiveSolve(lower, upper);
  }

  private double recursiveSolve(double lower, double upper) {
    double solution = 0;

    if (Math.abs(upper - lower) < epsilon) {
      solution = (lower + upper) / 2;
    } else {
      double mid = (upper + lower) / 2;
      if (Math.signum(func(mid)) == Math.signum(func(upper))) {
        solution = recursiveSolve(lower, mid);
      } else if (Math.signum(func(mid)) == Math.signum(func(lower))) {
        solution = recursiveSolve(mid, upper);
      }
    }
    return solution;
  }
}
