package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestSymbol {

  @Test // Test 1
  // Checks that symbols can be printed. To have this pass a toString method was created for the
  // Symbol ENUM.
  void testPrint() {
    assertEquals(Symbol.LEFT_BRACKET.toString(), "(");
    assertEquals(Symbol.RIGHT_BRACKET.toString(), ")");
    assertEquals(Symbol.TIMES.toString(), "*");
    assertEquals(Symbol.DIVIDE.toString(), "/");
    assertEquals(Symbol.PLUS.toString(), "+");
    assertEquals(Symbol.MINUS.toString(), "-");
    assertEquals(Symbol.INVALID.toString(), "Invalid symbol");
  }
}
