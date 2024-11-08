package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Matrix {
    private int[][] matrix;
    public int rows;
    public int cols;

    public Matrix() {
        this(3, 3);
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[rows][cols];
    }

    public void randomizeMatrix() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100, 1000);
            }
        }
    }

    public int findByCoordinates(int x, int y) {
        if ((x >= 0 && x < rows) && (y >= 0 && y < cols)) {
            return matrix[x][y];
        }
        throw new IndexOutOfBoundsException("Invalid coordinates");
    }

    public void replaceByCoordinates(int x, int y, int newValue) {
        if ((x >= 0 && x < rows) && (y >= 0 && y < cols)) {
            matrix[x][y] = newValue;
        } else {
            throw new IndexOutOfBoundsException("Invalid coordinates");
        }
    }

    public void printMatrix() {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(elem + "\t");
            }
            System.out.println();
        }
    }

    public Matrix subtractMatrix(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrices must be of the same dimensions to subtract");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiplyMatrix(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Invalid dimensions for matrix multiplication");
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    }

    public String findElementCoordinate(int element) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == element) {
                    return "(" + i + ", " + j + ")";
                }
            }
        }
        return "Element not found";
    }

    public int countRepeatedElement(int element) {
        int count = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem == element) {
                    count++;
                }
            }
        }
        return count;
    }

    public void countAllRepeatedElements() {
        int[] count = new int[100];
        for (int[] row : matrix) {
            for (int elem : row) {
                count[elem]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                System.out.println("Element " + i + " repeated " + count[i] + " times.");
            }
        }
    }

    public void reverseMatrixByRows() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = temp;
            }
        }
    }

    public void reverseMatrixByColumns() {
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows / 2; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows - i - 1][j];
                matrix[rows - i - 1][j] = temp;
            }
        }
    }

    public void sortElementsByRow() {
        for (int[] row : matrix) {
            Arrays.sort(row);
        }
    }

    public ArrayList<Integer> returnEvenElementsArray() {
        ArrayList<Integer> evens = new ArrayList<>();
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem % 2 == 0) {
                    evens.add(elem);
                }
            }
        }
        return evens;
    }
}
