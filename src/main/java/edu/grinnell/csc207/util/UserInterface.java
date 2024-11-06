
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
        GameBoard gameBoard = new GameBoard(width, height);
        
        for (int i = 0; i < 2; i++) {
            GameLogic.playTurn(gameBoard, row, column, 1, eyes, pen, height, "first");
            GameLogic.playTurn(gameBoard, row, column, 1, eyes, pen, height, "second");
            gameBoard.print(pen, true);
            GameLogic.playTurn(gameBoard, row, column, 2, eyes, pen, height, "first");
            GameLogic.playTurn(gameBoard, row, column, 2, eyes, pen, height, "second");
            gameBoard.print(pen, true);
        }
    }
}

