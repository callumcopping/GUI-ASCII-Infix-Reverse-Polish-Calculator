package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {
  private NumStack ns;
  
  @BeforeEach
  void createNumStack() {
    ns = new NumStack();
  }
  
  @Test
  void stackCreation() {
    assertEquals(ns.size(), 0, "A newly created stack should have a size of 0");
  }
  
  @Test
  void testPush() {
    ns.push(0.5f);
    assertEquals(ns.size(), 1, "A stack should have a size 1 after a push");
  }
  
  @Test
  void testEmptyPop() {
    assertThrows(EmptyStackException.class, () -> ns.pop(), "Can't pop an empty stack");
  }
  
  @Test
  void testPop() {
    ns.push(0.5f);
    assertEquals(ns.size(), 1, "A stack should have a size 1 after a push");
    assertEquals(ns.pop(), 0.5f, "Pushing 0.5 should return 0.5 when popped");
    assertEquals(ns.size(), 0, "After popping size should be 0");
  }
  
  @Test
  void testPushPushPopPop() {
    ns.push(0.5f);
    ns.push(0.9f);
    assertEquals(ns.size(), 2, "A stack should have a size 2 after 2 pushes");
    assertEquals(ns.pop(), 0.9f, "Popping should return top value");
    assertEquals(ns.size(), 1, "A stack should have a size 1 after 2 pushes and popping once");
    assertEquals(ns.pop(), 0.5f, "Popping should return top value (1st value pushed)");
    assertEquals(ns.size(), 0, "After popping twice size should be 0");
  }
  
  @Test
  void testIsEmpty() {
    assertEquals(ns.isEmpty(), true, "Empty stack should return true");
    ns.push(0.5f);
    assertEquals(ns.isEmpty(), false, "Stack that has been pushed should return false");
    ns.pop();
    assertEquals(ns.isEmpty(), true, "Empty stack should return true");
  }
}
