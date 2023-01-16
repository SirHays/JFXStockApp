package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Controller {
    @FXML
    public TextField companyInput;
    @FXML
    public Label loading;
    @FXML
    private void submitted(ActionEvent event) throws Exception {
        loading.setText("Please Wait...");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/profile.fxml"));
        loader.setControllerFactory(t -> new ProfileController(new StatProvider()));
        Parent root = loader.load();
        Stage secondStage = new Stage();
        secondStage.setScene(new Scene(root));
        secondStage.setTitle("Profile");
        secondStage.getIcons().add(new Image("/icon.png"));

        ProfileController profileController = loader.getController();
        profileController.transferMessage(companyInput.getText(),secondStage,loading);
        companyInput.setText("");
    }

}
