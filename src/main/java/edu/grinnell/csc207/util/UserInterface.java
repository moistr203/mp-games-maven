
package edu.grinnell.csc207.util;

import java.io.PrintWriter;

public class UserInterface {
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        System.out.println("This is a board");
        Matrix<String> board = GameLogic.setupTikBoard(8, 8);
        Matrix.print(pen, board, true);
    }
}

