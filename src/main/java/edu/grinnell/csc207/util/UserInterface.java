package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * A simple user interface for a two-player game where players aim to achieve the
 * most four-in-a-row formations on a game board. Player 1 places X, and Player 2 places O.
 * Each player places two pieces per turn. The game proceeds until the board is filled.
 *
 * <p>Authors: Moise Milenge
 *  A.J. Trimble</p>
 */
public class UserInterface {

    /**
     * The main method to run the game. Initializes the game board and handles player turns.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an input or output exception occurs
     */
    public static void main(String[] args) throws IOException {
        int width = 8;
        int height = 8;
        PrintWriter pen = new PrintWriter(System.out, true);
        BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

        pen.println("Player 1 places X and player 2 places O. "
                + "Each player places two pieces per turn. The player with the most four-in-a-rows at the end wins.");

        GameBoard gameBoard = new GameBoard(width, height);
        gameBoard.print(pen, true);

        // Main game loop
        for (int i = 0; i < (height * width) / 4; i++) {
            // Player 1's first and second turns
            GameLogic.playTurn(gameBoard, -1, -1, 1, eyes, pen, height, "first");
            GameLogic.playTurn(gameBoard, -1, -1, 1, eyes, pen, height, "second");
            gameBoard.print(pen, true);

            // Player 2's first and second turns
            GameLogic.playTurn(gameBoard, -1, -1, 2, eyes, pen, height, "first");
            GameLogic.playTurn(gameBoard, -1, -1, 2, eyes, pen, height, "second");
            gameBoard.print(pen, true);
        }

        // Determine and display the winner at the end of the game
        GameLogic.getWinner(gameBoard, pen);
    }
} // class UserInterface