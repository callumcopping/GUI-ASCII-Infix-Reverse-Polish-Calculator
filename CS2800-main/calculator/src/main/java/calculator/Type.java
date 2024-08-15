package calculator;

/**ENUM for the different types the calculator can take.
 *
 * @author Callum Copping
 *
 */
public enum Type {
  /**Number type.*/
  NUMBER("Number type"),
  /**Symbol type.*/
  SYMBOL("Symbol type"),
  /**String type.*/
  STRING("String type"),
  /**Invalid type.*/
  INVALID("Invalid type");
  
  private String string;
  
  /** Constructor for string format of type ENUM.
  *
  * @param symbol textual description of type
  */
  Type(String type) {
    string = type;
  }
  
  /** To string method.*/
  @Override
  public String toString() {
    return string;
  }
}
