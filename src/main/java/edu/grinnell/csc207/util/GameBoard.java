package edu.grinnell.csc207.util;

import java.io.PrintWriter;

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
    public boolean isFilledSpace(int row, int column) {
      if (!this.board.get(row, column).equals(" ")) {
        System.out.println("That space is taken");
      }
        return !this.board.get(row, column).equals(" ");
    }

    public void set(int row, int column, String piece) {
        this.board.set(row, column, piece);
    }

    public void print(PrintWriter pen, boolean bol) {
      Matrix.print(pen, this.board, bol);
  }

}
