import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerDemo {
  private final static Logger logger = Logger.getLogger(LoggerDemo.class.getName());

  public static void main(String[] args) {

    try {
      Handler fileHandler = new FileHandler("mylog.log", true);
      // Format the log messages
      SimpleFormatter formatter = new SimpleFormatter();
      fileHandler.setFormatter(formatter);
      // Add the handler to the logger
      logger.addHandler(fileHandler);
    } catch (IOException e) {
      System.out.println(e);
    }

    logger.info("🟢 APP STARTED!");
    // logger.log(Level.SEVERE, "🔴 This is a severe message.");
    // logger.log(Level.WARNING, "🟠 This is a warning message.");
    // logger.log(Level.INFO, "🟢 This is an info message.");
    logger.severe("🔴 This is a severe message.");
    logger.warning("🟠 This is a warning message.");
    logger.info("🟢 This is an info message.");

    int[] arr1 = { 1, 2, 3, 4 };

    try {
      System.out.println(arr1[4]);
    } catch (ArrayIndexOutOfBoundsException e) {
      logger.severe("🔴 " + e.getMessage());
      System.out.println(e);
    } finally {
      logger.warning("🟠 Be careful!");
    }

  }

}
