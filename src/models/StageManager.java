package models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class StageManager {

  /*
   * Change a stage and set a new scene
   */
  public void changeStage (String fxml_file)
  {
    //set new scene
    try {

      Parent root = FXMLLoader.load(getClass().getResource(fxml_file));
      Stage primaryStage = new Stage();
      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();

    } catch (IOException e) {
      System.out.println("StageManager - changeStage fail : " + e.toString());
    }
  }

  // Return stage of an action event (button, ...)
  public Stage returnStage (ActionEvent event)
  {
    return (Stage) ((Node) event.getSource()).getScene().getWindow();
  }

  // Return parent of an action event (button, ...)
  public Parent returnParent (ActionEvent event)
  {
    return ((Node) event.getSource()).getParent();
  }

  // Return stage of a mouse event
  public Stage returnMouseStage (MouseEvent event)
  {
    return (Stage) ((Node) event.getSource()).getScene().getWindow();
  }

  // Return parent of a mouse event
  public Parent returnMouseParent (MouseEvent event)
  {
    return ((Node) event.getSource()).getParent();
  }

}
