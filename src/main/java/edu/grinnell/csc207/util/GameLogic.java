package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * GameLogic contains the core methods to handle gameplay for a two-player game.
 * Each player places pieces on the game board in turns, and the class determines
 * the winner based on the final scores.
 */
public class GameLogic {

    /**
     * Manages a single turn for a player, prompting them to choose a row and column.
     * If the chosen space is already filled, the player is prompted again.
     * Player 1 places "X", while Player 2 places "O".
     *
     * @param gameBoard the game board on which players place pieces
     * @param row the row selected by the player
     * @param column the column selected by the player
     * @param player the player number (1 or 2)
     * @param eyes BufferedReader for reading user input
     * @param pen PrintWriter for writing output to the console
     * @param limit the maximum row/column index allowed for the board
     * @param round specifies whether it's the player's "first" or "second" move of the turn
     * @throws IOException if an input or output exception occurs
     */
    static void playTurn(GameBoard gameBoard, int row, int column, int player, BufferedReader eyes,
                         PrintWriter pen, int limit, String round) throws IOException {
        do {
            row = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " row ", 0, limit);
            pen.println("Selected row: " + row);  // Output row selection

            column = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " column ", 0, limit);
            pen.println("Selected column: " + column);  // Output column selection

        } while (gameBoard.isFilledSpace(row, column));

        // Place the piece based on player number
        String piece = player == 1 ? "X" : "O";
        gameBoard.set(row, column, piece);
    }

    /**
     * Determines the winner by comparing the scores for Player 1 and Player 2
     * based on the number of pieces aligned in fours on the game board.
     * Outputs the scores and declares the winner or a tie.
     *
     * @param gameBoard the game board to evaluate scores for each player
     * @param pen PrintWriter for writing output to the console
     */
    static void getWinner(GameBoard gameBoard, PrintWriter pen) {
        int xScore = gameBoard.getScore("X");
        int oScore = gameBoard.getScore("O");
        pen.println("Player 1 score: " + xScore);
        pen.println("Player 2 score: " + oScore);

        // Determine the result based on scores
        if (xScore > oScore) {
            pen.println("Player 1 wins!");
        } else if (xScore < oScore) {
            pen.println("Player 2 wins!");
        } else {
            pen.println("Tie!");
        }
    }
}// class GameLogic
