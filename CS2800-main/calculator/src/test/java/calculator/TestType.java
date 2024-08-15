package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestType {

  @Test //Test 1
  // Checks that types can be printed. To have this pass a toString method was created for the
  // type ENUM.
  void test() {
    assertEquals(Type.NUMBER.toString(), "Number type");
    assertEquals(Type.SYMBOL.toString(), "Symbol type");
    assertEquals(Type.STRING.toString(), "String type");
    assertEquals(Type.INVALID.toString(), "Invalid type");
  }

}
