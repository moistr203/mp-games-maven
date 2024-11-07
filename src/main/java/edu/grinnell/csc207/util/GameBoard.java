package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * Represents a game board with methods for piece placement, checking filled spaces,
 * and calculating scores based on four-in-a-row sequences.
 *
 * Authors:
 * Moise Milenge
 * A.J. Trimble
 */
public class GameBoard {

    /** Matrix representing the game board. */
    private final Matrix<String> board;

    /** Height of the game board. */
    private final int height;

    /** Width of the game board. */
    private final int width;

    /**
     * Creates a game board of specified dimensions with blank spaces.
     *
     * @param width Width of the board.
     * @param height Height of the board.
     */
    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new MatrixV0<>(width, height, " ");
    }

    /**
     * Checks if a specified cell on the board is filled.
     *
     * @param row Row of the cell.
     * @param column Column of the cell.
     * @param pen Output writer for messages.
     * @return True if space is filled; false otherwise.
     */
    public boolean isFilledSpace(int row, int column, PrintWriter pen) {
        if (!this.board.get(row, column).equals(" ")) {
            pen.println("That space is taken");
        }
        return !this.board.get(row, column).equals(" ");
    }

    /**
     * Sets a piece at a specified position.
     *
     * @param row Row to place the piece.
     * @param column Column to place the piece.
     * @param piece Piece to set ("X" or "O").
     */
    public void set(int row, int column, String piece) {
        this.board.set(row, column, piece);
    }

    /**
     * Gets the piece at a specified position.
     *
     * @param row Row to retrieve from.
     * @param column Column to retrieve from.
     * @return Piece at the position.
     */
    public String get(int row, int column) {
        return this.board.get(row, column);
    }

    /**
     * Calculates the score for a player based on four-in-a-row sequences.
     *
     * @param piece Type of piece for score calculation.
     * @return Score based on four-in-a-row sequences.
     */
    public int getScore(String piece) {
        int score = 0;
        score += calculateLineScore(piece, true);  // Horizontal
        score += calculateLineScore(piece, false); // Vertical
        score += calculateDiagonalScore(piece);    // Diagonals
        return score;
    }

    /** Helper to calculate horizontal and vertical scores. */
    private int calculateLineScore(String piece, boolean isHorizontal) {
        int score = 0;
        for (int i = 0; i < (isHorizontal ? height : width); i++) {
            int inLine = 0;
            for (int j = 0; j < (isHorizontal ? width : height); j++) {
                String pos = isHorizontal ? board.get(i, j) : board.get(j, i);
                if (pos.equals(piece)) {
                    inLine++;
                    if (inLine == 4) {
                        score++;
                        inLine = 0;
                    }
                } else {
                    inLine = 0;
                }
            }
        }
        return score;
    }

    /** Helper to calculate diagonal scores. */
    private int calculateDiagonalScore(String piece) {
        int score = 0;
        // Diagonal from top-left to bottom-right
        for (int i = 0; i <= height - 4; i++) {
            for (int j = 0; j <= width - 4; j++) {
                int inLine = 0;
                for (int k = 0; k < 4; k++) {
                    if (board.get(i + k, j + k).equals(piece)) {
                        inLine++;
                    }
                }
                if (inLine == 4) {
                    score++;
                }
            }
        }

        // Diagonal from top-right to bottom-left
        for (int i = 0; i <= height - 4; i++) {
            for (int j = 3; j < width; j++) {
                int inLine = 0;
                for (int k = 0; k < 4; k++) {
                    if (board.get(i + k, j - k).equals(piece)) {
                        inLine++;
                    }
                }
                if (inLine == 4) {
                    score++;
                }
            }
        }
        return score;
    }

    /**
     * Prints the board using the provided PrintWriter.
     *
     * @param pen Output writer for printing.
     * @param bol Flag to include row/column labels.
     */
    public void print(PrintWriter pen, boolean bol) {
        Matrix.print(pen, this.board, bol);
    }

    /**
     * Gets the height of the game board.
     *
     * @return Height of the board.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets the width of the game board.
     *
     * @return Width of the board.
     */
    public int getWidth() {
        return width;
    }

}