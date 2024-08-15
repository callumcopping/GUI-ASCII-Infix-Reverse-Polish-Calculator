package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * Graphical interface for calculator application.
 *
 * @author Callum Copping
 *
 */
public class GuiView implements ViewInterface {

  boolean infix = true;
  String result;

  @FXML
  private Label answerDisplay;

  @FXML
  private Button calcButton;

  @FXML
  private RadioButton infixSelect;

  @FXML
  private RadioButton revPolSelect;

  @FXML
  private TextField userInput;

  @FXML
  void calcPressed(ActionEvent event) {
    CalcModel calc = new CalcModel();
    try {
      result = Float.toString(calc.evaluate(getExpr(), getNotation()));
      answerDisplay.setStyle("-fx-background-color: TRANSPARENT;");
    } catch (InvalidExpressionException e) {
      result = e.getMessage();
      answerDisplay.setStyle("-fx-background-color: #ff0033;");
    }
    setAns(result);
  }

  @FXML
  void infixMode(ActionEvent event) {
    infix = true;
  }

  @FXML
  void revPolMode(ActionEvent event) {
    infix = false;
  }

  @Override
  public String getExpr() {
    return userInput.getText();
  }

  @Override
  public void setAns(String ans) {
    this.answerDisplay.setText(ans);
  }

  @Override
  public boolean getNotation() {
    return infix;
  }
}
