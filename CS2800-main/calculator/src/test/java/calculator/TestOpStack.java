package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {

  private OpStack os;

  @BeforeEach
  void createNumStack() {
    os = new OpStack();
  }

  @Test
  void stackCreation() {
    assertEquals(os.size(), 0, "A newly created stack should have a size of 0");
  }

  @Test
  void testPush() {
    os.push(Symbol.TIMES);
    assertEquals(os.size(), 1, "A stack should have a size 1 after a push");
  }

  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> os.pop(), "Can't pop an empty stack");
  }

  @Test
  void testPop() {
    os.push(Symbol.DIVIDE);
    assertEquals(os.size(), 1, "A stack should have a size 1 after a push");
    assertEquals(os.pop(), Symbol.DIVIDE, "Pushing divide should return divide when popped");
    assertEquals(os.size(), 0, "After popping size should be 0");
  }

  @Test
  void testPushPushPopPop() {
    os.push(Symbol.PLUS);
    os.push(Symbol.MINUS);
    assertEquals(os.size(), 2, "A stack should have a size 2 after 2 pushes");
    assertEquals(os.pop(), Symbol.MINUS, "Popping should return top value");
    assertEquals(os.size(), 1, "A stack should have a size 1 after 2 pushes and popping once");
    assertEquals(os.pop(), Symbol.PLUS, "Popping should return top value (1st value pushed)");
    assertEquals(os.size(), 0, "After popping twice size should be 0");
  }

  @Test
  void testIsEmpty() {
    assertEquals(os.isEmpty(), true, "Empty stack should return true");
    os.push(Symbol.TIMES);
    assertEquals(os.isEmpty(), false, "Stack that has been pushed should return false");
    os.pop();
    assertEquals(os.isEmpty(), true, "Empty stack should return true");
  }

}
