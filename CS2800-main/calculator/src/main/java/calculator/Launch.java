package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Launch class for gui.
 *
 * @author Callum Copping
 *
 */
public class Launch extends Application {

  /**
   * Main method to allow GUI to run.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    launch(args);
  }

  /**
   * GUI launch, fetches the relevant fxml file and style sheet.
   *
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Pane pane = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
    Scene scene = new Scene(pane, 800, 125);
    scene.getStylesheets().add(getClass().getResource("/MainView.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.show();
  }

}
