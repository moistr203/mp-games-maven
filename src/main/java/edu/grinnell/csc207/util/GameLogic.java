package edu.grinnell.csc207.util;

import edu.grinnell.csc207.util.ArrayUtils;
import edu.grinnell.csc207.util.IOUtils;
import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameLogic {
    /**
   * Set up a new board.
   *
   * @param width
   *   The width of the board.
   * @param height
   *   The height of the board.
   * @param game
   *   The game number.
   *
   * @return the newly created board
   */
  static Matrix<String> setupTikBoard(int width, int height) {
    Matrix<String> board = new MatrixV0<String>(width, height, " ");
    return board;
  } // setupBoard(int, int, int) 

  static boolean filledSpace(Matrix<String> board, int row, int column) {
    if (board.get(row, column).equals(" ")) {
      return false;
    }
    System.out.println("That space is already filled");
    return true;
  } // filledSpace(Matrix<String>, int, int)

  // Better practice to impliment this function and use it to reduce complexity 
  
  static void playTurn(Matrix<String> board, int row, int column, int player, BufferedReader eyes, PrintWriter pen, int limit) throws IOException {
      do {
        row = IOUtils.readInt(pen, eyes, "Player " + player + " first row ", 0, limit);
        System.out.println(row);
        column = IOUtils.readInt(pen, eyes, "Player " + player + " first column ", 0, limit);
        System.out.println(column);
      } while (GameLogic.filledSpace(board, row, column)); 
      if (player == 1 ) {
        board.set(row, column, "X");
      } else {
        board.set(row, column, "O");
      }
    } 
    
}



