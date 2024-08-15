package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {

  private StrStack ss;

  @BeforeEach
  void createStrStack() {
    ss = new StrStack();
  }

  @Test
  void stackCreation() {
    assertEquals(ss.size(), 0, "A newly created stack should have a size of 0");
  }

  @Test
  void testPush() {
    ss.push("test");
    assertEquals(ss.size(), 1, "A stack should have a size 1 after a push");
  }

  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> ss.pop(), "Can't pop an empty stack");
  }

  @Test
  void testPop() {
    ss.push("test");
    assertEquals(ss.size(), 1, "A stack should have a size 1 after a push");
    assertEquals(ss.pop(), "test", "Pushing string test should return string when popped");
    assertEquals(ss.size(), 0, "After popping size should be 0");
  }

  @Test
  void testPushPushPopPop() {
    ss.push("test1");
    ss.push("test2");
    assertEquals(ss.size(), 2, "A stack should have a size 2 after 2 pushes");
    assertEquals(ss.pop(), "test2", "Popping should return top value");
    assertEquals(ss.size(), 1, "A stack should have a size 1 after 2 pushes and popping once");
    assertEquals(ss.pop(), "test1", "Popping should return top value (1st value pushed)");
    assertEquals(ss.size(), 0, "After popping twice size should be 0");
  }

  @Test
  void testIsEmpty() {
    assertEquals(ss.isEmpty(), true, "Empty stack should return true");
    ss.push("test");
    assertEquals(ss.isEmpty(), false, "Stack that has been pushed should return false");
    ss.pop();
    assertEquals(ss.isEmpty(), true, "Empty stack should return true");
  }
}
