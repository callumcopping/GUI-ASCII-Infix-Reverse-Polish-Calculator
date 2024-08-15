package calculator;

/**
 * Reverse polish calculator, takes given expression in RPN and calculates its result, returns
 * result as a float. Throws exception when invalid expression is used.
 *
 * @author Callum Copping
 *
 */
public class RevPolishCalculator implements Calculator {
  /**
   * Evaluates a given reverse Polish expression and returns the result.
   *
   * @param calcString the expression given in RPN
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

    // Create a new stack to hold numbers
    NumStack calcStack = new NumStack();

    // Iterate over elements of expression
    for (int i = 0; i < calcInput.length; i++) {
      String cur = calcInput[i];
      if (isFloat(cur)) {
        // If current element is a float push to stack
        calcStack.push(Float.parseFloat(cur));
      } else {
        // Otherwise perform maths operation
        calcStack.push(mathOperations(cur, calcStack));
      }
    }

    // Check if the stack contains more than 1 element, if so expression is unbalanced so thrown an
    // exception
    if (calcStack.size() > 1) {
      throw new InvalidExpressionException("Invalid expression: Unbalanced expression");
    } else {
      // Otherwise, round result to 2 DP and return it
      return (float) (Math.round(calcStack.pop() * 100.0) / 100.0);
    }
  }

  /**
   * Method for doing maths operations on stack.
   *
   * @param symbol current value in split array of calcString
   * @param calcStack numStack to allow get numbers for operations
   * @return result of operation
   * @throws InvalidExpressionException if the expression is invalid
   */
  public float mathOperations(String symbol, NumStack calcStack) throws InvalidExpressionException {
    float rightOfExpression;
    float leftOfExpression;

    // Check if the stack has at least two elements, if not throw an exception.
    if (calcStack.size() < 2) {
      throw new InvalidExpressionException("Invalid expression: Unbalanced expression");
    }

    // Pop the last two elements from the stack and store them.
    rightOfExpression = calcStack.pop();
    leftOfExpression = calcStack.pop();

    // Use a switch statement to perform the appropriate operation.
    switch (symbol) {
      case "+":
        return leftOfExpression + rightOfExpression;
      case "-":
        return leftOfExpression - rightOfExpression;
      case "*":
        return leftOfExpression * rightOfExpression;
      case "/":
        // Check if the right operand is zero, if so throw an exception.
        if (rightOfExpression == 0) {
          throw new InvalidExpressionException("Invalid expression: Division by zero");
        }
        return leftOfExpression / rightOfExpression;
      default:
        // If the value of "symbol" is not a recognised symbol, throw an exception.
        throw new InvalidExpressionException("Invalid expression: Unknown symbol");
    }
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
