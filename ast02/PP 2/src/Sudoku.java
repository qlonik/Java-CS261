
import java.util.LinkedHashSet;

/**
 *
 * @author qlonik
 */
public class Sudoku {

  private int[][] puzzle;

  public Sudoku() {
    puzzle = new int[9][9];
  }

  public Sudoku(int[][] puzzle) {
    this.puzzle = puzzle;
  }

  public void solve() {
  }

  private void recursiveSolve() {
  }

  private boolean checkSolution() {
  }

  private boolean validDigit(int number, int x, int y) {
    boolean result = true;

    for (int i = 0; i < puzzle.length && result; i++) {
      if (number == puzzle[x][i] || number == puzzle[i][y]
              || number == puzzle[(x - x % 3) + (i % 3)][(y / 3 * 3) + (i / 3)]) {
        result = false;
      }
    }

    return result;
  }
}
