package calculator;

/**Interface for calculator, any type of calculator must have an evaluate method.
 *
 * @author Callum Copping
 *
 */
public interface Calculator {
  /**Method for evaluating expression.
   *
   * @param calcString expression to be calculated
   * @return calculated result from given expression
   */
  float evaluate(String calcString) throws InvalidExpressionException;
}
