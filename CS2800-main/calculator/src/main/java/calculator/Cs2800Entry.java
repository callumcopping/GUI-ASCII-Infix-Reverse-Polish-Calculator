package calculator;

import java.util.Objects;

/**
 * Class for constructing entries to be used in calculator.
 *
 * @author Callum Copping
 *
 */
public class Cs2800Entry {
  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Constructor for float based entries. Assigns them to type number.
   *
   * @param value float passed in
   */
  public Cs2800Entry(float value) {
    this.number = value;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor for string based entries. Assigns them to type string.
   *
   * @param string string passed in
   */
  public Cs2800Entry(String string) {
    this.str = string;
    this.type = Type.STRING;
  }

  /**
   * Constructor for symbol based entries. Assigns them to type symbol.
   *
   * @param which symbol passed in
   */
  public Cs2800Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Returns entry type.
   *
   * @return the entry's type as an ENUM.
   */
  public Type getType() {
    return this.type;
  }

  /**
   * Returns entry's string.
   *
   * @return string of entry
   * @throws BadTypeException throws exception if method is called on an entry that isn't a string
   *         type
   */
  public String getString() throws BadTypeException {
    if (this.getType() != Type.STRING) {
      throw new BadTypeException("Incorrect type : " + getType().toString());
    }
    return this.str;
  }

  /**
   * Returns entry's symbol.
   *
   * @return symbol of entry
   * @throws BadTypeException throws exception if method is called on an entry that isn't a symbol
   *         type
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.getType() != Type.SYMBOL) {
      throw new BadTypeException("Incorrect type : " + getType().toString());
    }
    return this.other;
  }

  /**
   * Returns entry's float.
   *
   * @return float of entry
   * @throws BadTypeException throws exception if method is called on an entry that isn't a float
   *         type
   */
  public float getValue() throws BadTypeException {
    if (this.getType() != Type.NUMBER) {
      throw new BadTypeException("Incorrect type : " + getType().toString());
    }
    return this.number;
  }

  /**Eclipse auto-generated hashcode method.*/
  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  /**Eclipse auto-generated equals method.*/
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Cs2800Entry other = (Cs2800Entry) obj;
    return Float.floatToIntBits(number) == Float.floatToIntBits(other.number)
        && this.other == other.other && Objects.equals(str, other.str) && type == other.type;
  }
}
