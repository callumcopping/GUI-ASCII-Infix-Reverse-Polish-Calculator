package calculator;

/**
 * Exception to be thrown when the expression inputed is invalid.
 *
 * @author Callum Copping
 *
 */
public class InvalidExpressionException extends Exception {
  /**Auto generated serial ID.*/
  private static final long serialVersionUID = 1L;

  /** Produces readable message for when exception is thrown.
   *
   * @param errorMessages error message passed from exception calls.
   */
  public InvalidExpressionException(String errorMessages) {
    super(errorMessages);
  }
}
