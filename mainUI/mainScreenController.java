package mainUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.JFXButton;
import javafx.stage.Stage;


public class mainScreenController {

    @FXML
    private JFXButton exitButton;

    @FXML
    void exitButtonClicked(ActionEvent event) {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }

}
