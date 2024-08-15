package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestCalcInterface {
  
  public Calculator calc;

  @Test
  void testRevPol() throws InvalidExpressionException {
    calc = (Calculator) new RevPolishCalculator();
    assertEquals(calc.evaluate("5 6 +"), 11, "Faked");
  }
  
  @Test
  void testStandard() throws InvalidExpressionException {
    calc = (Calculator) new StandardCalculator();
    assertEquals(calc.evaluate("5 + 6"), 11, "Faked");
  }
  
  @Test
  void testRevPolThrow() throws InvalidExpressionException {
    calc = (Calculator) new RevPolishCalculator();
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(null));
  }
  
  @Test
  void testStandardThrow() throws InvalidExpressionException {
    calc = (Calculator) new StandardCalculator();
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(null));
  }

}
