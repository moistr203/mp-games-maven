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
}
