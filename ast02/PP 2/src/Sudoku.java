
/**
 *
 * @author qlonik
 */
public class Sudoku {

  private int[][] puzzle;
  private boolean[][] matchingTable;
  private int MAX_NUM = 9;

  public Sudoku() {
    puzzle = new int[9][9];
  }

  public Sudoku(int[][] puzzle) {
    this.puzzle = puzzle;
    matchingTable = new boolean[MAX_NUM][MAX_NUM];
    buildMatchArray();
  }

  private void buildMatchArray() {
    for (int i = 0; i < MAX_NUM; i++) {
      for (int j = 0; j < MAX_NUM; j++) {
        if (puzzle[i][j] == 0) {
          matchingTable[i][j] = true;
        } else {
          matchingTable[i][j] = false;
        }
      }
    }
  }

  public void solve() {
  }

  private void recursiveSolve() {
  }

  private boolean checkSolution() {
    boolean result = true;

    for (int i = 0; i < MAX_NUM && result; i++) {
      for (int j = 0; j < MAX_NUM && result; j++) {
        if (!validDigit(puzzle[i][j], j, i)) {
          result = false;
        }
      }
    }

    return result;
  }

  private boolean validDigit(int number, int x, int y) {
    boolean result = true;

    if (number <= 0 || number > 9) {
      result = false;
    } else {
      for (int i = 0; i < MAX_NUM && result; i++) {
        //lines check - row and column
        if ((number == puzzle[y][i] && x != i)
                || (number == puzzle[i][x] && y != i)) {
          result = false;
        }
        //box check
        int x_curr = (x - x % 3) + (i % 3);
        int y_curr = (y / 3 * 3) + (i / 3);
        if (number == puzzle[y_curr][x_curr]
                && x != x_curr && y != y_curr) {
          result = false;
        }
      }
    }

    return result;
  }
}
