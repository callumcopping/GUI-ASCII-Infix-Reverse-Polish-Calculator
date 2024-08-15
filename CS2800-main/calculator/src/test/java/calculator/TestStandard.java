package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandard {

  public Calculator calc;

  @BeforeEach
  void createCalc() {
    calc = (Calculator) new StandardCalculator();
  }

  @Test
  void testOneValue() throws InvalidExpressionException {
    assertEquals(calc.evaluate("6"), 6.0, "Single value passed should return the inputted value");
  }

  @Test
  void testAddition() throws InvalidExpressionException {
    assertEquals(calc.evaluate("2 + 4"), 6.0, "Should evaluate to 6");
  }

  @Test
  void testSubtraction() throws InvalidExpressionException {
    assertEquals(calc.evaluate("24 - 10"), 14, "Should evaluate to 14");
  }

  @Test
  void testTimes() throws InvalidExpressionException {
    assertEquals(calc.evaluate("10 * 10"), 100, "Should evaluate to 100");
  }

  @Test
  void testDivide() throws InvalidExpressionException {
    assertEquals(calc.evaluate("25 / 5"), 5, "Should evaluate to 5");
  }

  @Test
  void testPrecedence() throws InvalidExpressionException {
    assertEquals(calc.evaluate("7 - 2 + 5  * 6"), 35.0, "Should evaluate to 35");
  }

  @Test
  void testBrackets() throws InvalidExpressionException {
    assertEquals(calc.evaluate("52 + ( 1 + 2 ) * 4 - 3"), 61, "Should evaluate to 61");
  }
  
  @Test
  void testExample() throws InvalidExpressionException {
    assertEquals(calc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63, "Should evaluate to 63");
  }

  @Test
  void testWrongOrder() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("12 7 *"));
  }
  
  @Test
  void testUnbalancedBrackets() throws InvalidExpressionException {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("( 1 + 3"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("4 / 9 )"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("( 6 * 6 ) )"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("( ( 6 * 6 )"));
  }
  
}
