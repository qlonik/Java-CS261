
import java.util.ArrayList;

/*
 * Student: Nikita Volodin    id: 127196
 * Student: Mitchell Corish   id: 124557
 * Assignment #2 - Part B     CS261
 * 
 * Class solves a given sudoku using brute force method
 */
public class Sudoku {

  private int[][] puzzle;
  private boolean[][] matchingTable;
  private int MAX_NUM = 9;

  /**
   * Creates an array of given user data
   *
   * @param puzzle given 2 dimensional array with sudoku
   */
  public Sudoku(int[][] puzzle) {
    this.puzzle = puzzle;
    matchingTable = new boolean[MAX_NUM][MAX_NUM];
    buildMatchArray();
  }

  /**
   * Builds matching array with true values in cells that can be changed
   */
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

  /**
   * public method to initiate the recusiveSolve method
   */
  public void solve() {
    recursiveSolve(0);
  }

  /**
   * recursiveSolve uses recursion to solve the given Sudoku
   *
   * @param a number of cell to start from
   * @return TRUE if sudoku is solved
   */
  private boolean recursiveSolve(int a) {
    boolean result = false;

    if (a < MAX_NUM * MAX_NUM) { //if we are inside sudoku grid
      int x = a % 9;
      int y = a / 9;
      while (!matchingTable[y][x]) { //skip all unchangeable values
        a++;
        x = a % 9;
        y = a / 9;
      }
      //get all possible values in current cell
      ArrayList<Integer> possibleValues = buildPossibleValues(x, y);
      //try all possible values
      for (int i = 0; i < possibleValues.size() && !result; i++) {
        puzzle[y][x] = possibleValues.get(i);
        if (checkSolution()) {
          result = true;
        } else {
          result = recursiveSolve(a + 1);
          if (!result) {
            puzzle[y][x] = 0;
          }
        }
      }
    }

    return result;
  }

  /**
   * Creates an ArrayList with all possible values in given spot
   *
   * @param x specified column
   * @param y specified row
   * @return possible values for cell
   */
  private ArrayList<Integer> buildPossibleValues(int x, int y) {
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 1; i <= 9; i++) {
      if (validDigit(i, x, y)) {
        result.add(i);
      }
    }

    return result;
  }

  /**
   * checks solution to see if it is correct
   *
   * @return TRUE - if sudoku puzzle solved correctly
   */
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

  /**
   * Checks number to see if it is a valid digit to put into cell
   *
   * @param number given from the sudoku at a certain position
   * @param x specified column
   * @param y specified row
   * @return TRUE - if we can put number in given cell
   */
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

  /**
   * Prints puzzle
   *
   * @return String representation of sudoku
   */
  @Override
  public String toString() {
    String result = "";
    for (int i = 0; i < MAX_NUM; i++) {
      for (int j = 0; j < MAX_NUM; j++) {
        result += puzzle[i][j] + " ";
      }
      result += "\n";
    }
    return result;
  }
}
