
package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UserInterface {
    public static void main(String[] args) throws IOException {
        int width = 8;
        int height = 8;
        int row;
        int column;
        PrintWriter pen = new PrintWriter(System.out, true);
        BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("This is a board");
        Matrix<String> board = GameLogic.setupTikBoard(width, height);
        Matrix.print(pen, board, true);
        
        for (int i = 0; i < 3; i++) {
            do {
                row = IOUtils.readInt(pen, eyes, "Player 1 first row ", 0, height);
                System.out.println(row);
                column = IOUtils.readInt(pen, eyes, "Player 1 first column ", 0, height);
                System.out.println(column);
              } while (GameLogic.filledSpace(board, row, column)); 
            board.set(row, column, "X");
            Matrix.print(pen, board, true);
        }
    }
}

