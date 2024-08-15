package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestReversePolish {

  public Calculator calc;

  @BeforeEach
  void createCalc() {
    calc = (Calculator) new RevPolishCalculator();
  }

  @Test
  void testOneValue() throws InvalidExpressionException {
    assertEquals(calc.evaluate("6"), 6.0, "Single value passed should return the inputted value");
  }

  @Test
  void testAddition() throws InvalidExpressionException {
    assertEquals(calc.evaluate("1 2 +"), 3, "Should evaluate to 1+2 which should result in 3");
  }

  @Test
  void testSubtraction() throws InvalidExpressionException {
    assertEquals(calc.evaluate("12 10 -"), 2, "Should evaluate to 12-10 which should result in 2");
  }

  @Test
  void testTimes() throws InvalidExpressionException {
    assertEquals(calc.evaluate("10 10 *"), 100,
        "Should evaluate to 10*10 which should result in 100");
  }

  @Test
  void testDivide() throws InvalidExpressionException {
    assertEquals(calc.evaluate("75 2 /"), 37.5,
        "Should evaluate to 75/2 which should result in 37.5");
  }

  @Test
  void testComplicated() throws InvalidExpressionException {
    assertEquals(calc.evaluate("2.2 4.7 9 * - 6.3 / 1 + 100 *"), -536.51f);
  }

  @Test
  void testEmpty() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(""));
  }

  @Test
  void testTwoNumsNoOp() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("1 1"));
  }

  @Test
  void testInvalidOperator() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("1 1 ?"));
  }

  @Test
  void testWrongOrder() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("5 + 3"));
  }
}
