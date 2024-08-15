package calculator;

/**Interface for views, any type of views must have a getExpr, setAns and getNotation method.
 *
 * @author callu
 *
 */
public interface ViewInterface {
  
  /**
   * Fetches given expression.
   *
   * @return expression
   */
  public String getExpr();
  
  /**
   * Sets the answer to calculated result of given expression, using evaluate method.
   *
   * @param ans answer
   */
  public void setAns(String ans);
  
  /**
   * Fetches expression type, either infix or postfix.
   *
   * @return true if infix, false if postfix
   */
  public boolean getNotation();

}
