package practical_2.task1;

public class CalculatorApp {
    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();

        calculator.add(10, 5);
        calculator.subtract(10, 5);
        calculator.multiply(10, 5);
        calculator.divide(10, 0);
    }
}
