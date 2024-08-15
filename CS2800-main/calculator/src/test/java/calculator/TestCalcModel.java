package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {

  CalcModel calcModel;

  @BeforeEach
  void createCalcModel() {
    this.calcModel = new CalcModel();
  }

  @Test
  void testStandard() throws InvalidExpressionException {
    assertEquals(this.calcModel.evaluate("( 5 * ( 6 + 7 ) ) - 2", true), 63,
        "With given expression with isInfix set to true should evaluate to 63");
  }
  
  @Test
  void testReversePolishNotation() throws InvalidExpressionException {
    assertEquals(this.calcModel.evaluate("2.2 4.7 9 * - 6.3 / 1 + 100 *", false), -536.51f,
        "With given expression with isInfix set to false should evaluate to -536.51");
  }

}
