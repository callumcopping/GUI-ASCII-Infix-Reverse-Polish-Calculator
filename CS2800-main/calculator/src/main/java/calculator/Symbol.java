package calculator;

/**
 * ENUM for the different symbols the calculator can take.
 *
 * @author Callum Copping
 *
 */
public enum Symbol {
  /**Left bracket symbol.*/
  LEFT_BRACKET("("),
  /**Right bracket symbol.*/
  RIGHT_BRACKET(")"),
  /**Times symbol.*/
  TIMES("*"),
  /**Divide symbol.*/
  DIVIDE("/"), 
  /**Plus symbol.*/
  PLUS("+"),
  /**Minus symbol.*/
  MINUS("-"),
  /**Invalid symbol.*/
  INVALID("Invalid symbol");

  private String string;

  /** Constructor for string format of symbol ENUM.
   *
   * @param symbol textual description of symbol
   */
  Symbol(String symbol) {
    string = symbol;
  }

  /** To string method.*/
  @Override
  public String toString() {
    return string;
  }

}
