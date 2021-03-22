
package simplecalc2;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SimpleCalc2 extends Application{


    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    Parent gp= FXMLLoader.load(getClass().getResource("LayoutGUI.fxml"));
    primaryStage.setScene( new Scene(gp));
    primaryStage.show();
  }  

}
