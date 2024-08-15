package calculator;

/**Model used to control calculators, runs either StandardCalc or ReversePolishCalc.
 *
 * @author Callum Copping
 *
 */
public class CalcModel {

  private StandardCalculator infixCalc = new StandardCalculator();
  private RevPolishCalculator postfixCalc = new RevPolishCalculator();

  /**Method for evaluating given expression.
   *
   * @param expression given expression
   * @param isInfix determines if expression is infix or RPN
   * @return result of expression evaluation
   * @throws InvalidExpressionException thrown upon invalid expression being thrown
   */
  public float evaluate(String expression, boolean isInfix) throws InvalidExpressionException {
    if (isInfix) {
      return this.infixCalc.evaluate(expression);
    } else {
      return this.postfixCalc.evaluate(expression);
    }
  }

}
