package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * UserInterface initializes and manages the flow of the game.
 * <p>
 * Authors:
 * Moise Milenge
 * A.J. Trimble
 */
public class UserInterface {

    /**
     * Main method to initialize the game and run player turns.
     *
     * @param args Command-line arguments.
     * @throws IOException If input or output fails.
     */
    public static void main(String[] args) throws IOException {
        PrintWriter pen = new PrintWriter(System.out, true);
        BufferedReader eyes = new BufferedReader(new InputStreamReader(System.in));

        GameBoard gameBoard = setupGameBoard(pen);

        // Main game loop
        for (int i = 0; i < 4 / (gameBoard.getHeight() * gameBoard.getWidth()); i++) {
            playRound(gameBoard, eyes, pen, 1, "first");
            playRound(gameBoard, eyes, pen, 1, "second");
            gameBoard.print(pen, true);

            playRound(gameBoard, eyes, pen, 2, "first");
            playRound(gameBoard, eyes, pen, 2, "second");
            gameBoard.print(pen, true);
        }

        GameLogic.getWinner(gameBoard, pen);
    }

    /**
     * Sets up the game board.
     *
     * @param pen The PrintWriter for output.
     * @return A new instance of GameBoard with specified dimensions.
     */
    private static GameBoard setupGameBoard(PrintWriter pen) {
        pen.println("Player 1 places X and player 2 places O. Each player places two pieces per turn. "
                + "The player with the most four-in-a-rows at the end wins.");
        return new GameBoard(8, 8);
    }

    /**
     * Plays a single turn for the specified player.
     *
     * @param gameBoard The game board being used.
     * @param eyes      The BufferedReader for input.
     * @param pen       The PrintWriter for output.
     * @param player    The player number (1 or 2).
     * @param round     Specifies if it's the first or second turn in a round.
     * @throws IOException If input or output fails.
     */
    private static void playRound(GameBoard gameBoard, BufferedReader eyes, PrintWriter pen, int player, String round)
            throws IOException {
        GameLogic.playTurn(gameBoard, -1, -1, player, eyes, pen, gameBoard.getHeight(), round);
    }
}
