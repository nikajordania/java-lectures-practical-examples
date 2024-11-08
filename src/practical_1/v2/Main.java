package practical_1.v2;

import java.util.Random;
import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
        scanner.close();
    }

    public static void task1() {

        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter stock count: ");
        int stockCount = scanner.nextInt();

        ElectronicProduct electronicProduct = new ElectronicProduct(productName, category, price, stockCount);

        System.out.println("Product Information: ");
        electronicProduct.getProductInfo();

        System.out.println("Applying Discount: ");
        electronicProduct.applyDiscount();
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();

        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();

        if (a < 0 || b < 0) {
            System.out.println("Negative values are not allowed.");
            scanner.close();
            return;
        }

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
            System.out.printf("Values swapped. New a: %s, New b: %s\n", a, b);
        }

        Random random = new Random();
        int oddCount = 0;
        int evenCount = 0;

        System.out.printf("Generated numbers between %s and %s: \n", a, b);
        for (int i = 0; i < 10; i++) {

            int number = random.nextInt(a, b);
            System.out.println(number);

            if (number % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Number of odd numbers: " + oddCount);
        System.out.println("Number of even numbers: " + evenCount);

        if (oddCount > evenCount) {
            System.out.println("Odd numbers occurred more frequently.");
        } else if (evenCount > oddCount) {
            System.out.println("Even numbers occurred more frequently.");
        } else {
            System.out.println("Odd and even numbers occurred equally.");
        }
    }
}
