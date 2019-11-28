package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.StageManager;
import org.apache.commons.codec.digest.DigestUtils;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA3_256;

public class LoginController {

  // fxml elements
  @FXML
  private Label warning_label;
  @FXML
  private Button x_btn;
  @FXML
  private PasswordField password_input;
  @FXML
  private TextField username_input;

  /*
    Handler for a X button for login.
    Closes the login window.
  */
  @FXML
  private void closeLogin ()
  {
    Stage stage = (Stage) x_btn.getScene().getWindow();
    stage.close();
  }

  /*
    Handler for a sign in button.
    Verify user and redirect to new stage.
  */
  @FXML
  private void verifyCredentials ()
  {
    String username = new DigestUtils(SHA3_256).digestAsHex(username_input.getText());
    String password = new DigestUtils(SHA3_256).digestAsHex(password_input.getText());

    // set your username and password to test
    if (username.equals("a00e4d3b352e9d11979549b9eef5dc951592f594488451e6cd86fdc4bce76a53") &&
        password.equals("e5ead65714a14368b08263779941b023f2d991e97fc7e888752616f5da2fded6"))
    {
      // clear warning
      warning_label.setText("");

      // close login stage
      this.closeLogin();

      //initiate the main stage
      StageManager stageManager = new StageManager();
      stageManager.changeStage("../main_window/style/main.fxml");

    }
    else
    {
      // send msg wrong data
      warning_label.setText("Wrong login data!");
    }
  }

}
