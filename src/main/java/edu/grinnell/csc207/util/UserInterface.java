
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

/**
 * A sample one-player game (is that a puzzle?). Intended as a potential
 * use of our Matrix interface.
 *
 * @author Samuel A. Rebelsky
 */
public class UserInterface {
    pen.println("Game setup number " + game);
    Matrix<String> board = setupBoard(width, height, game);
    Matrix.print(pen, board, true);
}

