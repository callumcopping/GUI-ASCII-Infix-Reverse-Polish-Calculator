package calculator;

import java.util.EmptyStackException;

/**A facade class of stack, only handles strings.
 *
 * @author Callum Copping
 *
 */
public class StrStack {
  private Cs2800Stack strStack = new Cs2800Stack();

  /**Returns size.
   *
   * @return size of stack
   */
  public int size() {
    return this.strStack.size();
  }

  /**Push string entry onto stack.
   *
   * @param s string passed in
   */
  public void push(String s) {
    this.strStack.push(new Cs2800Entry(s));
  }

  /**Returns and removes top string of stack.
   *
   * @return string removed from stack
   */
  public String pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    try {
      return this.strStack.pop().getString();
    } catch (BadTypeException e) {
      e.printStackTrace();
      return null;
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
}

