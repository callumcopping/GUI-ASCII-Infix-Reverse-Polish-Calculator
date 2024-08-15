package calculator;

/**
 * Driver class for views to run.
 *
 * @author Callum Copping
 *
 */
public class Driver {

  /**
   * Decides if program should be ran in GUI or ASCII depending on the amount of command line
   * arguments.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    if (System.console() == null) {
      AsciiView asciiView = new AsciiView();
      asciiView.menu();
    } else {
      Launch.main(args);
    }
  }
}
