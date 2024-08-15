package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Stores entry values in a stack format. Partially inspired from Dave Cohen's TDD video.
 *
 * @author Callum Copping
 *
 */
public class Cs2800Stack {

  private ArrayList<Cs2800Entry> val = new ArrayList<Cs2800Entry>();
  private Cs2800Entry temp;
  private int size;

  /**
   * Returns the size of the stack, will always return regardless of size, so a stack with a size of
   * zero will still return.
   *
   * @return size stack size as an integer
   */
  public int size() {
    size = val.size();
    return size;
  }
  
  /**
   * Returns index of top item in the stack.
   *
   * @return index of top of stack
   */
  public int getTopIndex() {
    // Minus one from size as index of ArrayList starts at 0. e.g. if size equals 4, the top entry
    // of the stack would be at index 3.
    return size() - 1;
  }

  /**
   * Adds an entry onto the stack. Values are added onto the top of the stack.
   *
   * @param i value being added to stack
   */
  public void push(Cs2800Entry i) {
    val.add(i);
  }

  /**
   * Removes top item of a stack and returns said value.
   *
   * @return value removed from the stack.
   */
  public Cs2800Entry pop() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    temp = val.get(getTopIndex());
    val.remove(getTopIndex());
    return temp;
  }

  /**
   * Returns value on top of stack without removing it.
   *
   * @return value at top of stack.
   */
  public Cs2800Entry top() {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return val.get(getTopIndex());
  }
}
