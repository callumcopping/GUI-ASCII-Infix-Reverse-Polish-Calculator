package calculator;

/**
 * Infix calculator, takes given expression in infix and converts it to RPN, then uses
 * RevPolishCalculator to calculate result ,returns result as a float. Throws exception when invalid
 * expression is used.
 *
 * @author Callum Copping
 *
 */
public class StandardCalculator implements Calculator {

  /**
   * Evaluates a given infix expression and returns the result.
   *
   * @param calcString the expression given in infix
   * @return result of evaluation
   * @throws InvalidExpressionException if the expression is invalid
   */
  public float evaluate(String calcString) throws InvalidExpressionException {
    // Check if given string is null or empty, if it is throw exception
    if (calcString == null || calcString == "") {
      throw new InvalidExpressionException("Invalid expression: Can't calculate null/empty input");
    }

    // Split expression into individual parts by whitespace
    String[] calcInput = calcString.split(" ");
    if (calcInput.length == 0) {
      throw new InvalidExpressionException("Invalid expression: Can't calculate null/empty input");
    }

    // Check that the last value of expression is either a number or a ), if not throw exception
    if (!isFloat(calcInput[calcInput.length - 1]) && !calcInput[calcInput.length - 1].equals(")")) {
      throw new InvalidExpressionException(
          "Invalid expression: Infix expressions must end in a number or )");
    }

    // Create RPN calc to evaluate expression
    final RevPolishCalculator rpCalc = new RevPolishCalculator();
    // Create two stacks, one for holding the output, one for holding operators
    OpStack opStack = new OpStack();
    StrStack outputStack = new StrStack();
    // Create empty string to store RPN conversion of expression
    String rpString = "";
    // Set initial precedence to 0
    int precedence = 0;

    // Iterate over elements of expression
    for (int i = 0; i < calcInput.length; i++) {
      String cur = calcInput[i];
      if (isFloat(cur)) {
        // If current element is float push to output stack
        outputStack.push(cur);
      } else {
        switch (cur) {
          case "+":
            if (precedence >= 2 && precedence != 0 && opStack.size() != 0) {
              outputStack.push(opStack.pop().toString());
              opStack.push(Symbol.PLUS);
              precedence = 2;
            } else {
              opStack.push(Symbol.PLUS);
              precedence = 2;
            }
            break;
          case "-":
            if (precedence >= 2 && precedence != 0 && opStack.size() != 0) {
              outputStack.push(opStack.pop().toString());
              opStack.push(Symbol.MINUS);
              precedence = 2;
            } else {
              opStack.push(Symbol.MINUS);
              precedence = 2;
            }
            break;
          case "*":
            if (precedence >= 3 && precedence != 0 && opStack.size() != 0) {
              outputStack.push(opStack.pop().toString());
              opStack.push(Symbol.TIMES);
              precedence = 3;
            } else {
              opStack.push(Symbol.TIMES);
              precedence = 3;
            }
            break;
          case "/":
            if (precedence >= 3 && precedence != 0 && opStack.size() != 0) {
              outputStack.push(opStack.pop().toString());
              opStack.push(Symbol.DIVIDE);
              precedence = 3;
            } else {
              opStack.push(Symbol.DIVIDE);
              precedence = 3;
            }
            break;
          case "(":
            // If left bracket is detected push to opStack and set
            // precedence to 0 so the bracket isn't pushed to output stack.
            opStack.push(Symbol.LEFT_BRACKET);
            precedence = 0;
            break;
          case ")":
            // If a right bracket is detected, loop until a left bracket is found, pushing all
            // values from opStack onto outputStack.
            while (!opStack.isEmpty() && opStack.top() != Symbol.LEFT_BRACKET) {
              outputStack.push(opStack.pop().toString());
            }
            // If after this loop opStack is empty, no left bracket was detected so expression is
            // unbalanced, throw exception.
            if (opStack.isEmpty()) {
              throw new InvalidExpressionException("Invalid expression: Unbalanced brackets");
            } else {
              // Discard remaining bracket.
              opStack.pop();
            }
            break;
          default:
            // Nothing needs to be done in default case as error handling is done in RP calculator.
            break;
        }
      }
    }

    // Take all elements from opStack and push to output stack.
    while (!opStack.isEmpty()) {
      // If a left bracket is detected, that means there was no right/closing bracket so expression
      // is unbalanced, so throw exception
      if (opStack.top() == Symbol.LEFT_BRACKET) {
        throw new InvalidExpressionException("Invalid expression: Unbalanced brackets");
      } else {
        outputStack.push(opStack.pop().toString());
      }
    }

    // Concatenate outputStack into string to be passed to rpCalc.
    while (!outputStack.isEmpty()) {
      rpString = outputStack.pop() + " " + rpString;
    }

    return rpCalc.evaluate(rpString);
  }

  /**
   * Method for checking if a value is a float.
   *
   * @param cur current value being checked
   * @return true or false depending on if cur can be parsed as a float
   */
  public boolean isFloat(String cur) {
    try {
      Float.parseFloat(cur);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
