package edu.grinnell.csc207.util;

/**
 * An implementation of two-dimensional matrices.
 *
 * @param <T> The type of values stored in the matrix.
 */
public class MatrixV0<T> implements Matrix<T> {
    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /** Holds the height of the matrix. */
    int heightHolder;

    /** Holds the width of the matrix. */
    int widthHolder;

    /** Stores the default value used to initialize cells. */
    T defHolder;

    /** Two-dimensional array that represents the matrix. */
    T[][] matrix;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new matrix of the specified width and height with the given value as the default.
     *
     * @param width The width of the matrix.
     * @param height The height of the matrix.
     * @param def The default value, used to fill all the cells.
     *
     * @throws NegativeArraySizeException If either the width or height are negative.
     */
    @SuppressWarnings("unchecked")
    public MatrixV0(int width, int height, T def) {
        if (width < 0 || height < 0) {
            throw new NegativeArraySizeException("Negative height or width given");
        } else {
            widthHolder = width;
            heightHolder = height;
            defHolder = def;
            this.matrix = (T[][]) new Object[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    this.matrix[i][j] = def;
                }
            }
        }
    }

    /**
     * Create a new matrix of the specified width and height with null as the default value.
     *
     * @param width The width of the matrix.
     * @param height The height of the matrix.
     *
     * @throws NegativeArraySizeException If either the width or height are negative.
     */
    public MatrixV0(int width, int height) {
        this(width, height, null);
    }

    // +--------------+------------------------------------------------
    // | Core methods |
    // +--------------+

    /**
     * Get the element at the given row and column.
     *
     * @param row The row of the element.
     * @param col The column of the element.
     * @return the value at the specified location.
     *
     * @throws IndexOutOfBoundsException If either the row or column is out of reasonable bounds.
     */
    public T get(int row, int col) {
        if (widthHolder <= col || heightHolder <= row) {
            throw new IndexOutOfBoundsException("Out of bounds height or width given");
        } else {
            return matrix[row][col];
        }
    }

    /**
     * Set the element at the given row and column.
     *
     * @param row The row of the element.
     * @param col The column of the element.
     * @param val The value to set.
     *
     * @throws IndexOutOfBoundsException If either the row or column is out of reasonable bounds.
     */
    public void set(int row, int col, T val) {
        if (widthHolder <= col || heightHolder <= row) {
            throw new IndexOutOfBoundsException("Out of bounds height or width given");
        } else {
            matrix[row][col] = val;
        }
    }

    /**
     * Determine the number of rows in the matrix.
     *
     * @return the number of rows.
     */
    public int height() {
        return heightHolder;
    }

    /**
     * Determine the number of columns in the matrix.
     *
     * @return the number of columns.
     */
    public int width() {
        return widthHolder;
    }

    /**
     * Insert a row filled with the default value.
     *
     * @param row The number of the row to insert.
     *
     * @throws IndexOutOfBoundsException If the row is negative or greater than the height.
     */
    public void insertRow(int row) {
        if (heightHolder < row || row < 0) {
            throw new IndexOutOfBoundsException("Out of bounds row given");
        } else {
            T[][] insertedMatrix = (T[][]) new Object[heightHolder + 1][widthHolder];
            for (int i = 0; i < row; i++) {
                System.arraycopy(matrix[i], 0, insertedMatrix[i], 0, widthHolder);
            }
            for (int i = 0; i < widthHolder; i++) {
                insertedMatrix[row][i] = defHolder;
            }
            for (int i = row; i < heightHolder; i++) {
                System.arraycopy(matrix[i], 0, insertedMatrix[i + 1], 0, widthHolder);
            }
            this.matrix = insertedMatrix;
            heightHolder++;
        }
    }

    /**
     * Insert a row filled with the specified values.
     *
     * @param row The number of the row to insert.
     * @param vals The values to insert.
     *
     * @throws IndexOutOfBoundsException If the row is negative or greater than the height.
     * @throws ArraySizeException If the size of vals is not the same as the width of the matrix.
     */
    public void insertRow(int row, T[] vals) throws ArraySizeException {
        if (heightHolder < row || row < 0) {
            throw new IndexOutOfBoundsException("Out of bounds row given");
        }
        if (vals.length != widthHolder) {
            throw new ArraySizeException("Improper number of values given");
        } else {
            T[][] insertedMatrix = (T[][]) new Object[heightHolder + 1][widthHolder];
            for (int i = 0; i < row; i++) {
                System.arraycopy(matrix[i], 0, insertedMatrix[i], 0, widthHolder);
            }
            System.arraycopy(vals, 0, insertedMatrix[row], 0, widthHolder);
            for (int i = row; i < heightHolder; i++) {
                System.arraycopy(matrix[i], 0, insertedMatrix[i + 1], 0, widthHolder);
            }
            this.matrix = insertedMatrix;
            heightHolder++;
        }
    }

    /**
     * Insert a column filled with the default value.
     *
     * @param col The number of the column to insert.
     *
     * @throws IndexOutOfBoundsException If the column is negative or greater than the width.
     */
    public void insertCol(int col) {
        if (widthHolder < col || col < 0) {
            throw new IndexOutOfBoundsException("Out of bounds column given");
        } else {
            T[][] insertedMatrix = (T[][]) new Object[heightHolder][widthHolder + 1];
            for (int i = 0; i < heightHolder; i++) {
                for (int j = 0; j < col; j++) {
                    insertedMatrix[i][j] = matrix[i][j];
                }
                insertedMatrix[i][col] = defHolder;
                for (int j = col; j < widthHolder; j++) {
                    insertedMatrix[i][j + 1] = matrix[i][j];
                }
            }
            this.matrix = insertedMatrix;
            widthHolder++;
        }
    }

    /**
     * Insert a column filled with the specified values.
     *
     * @param col The number of the column to insert.
     * @param vals The values to insert.
     *
     * @throws IndexOutOfBoundsException If the column is negative or greater than the width.
     * @throws ArraySizeException If the size of vals is not the same as the height of the matrix.
     */
    public void insertCol(int col, T[] vals) throws ArraySizeException {
        if (widthHolder < col || col < 0) {
            throw new IndexOutOfBoundsException("Out of bounds column given");
        }
        if (vals.length != heightHolder) {
            throw new ArraySizeException("Improper number of values given");
        } else {
            T[][] insertedMatrix = (T[][]) new Object[heightHolder][widthHolder + 1];
            for (int i = 0; i < heightHolder; i++) {
                for (int j = 0; j < col; j++) {
                    insertedMatrix[i][j] = matrix[i][j];
                }
                insertedMatrix[i][col] = vals[i];
                for (int j = col; j < widthHolder; j++) {
                    insertedMatrix[i][j + 1] = matrix[i][j];
                }
            }
            this.matrix = insertedMatrix;
            widthHolder++;
        }
    }

    /**
     * Delete a row.
     *
     * @param row The number of the row to delete.
     *
     * @throws IndexOutOfBoundsException If the row is negative or greater than or equal to the
     *         height.
     */
    public void deleteRow(int row) {
        if (heightHolder <= row || row < 0) {
            throw new IndexOutOfBoundsException("Out of bounds row given");
        } else {
            T[][] insertedMatrix = (T[][]) new Object[heightHolder - 1][widthHolder];
            for (int i = 0; i < row; i++) {
                System.arraycopy(matrix[i], 0, insertedMatrix[i], 0, widthHolder);
            }
            for (int i = row; i < (heightHolder - 1); i++) {
                System.arraycopy(matrix[i + 1], 0, insertedMatrix[i], 0, widthHolder);
            }
            this.matrix = insertedMatrix;
            heightHolder--;
        }
    }

    /**
     * Delete a column.
     *
     * @param col The number of the column to delete.
     *
     * @throws IndexOutOfBoundsException If the column is negative or greater than or equal to the
     *         width.
     */
    public void deleteCol(int col) {
        if (widthHolder <= col || col < 0) {
            throw new IndexOutOfBoundsException("Out of bounds column given");
        } else {
            T[][] insertedMatrix = (T[][]) new Object[heightHolder][widthHolder - 1];
            for (int i = 0; i < heightHolder; i++) {
                for (int j = 0; j < col; j++) {
                    insertedMatrix[i][j] = matrix[i][j];
                }
                for (int j = col; j < (widthHolder - 1); j++) {
                    insertedMatrix[i][j] = matrix[i][j + 1];
                }
            }
            this.matrix = insertedMatrix;
            widthHolder--;
        }
    }

    /**
     * Fill a rectangular region of the matrix.
     *
     * @param startRow The top edge / row to start with (inclusive).
     * @param startCol The left edge / column to start with (inclusive).
     * @param endRow The bottom edge / row to stop with (exclusive).
     * @param endCol The right edge / column to stop with (exclusive).
     * @param val The value to store.
     *
     * @throws IndexOutOfBoundsException If the rows or columns are inappropriate.
     */
    public void fillRegion(int startRow, int startCol, int endRow, int endCol, T val) {
        if (startRow < 0 || startRow >= heightHolder || startRow >= endRow) {
            throw new IndexOutOfBoundsException("Out of bounds start row given");
        } else if (endRow < 0 || endRow > heightHolder) {
            throw new IndexOutOfBoundsException("Out of bounds end row given");
        } else if (startCol < 0 || startCol >= widthHolder || startCol >= endCol) {
            throw new IndexOutOfBoundsException("Out of bounds start col given");
        } else if (endCol < 0 || endCol > widthHolder) {
            throw new IndexOutOfBoundsException("Out of bounds end col given");
        } else {
            for (int i = startRow; i < endRow; i++) {
                for (int j = startCol; j < endCol; j++) {
                    matrix[i][j] = val;
                }
            }
        }
    }

    /**
     * @todo Implement fillLine method functionality.
     */
    public void fillLine(int startRow, int startCol, int deltaRow, int deltaCol, int endRow,
                         int endCol, T val) {
        // Placeholder for fillLine functionality
    }

    /**
     * @todo Complete implementation for clone method.
     * @return a copy of the matrix.
     */
    public Matrix clone() {
        return this; // Stub for cloning functionality
    }

    /**
     * Determine if this object is equal to another object.
     *
     * @param other The object to compare.
     * @return true if the other object is a matrix with the same width, height, and equal elements;
     *         false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return this == other; // Stub
    }

    /**
     * Compute a hash code for this matrix.
     *
     * @return the hash code.
     */
    public int hashCode() {
        int multiplier = 7;
        int code = widthHolder + multiplier * heightHolder;
        for (int row = 0; row < heightHolder; row++) {
            for (int col = 0; col < widthHolder; col++) {
                T val = this.get(row, col);
                if (val != null) {
                    code = code * multiplier + val.hashCode();
                }
            }
        }
        return code;
    }
}