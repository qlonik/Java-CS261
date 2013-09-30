
import java.util.Scanner;

/*
 * Student: Nikita Volodin    id: 127196
 * Student: Mitchell Corish   id: 124557
 * Assignment #2 - Part B     CS261
 * 
 * Class tests Sudoku class
 */
public class SudokuTester {

  public static void main(String[] args) {
    int[][] sudokuFromPDF = {
      {0, 0, 6, 7, 9, 5, 0, 8, 0},
      {0, 0, 7, 0, 0, 3, 0, 0, 6},
      {0, 0, 4, 0, 0, 2, 0, 0, 1},
      {2, 0, 0, 0, 0, 0, 3, 0, 0},
      {0, 7, 0, 0, 0, 0, 0, 2, 0},
      {0, 0, 9, 0, 0, 0, 0, 0, 8},
      {7, 0, 0, 9, 0, 0, 8, 0, 0},
      {9, 0, 0, 2, 0, 0, 1, 0, 0},
      {0, 8, 0, 5, 6, 7, 9, 0, 0}
    };

    int[][] sudokuFromBook = {
      {0, 0, 3, 0, 0, 8, 0, 2, 0},
      {6, 0, 0, 3, 0, 0, 0, 0, 9},
      {0, 9, 0, 7, 0, 0, 1, 0, 4},
      {9, 0, 0, 2, 0, 0, 5, 4, 3},
      {0, 8, 0, 4, 0, 1, 0, 0, 0},
      {4, 6, 2, 0, 0, 7, 0, 0, 1},
      {1, 0, 6, 0, 0, 3, 0, 9, 0},
      {8, 0, 0, 0, 0, 9, 3, 0, 6},
      {0, 3, 0, 6, 0, 0, 7, 0, 0}
    };

    int[][] sudokuFromInternet = {
      {8, 0, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 3, 6, 0, 0, 0, 0, 0},
      {0, 7, 0, 0, 9, 0, 2, 0, 0},
      {0, 5, 0, 0, 0, 7, 0, 0, 0},
      {0, 0, 0, 0, 4, 5, 7, 0, 0},
      {0, 0, 0, 1, 0, 0, 0, 3, 0},
      {0, 0, 1, 0, 0, 0, 0, 6, 8},
      {0, 0, 8, 5, 0, 0, 0, 1, 0},
      {0, 9, 0, 0, 0, 0, 4, 0, 0}
    };


    Scanner kb = new Scanner(System.in);
    int[][] currentSudoku = null;
    String userInput;
    Sudoku sudoku;

    System.out.println("Choose which sudoku you want to solve.");
    System.out.println("'p' is for sudoku from PDF file");
    System.out.println("'b' is for sudoku from book");
    System.out.println("'i' is for sudoku from internet");
    System.out.print(">>> ");

    userInput = kb.nextLine();
    switch (userInput.toUpperCase()) {
      case "P":
        currentSudoku = sudokuFromPDF;
        break;
      case "B":
        currentSudoku = sudokuFromBook;
        break;
      case "I":
        currentSudoku = sudokuFromInternet;
        break;
      default:
        System.out.println("Wrong input. Exiting...");
        break;
    }

    if (currentSudoku != null) {
      sudoku = new Sudoku(currentSudoku);
      System.out.println();
      System.out.println("Given: \n" + sudoku);
      sudoku.solve();
      System.out.println("Solved: \n" + sudoku);
    }
  }
}
