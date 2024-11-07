package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * GameLogic handles turns, score calculations, and determining the game winner.
 * Authors
 * Moise Milenge
 * A.J. Trimble
 */
public class GameLogic {

    /**
     * Manages a player's turn with validation.
     *
     * @param gameBoard The game board.
     * @param row       Row for placement.
     * @param column    Column for placement.
     * @param player    Player (1 or 2).
     * @param eyes      BufferedReader for user input.
     * @param pen       PrintWriter for displaying output.
     * @param limit     Maximum boundary for row and column.
     * @param round     Label for the turn round.
     * @throws IOException If input or output fails.
     */
    static void playTurn(GameBoard gameBoard, int row, int column, int player, BufferedReader eyes,
                         PrintWriter pen, int limit, String round) throws IOException {
        do {
            row = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " row ", 0, limit);
            pen.println("Row selected: " + row);
            column = IOUtils.readInt(pen, eyes, "Player " + player + " " + round + " column ", 0, limit);
            pen.println("Column selected: " + column);
        } while (gameBoard.isFilledSpace(row, column, pen));

        gameBoard.set(row, column, player == 1 ? "X" : "O");
    }

    /**
     * Determines and displays the game winner by comparing scores.
     *
     * @param gameBoard The game board used for scoring.
     * @param pen       PrintWriter for output messages.
     */
    static void getWinner(GameBoard gameBoard, PrintWriter pen) {
        int xScore = gameBoard.getScore("X");
        int oScore = gameBoard.getScore("O");

        pen.println("Player 1 score: " + xScore);
        pen.println("Player 2 score: " + oScore);

        if (xScore > oScore) {
            pen.println("Player 1 wins!");
        } else if (xScore < oScore) {
            pen.println("Player 2 wins!");
        } else {
            pen.println("It's a tie!");
        }
    }
}
