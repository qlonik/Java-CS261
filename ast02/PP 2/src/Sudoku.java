
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
  }

  private boolean validDigit(int number, int x, int y) {
  }
}
