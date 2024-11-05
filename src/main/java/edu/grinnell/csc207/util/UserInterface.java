
package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UserInterface {
    public static void main(String[] args) throws IOException {
        int width = 8;
        int height = 8;
        int row = -1;
        int column = -1;
        PrintWriter pen = new PrintWriter(System.out, true);
        BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This is a board");
        Matrix<String> board = GameLogic.setupTikBoard(width, height);
        Matrix.print(pen, board, true);
        
        for (int i = 0; i < 3; i++) {
            GameLogic.playTurn(board, row, column, 1, eyes, pen, height);
            GameLogic.playTurn(board, row, column, 2, eyes, pen, height);
            Matrix.print(pen, board, true);
        }
    }
}

