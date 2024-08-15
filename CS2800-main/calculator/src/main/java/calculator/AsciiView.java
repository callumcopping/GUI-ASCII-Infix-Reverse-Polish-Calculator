package calculator;

import java.util.Scanner;

/**
 * ASCII view, shows user options and allows them to select it with a text input ranging from 1-5.
 * Saves expression in variable expression to allow user to swap modes and still be able to
 * calculate.
 *
 * @author Callum Copping
 *
 */
public class AsciiView implements ViewInterface {
  private Scanner userInput = new Scanner(System.in);
  boolean infix = true;

  /**
   * Prints menu for user to use calculator in desired mode.
   * 
   */
  public void menu() {
    // Initialisation of variables needed for calculator
    CalcModel calc = new CalcModel();
    String expression = null;
    String choice;
    String result;
    boolean finishedRunning = false;
    // Prints options to user
    printHelp();
    
    // Loop until user choice is to exit to calculator
    while (finishedRunning == false && userInput.hasNext() == true) {
      choice = userInput.nextLine();
      switch (choice) {
        case "1":
          System.out.print("Please input expression: ");
          expression = getExpr();
          break;
        case "2":
          System.out.println("Set to infix mode");
          infix = true;
          break;
        case "3":
          System.out.println("Set to reverse polish mode");
          infix = false;
          break;
        case "4":
          try {
            result = Float.toString(calc.evaluate(expression, getNotation()));
          } catch (InvalidExpressionException e) {
            result = e.getMessage();
          }
          setAns(result);
          break;
        case "5":
          System.out.println("Bye bye <3");
          finishedRunning = true;
          break;
        default:
          System.out.println("Invalid input please input one of the options");
          printHelp();
          break;
      }
    }
    // Close scanner to stop resource leaks/
    userInput.close();
  }

  /**
   * Prints all options that user can use alongside the number they need to select for the option.
   * 
   */
  private void printHelp() {
    System.out.println("Welcome to the calculator:");
    System.out.println("Note: Calculator is set to infix mode on launch");
    System.out.println("1. Set expression");
    System.out.println("2. Set to infix mode");
    System.out.println("3. Set to reverse polish mode");
    System.out.println("4. Calculate expression");
    System.out.println("5. Quit calculator");

  }

  @Override
  public String getExpr() {
    return userInput.nextLine();
  }

  @Override
  public void setAns(String ans) {
    System.out.println("-------------------------------------------------------------------------");
    System.out.println(ans);
    System.out.println("-------------------------------------------------------------------------");
  }

  @Override
  public boolean getNotation() {
    return infix;
  }

}
