package sample;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Search");
        primaryStage.setScene(new Scene(root));
        primaryStage.getIcons().add(new Image("/icon.png"));
        primaryStage.show();

    }


    public static void main(String[] args) { launch(args); }
}
