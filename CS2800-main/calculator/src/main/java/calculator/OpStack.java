package calculator;

import java.util.EmptyStackException;

/**A facade class of stack, only handles operators, represented with symbol ENUM.
 *
 * @author Callum Copping
 *
 */
public class OpStack {
  private Cs2800Stack opStack = new Cs2800Stack();

  /**Returns size.
   *
   * @return size of stack
   */
  public int size() {
    return this.opStack.size();
  }

  /**Push symbol entry onto stack.
   *
   * @param s symbol passed in
   */
  public void push(Symbol s) {
    this.opStack.push(new Cs2800Entry(s));
  }

  /**Returns and removes top symbol of stack.
   *
   * @return symbol from ENUM symbol
   */
  public Symbol pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    try {
      return this.opStack.pop().getSymbol();
    } catch (BadTypeException e) {
      e.printStackTrace();
      return Symbol.INVALID;
    }
  }

  /**Method for checking if stack is empty.
   *
   * @return t or f depending on if stack is empty
   */
  public boolean isEmpty() {
    if (size() == 0) {
      return true;
    }
    return false;
  }
  
  /**
   * Returns value on top of stack without removing it.
   *
   * @return symbol at top of stack.
   */
  public Symbol top() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    try {
      return this.opStack.top().getSymbol();
    } catch (BadTypeException e) {
      return Symbol.INVALID;
    }
  }
}
