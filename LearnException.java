import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LearnException {

  private final static Logger logger = Logger.getLogger(LearnException.class.getName());

  public static void main(String[] args) {
    int x = 10;
    int y = 0;

    // LBYL
    // Check if denominator is zero
    // if (y == 0) {
    // System.out.println("Cannot divide by zero.");
    // } else {
    // int result = divide(x, y);
    // System.out.println(result);
    // }

    // EAFP
    // try {
    // int result = divide(x, y);
    // System.out.println(result);
    // } catch (ArithmeticException e) {
    // // Error handling code
    // System.out.println(e);
    // } finally {
    // System.out.println("This is the finally block.");
    // }

    try {
      Handler fileHandler = new FileHandler("myloglog.log", true);
      // Format the log messages
      SimpleFormatter formatter = new SimpleFormatter();
      fileHandler.setFormatter(formatter);
      // Add the handler to the logger
      logger.addHandler(fileHandler);
    } catch (IOException e) {
      System.out.println(e);
    }

    // Array Example
    int[] numbers = { 1, 2, 3, 4, 5 };
    int index = 5;

    int[] numArray = { 1, 2, 3, 4, -5 };
    // checkNegativeElement(numArray);

    try {
      checkNegativeElement(numArray);
      ;
    } catch (NoNegativeElementException e) {
      System.out.println(e.getMessage());
    }
    // LBYL
    // if (index >= 0 && index < numbers.length) {
    // System.out.println(numbers[index]);
    // } else {
    // System.out.println("Index is out of bounds.");
    // }

    // EAFP
    // try {
    // System.out.println(numbers[index]);
    // // The lines below will not run if an exception is thrown above
    // System.out.println("Numbers printed.");
    // } catch (ArrayIndexOutOfBoundsException e) {
    // System.out.println(e);
    // }

    // Scanner Example
    // Scanner scanner = new Scanner(System.in);
    // System.out.println("Enter a number: ");
    // int number = scanner.nextInt();
    // System.out.println("You have entered: " + number);

    // LBYL
    // if (scanner.hasNextInt()) {
    // int number = scanner.nextInt();
    // System.out.println("You have entered: " + number);
    // } else {
    // System.out.println("Input is not an integer.");
    // }

    // EAFP
    // try {
    // int number = scanner.nextInt();
    // System.out.println("You have entered: " + number);
    // } catch (InputMismatchException e) {
    // System.out.println(e);
    // }

    // scanner.close();

    // Checked Exceptions
    // try {
    // readFileFirstLine("test.txt");
    // } catch (FileNotFoundException e) {
    // System.out.println(e.getMessage());
    // }

  }

  // public static void readFileFirstLine(String filename) throws
  // FileNotFoundException {

  // // Create a new FileInputStream object
  // FileInputStream f = new FileInputStream(filename);
  // // Create a Scanner object and pass the FileInputStream object
  // Scanner s = new Scanner(f);
  // // Print the first line of the file
  // System.out.println(s.nextLine());
  // s.close();

  // }

  // public static int divide(int x, int y) {
  // return x / y;
  // }

  public static boolean checkNegativeElement(int[] numArray) throws NoNegativeElementException {
    for (int num : numArray) {
      if (num < 0) {
        throw new NegativeNumberException("Negative elements found.");
      }
    }
    System.out.println("no negative elements in your array");
    return true;
  }

}
