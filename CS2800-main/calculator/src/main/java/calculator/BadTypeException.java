package calculator;

/**
 * Exception to be thrown when the wrong type is used in a method.
 *
 * @author Callum Copping
 *
 */
public class BadTypeException extends Exception {

  /**Auto generated serial ID.*/
  private static final long serialVersionUID = 1L;

  /** Produces readable message for when exception is thrown.
   *
   * @param errorMessages error message passed from exception calls.
   */
  public BadTypeException(String errorMessages) {
    super(errorMessages);
  }

}
