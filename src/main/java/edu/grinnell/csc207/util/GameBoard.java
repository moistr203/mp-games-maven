package edu.grinnell.csc207.util;

import java.io.PrintWriter;

/**
 * Represents a game board for a two-player game where players place pieces
 * to form lines of four. The board tracks pieces placed by each player and
 * calculates scores based on completed rows, columns, and diagonals.
 */
public class GameBoard {

    /** The matrix representing the game board. */
    private Matrix<String> board;

    /** The height of the game board. */
    private int height;

    /** The width of the game board. */
    private int width;

    /**
     * Initializes a new game board with specified dimensions.
     *
     * @param boardWidth the width of the game board
     * @param boardHeight the height of the game board
     */
    public GameBoard(int boardWidth, int boardHeight) {
        this.width = boardWidth;
        this.height = boardHeight;
        this.board = new MatrixV0<>(boardWidth, boardHeight, " ");
    }

    /**
     * Checks if the specified position on the board is already filled.
     *
     * @param row the row of the position
     * @param column the column of the position
     * @return true if the position is filled, false otherwise
     */
    public boolean isFilledSpace(int row, int column) {
        boolean isFilled = !this.board.get(row, column).equals(" ");
        if (isFilled) {
            System.out.println("That space is taken"); // For use with PrintWriter if needed
        }
        return isFilled;
    }

    /**
     * Sets a piece at the specified position on the board.
     *
     * @param row the row to place the piece
     * @param column the column to place the piece
     * @param piece the piece to place (e.g., "X" or "O")
     */
    public void set(int row, int column, String piece) {
        this.board.set(row, column, piece);
    }

    /**
     * Retrieves the piece at the specified position on the board.
     *
     * @param row the row of the position
     * @param column the column of the position
     * @return the piece at the specified position
     */
    public String get(int row, int column) {
        return this.board.get(row, column);
    }

    /**
     * Returns the height of the game board.
     *
     * @return the height of the board
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Returns the width of the game board.
     *
     * @return the width of the board
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Calculates the score for a specified piece by counting lines of four
     * consecutive pieces in rows, columns, and diagonals.
     *
     * @param piece the piece to calculate the score for (e.g., "X" or "O")
     * @return the score based on completed lines of four
     */
    public int getScore(String piece) {
        int score = 0;

        // Calculate points by rows
        for (int i = 0; i < this.height; i++) {
            int inLine = 0;
            for (int j = 0; j < this.width; j++) {
                inLine = updateScore(piece, score, inLine, this.board.get(i, j));
            }
        }

        // Calculate points by columns
        for (int j = 0; j < this.width; j++) {
            int inLine = 0;
            for (int i = 0; i < this.height; i++) {
                inLine = updateScore(piece, score, inLine, this.board.get(i, j));
            }
        }

        // Calculate points by diagonals (top-left to bottom-right and vice versa)
        score += calculateDiagonalScore(piece);

        return score;
    }
    /**
     * Prints the game board to the specified PrintWriter.
     * @param pen the PrintWriter to print the board to
     * @param bol a flag for custom print settings, if needed
     */
    public void print(PrintWriter pen, boolean bol) {
        Matrix.print(pen, this.board, bol);
    }
    // Helper methods
    /**
     * Updates score and in-line count based on matching pieces.
     *
     * @param piece the piece to check
     * @param score current score
     * @param inLine current in-line count
     * @param boardValue current board value
     * @return updated in-line count
     */
    private int updateScore(String piece, int score, int inLine,
                String boardValue) {
        if (boardValue.equals(piece)) {
            inLine++;
            if (inLine == 4) {
                score++;
                inLine--;
            }
        } else {
            inLine = 0;
        }
        return inLine;
    }
    /**
     * Calculates diagonal scores for the board.
     *
     * @param piece the piece to check
     * @return the score based on diagonals
     */
    private int calculateDiagonalScore(String piece) {
        int score = 0;

        // Top-left to bottom-right diagonals
        for (int x = 0; x < this.width; x++) {
            score += processDiagonal(piece, x, 0, 1, 1);
        }
        for (int x = 1; x < this.width; x++) {
            score += processDiagonal(piece, 0, x, 1, 1);
        }
        return score;
    }
    /**
     * Processes individual diagonals and calculates scores.
     *
     * @param piece the piece to check
     * @param startX starting x-coordinate
     * @param startY starting y-coordinate
     * @param xStep x increment per step
     * @param yStep y increment per step
     * @return the score from one diagonal
     */
    private int processDiagonal(String piece, int startX, int startY, int xStep, int yStep) {
        int inLine = 0;
        int score = 0;
        int x = startX;
        int y = startY;

        while (x < this.height && y < this.width) {
            inLine = updateScore(piece, score, inLine, this.board.get(x, y));
            x += xStep;
            y += yStep;
        }
        return score;
    }
} // class GameBoard
