package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {
  private Cs2800Stack stack;
  private Cs2800Entry entry;
  private Cs2800Entry entry2;

  // All tests were initially done with integers before the entry class was created, upon creating
  // the entry class they were changed to float based entries. The changes required to make
  // tests pass upon changing this was adding .getvalue() to all calls of pop() and top().
  // As well as casting i and j to be floats in pushLots() and pushLotsThenPopLots().

  @BeforeEach
  public void stackSetup() {
    stack = new Cs2800Stack();
    entry = new Cs2800Entry(2.5f);
    entry2 = new Cs2800Entry(.089f);
  }

  @Test // Test 1
  // Checks that the method size() returns 0 on an empty stack. Was originally faked by having
  // size() always return 0. Upon adjustments to the code size() was done via the .length method.
  // Upon swapping from an array to an ArrayList adjusting the size() method this was done with the
  // built in .size() method of the ArrayList class.
  void testSize() {
    assertEquals(stack.size(), 0, "A newly created stack should have a size of 0");
  }

  @Test // Test 2
  // Checks that the method size() returns 1. Was originally faked by having push() method increase
  // the size by 1.
  void testPush() {
    stack.push(entry);
    assertEquals(stack.size(), 1, "Pushing onto a new stack the size should be 1");
  }

  @Test // Test 3
  // Checks that upon calling pop method on an empty stack that an EmptyStackException is thrown,
  // this was done via an if statement in pop that checks if the size is 0.
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> stack.pop(), "Can't pop an empty stack");
  }

  @Test // Test 4
  // Checks that upon pushing then popping the correct value is returned and then the size is
  // decreased to 0, also checks that a second pop would throw a EmptyStackException.
  // Was initially faked by having pop() return a hard coded value and the size
  // being decreased by 1 to 0. The pop method was then adjusted as described in comment below.
  void pushThenPop() throws BadTypeException {
    stack.push(entry);
    assertEquals(stack.pop().getValue(), 2.5f,
        "Pushing an entry then popping should return the entry's value");
    assertEquals(stack.size(), 0, "Pushing then popping should return size 0");
    assertThrows(EmptyStackException.class, () -> stack.pop(),
        "Pushing then popping twice should throw an exception");
  }

  @Test // Test 5
  // Checks that upon pushing twice then popping twice the correct values in the correct order are
  // returned and the size decreases to 0. At this point the pop method needed to be changed to
  // return the top of the array, this was done by taking 1 away from the size and returning the
  // value at that index.
  // Upon implementing ArrayList the .get() method of the ArrayList class was implemented instead.
  void pushTwice() throws BadTypeException {
    stack.push(entry);
    stack.push(entry2);
    assertEquals(stack.size(), 2, "Pushing twice should make the size 2");
    assertEquals(stack.pop().getValue(), .089f,
        "Pushing an two entries then popping should return the 2nd entry's value");
    assertEquals(stack.pop().getValue(), 2.5f,
        "Pushing an two entries then popping should return the 1st entry's value");
    assertEquals(stack.size(), 0, "Pushing twice then popping twice should return size 0");
  }

  @Test // Test 6
  // Checks that unlimited entries can be added as specified in the mark scheme. To have this pass
  // stack was changed from an array to an ArrayList.
  void pushLots() throws BadTypeException {
    for (int i = 0; i < 1001; i++) {
      stack.push(new Cs2800Entry((float) i));
      assertEquals(stack.size(), i + 1,
          "Each push should incrementily increase the size of the stack");
    }
  }

  @Test // Test 7
  // Checks that pop works regardless of how big the stack is, no changes were made to have this
  // pass.
  void pushLotsThenPopLots() throws BadTypeException {
    for (int i = 0; i < 1001; i++) {
      stack.push(new Cs2800Entry((float) i));
      assertEquals(stack.size(), i + 1,
          "Each push should incrementily increase the size of the stack");
    }
    for (int j = 1001; j > 0; j--) {
      assertEquals(stack.pop().getValue(), (float) j - 1,
          "Popping back through the stack should return the value incremently decreaseing from "
              + "1001 downwards");
    }
    assertEquals(stack.size(), 0, "Popping 1001 times should result in a stack of size 0");
  }

  @Test // Test 8
  // Checks that upon calling top method on an empty stack that an EmptyStackException is thrown,
  // this was done via an if statement in top that checks if the size is 0.
  void testTop() {
    assertThrows(EmptyStackException.class, () -> stack.top(), "Can't top an empty stack");
  }

  @Test // Test 9
  // Checks that upon pushing then topping that the pushed value is returned and the size doesn't
  // decrease. This was done by implementing similar code to that in the pop method but without the
  // .remove().
  void pushThenTop() throws BadTypeException {
    stack.push(entry);
    assertEquals(stack.top().getValue(), 2.5f,
        "After pushing once top value should match pushed entry's value");
    assertEquals(stack.size(), 1, "Top dosent remove item so size should still be 1");
  }

  @Test // Test 10
  // Checks that top and pop work together, no changes were made to have this pass.
  void pushTwiceThenPopThenTop() throws BadTypeException {
    stack.push(entry);
    stack.push(entry2);
    assertEquals(stack.size(), 2, "Pushing twice should make the size 2");
    assertEquals(stack.pop().getValue(), .089f,
        "Pushing twice then popping should return 2nd entry's value");
    assertEquals(stack.top().getValue(), 2.5f,
        "After pushing twice then popping top value should match 1st pushed entry's value");
    assertEquals(stack.size(), 1, "Top dosent remove item so size should still be 1");

  }

}
