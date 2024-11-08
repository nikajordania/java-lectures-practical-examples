package matrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = new Matrix();

        while (true) {
            System.out.println("""
                    Choose an operation:
                    1. Randomize Matrix
                    2. Print Matrix
                    3. Find by Coordinates
                    4. Replace by Coordinates
                    5. Subtract Matrix
                    6. Multiply Matrix
                    7. Find Element Coordinates
                    8. Count Repeated Element
                    9. Count All Repeated Elements
                    10. Reverse Matrix by Rows
                    11. Reverse Matrix by Columns
                    12. Sort Elements by Row
                    13. Return Even Elements Array
                    0. Exit""");
            int choice = scanner.nextInt();

            if (choice == 0) break;

            switch (choice) {
                case 1 -> matrix.randomizeMatrix();
                case 2 -> matrix.printMatrix();
                case 3 -> {
                    System.out.print("Enter coordinates (x y): ");
                    int x = scanner.nextInt(), y = scanner.nextInt();
                    System.out.println("Value: " + matrix.findByCoordinates(x, y));
                }
                case 4 -> {
                    System.out.print("Enter coordinates and new value (x y newValue): ");
                    int x = scanner.nextInt(), y = scanner.nextInt(), newValue = scanner.nextInt();
                    matrix.replaceByCoordinates(x, y, newValue);
                }
                case 5 -> {
                    Matrix otherMatrix = new Matrix(matrix.rows, matrix.cols);
                    otherMatrix.randomizeMatrix();
                    matrix = matrix.subtractMatrix(otherMatrix);
                }
                case 6 -> {
                    Matrix otherMatrix = new Matrix(matrix.cols, matrix.rows);
                    otherMatrix.randomizeMatrix();
                    matrix = matrix.multiplyMatrix(otherMatrix);
                }
                case 7 -> {
                    System.out.print("Enter element to find: ");
                    int element = scanner.nextInt();
                    System.out.println(matrix.findElementCoordinate(element));
                }
                case 8 -> {
                    System.out.print("Enter element to count: ");
                    int element = scanner.nextInt();
                    System.out.println("Count: " + matrix.countRepeatedElement(element));
                }
                case 9 -> matrix.countAllRepeatedElements();
                case 10 -> matrix.reverseMatrixByRows();
                case 11 -> matrix.reverseMatrixByColumns();
                case 12 -> matrix.sortElementsByRow();
                case 13 -> System.out.println("Even elements: " + matrix.returnEvenElementsArray());
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting...");
    }
}
