package calculator;

import java.util.EmptyStackException;

/**A facade class of stack, only handles floats.
 *
 * @author Callum Copping
 *
 */
public class NumStack {
  private Cs2800Stack numStack = new Cs2800Stack();

  /**Returns size.
   *
   * @return size of stack
   */
  public int size() {
    return this.numStack.size();
  }

  /**Push float entry onto stack.
   *
   * @param f float passed in
   */
  public void push(float f) {
    this.numStack.push(new Cs2800Entry(f));
  }

  /**Returns and removes top float of stack.
   *
   * @return removed float
   */
  public float pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    try {
      return this.numStack.pop().getValue();
    } catch (BadTypeException e) {
      e.printStackTrace();
      return 0;
    }
  }

  /**Method for checking if stack is empty.
   *
   * @return true or false depending on if stack is empty
   */
  public boolean isEmpty() {
    if (size() == 0) {
      return true;
    }
    return false;
  }

}
