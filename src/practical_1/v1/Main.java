package practical_1.v1;

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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        System.out.print("Enter book price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter file size of e-book (in KB): ");
        double fileSize = scanner.nextDouble();

        EBook ebook = new EBook(title, author, price, fileSize);

        System.out.println("Book Information: ");
        ebook.getBookInfo();

        System.out.println();
        System.out.print("Enter discount percentage: ");
        double discount = scanner.nextDouble();
        ebook.applyDiscount(discount);

        System.out.println();
        System.out.println("Increasing Price: ");
        System.out.print("Enter amount to increase: ");
        double increase = scanner.nextDouble();
        ebook.increasePrice(increase);
    }

    public static void task2() {
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
            System.out.println("Values swapped. New a: " + a + ", New b: " + b);
        }

        Random random = new Random();
        int evenCount = 0;
        int evenSum = 0;
        int maxNumber = Integer.MIN_VALUE;

        System.out.println("\nGenerated numbers between " + a + " and " + b + ": ");
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(b - a + 1) + a;
            System.out.print(number + " ");
            if (number % 2 == 0) {
                evenCount++;
                evenSum += number;
            }
            if (number > maxNumber) {
                maxNumber = number;
            }
        }

        String message = String.format("""
                
                Number of even numbers: %s
                Sum of even numbers: %s
                Largest number generated: %s
                """, evenCount, evenSum, maxNumber);

        System.out.println(message);

        if (maxNumber % 2 == 0) {
            System.out.println("The largest number is even.");
        } else {
            System.out.println("The largest number is odd.");
        }
    }
}
