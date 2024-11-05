package edu.grinnell.csc207.util;

public class GameBoard {

  /*
   * Fields 
   */
  Matrix<String> board;
  int height;
  int width;

  /*
   * Constructor
   */
  public GameBoard(int width, int height) {
    this.width = width;
    this.height = height;
    this.board = new MatrixV0<>(width, height, " ");
  }

  /*
   * Methods
   */

   static boolean isFilledSpace(Matrix<String> board, int row, int column) {
     return !board.get(row, column).equals(" ");
   }
}
