package practical_2.task1;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimpleCalculator implements Calculator {
    private static final Logger logger = Logger.getLogger(SimpleCalculator.class.getName());

    public SimpleCalculator() {
        try {
            FileHandler fileHandler = new FileHandler("calculator.txt", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int add(int a, int b) {
        try {
            int result = a + b;
            logger.log(Level.INFO, "Adding {0} + {1} = {2}", new Object[]{a, b, result});
            return result;
        } catch (ArithmeticException e) {
            logger.log(Level.WARNING, "Arithmetic error in add operation", e);
            throw e;
        }
    }

    @Override
    public int subtract(int a, int b) {
        try {
            int result = a - b;
            logger.log(Level.INFO, "Subtracting {0} - {1} = {2}", new Object[]{a, b, result});
            return result;
        } catch (ArithmeticException e) {
            logger.log(Level.WARNING, "Arithmetic error in subtract operation", e);
            throw e;
        }
    }

    @Override
    public int multiply(int a, int b) {
        try {
            int result = a * b;
            logger.log(Level.INFO, "Multiplying {0} * {1} = {2}", new Object[]{a, b, result});
            return result;
        } catch (ArithmeticException e) {
            logger.log(Level.WARNING, "Arithmetic error in multiply operation", e);
            throw e;
        }
    }

    @Override
    public int divide(int a, int b) {
        try {
            int result = a / b;
            logger.log(Level.INFO, "Dividing {0} / {1} = {2}", new Object[]{a, b, result});
            return result;
        } catch (ArithmeticException e) {
            logger.log(Level.WARNING, "Arithmetic error in divide operation", e);
            throw e;
        }
    }
}
