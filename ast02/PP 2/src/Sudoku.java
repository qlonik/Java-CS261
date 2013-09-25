
import java.util.ArrayList;

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

  private boolean recursiveSolve(int a) {
    boolean result = false;

    if (a < MAX_NUM * MAX_NUM) { //if we are outside sudoku grid
      int x = a % 9;
      int y = a / 9;
      while (!matchingTable[y][x]) { //skip all unchangeable values
        a++;
        x = a % 9;
        y = a / 9;
      }
      //get all possible values in current cell
      ArrayList<Integer> possibleValues = buildPossibleValues(x, y);
      
      for (int i = 0; i < possibleValues.size() && !result; i++) {
        if (matchingTable[y][x]) {
          puzzle[y][x] = possibleValues.get(i);
        }
        if (checkSolution()) {
          result = true;
        } else {
          result = recursiveSolve(a + 1);
          if (!result && matchingTable[y][x]) {
            puzzle[y][x] = 0;
          }
        }
      }
    }

    return result;
  }

  private ArrayList<Integer> buildPossibleValues(int x, int y) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 1; i <= 9; i++) {
      if (validDigit(i, x, y)) {
        result.add(i);
      }
    }

    return result;
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
