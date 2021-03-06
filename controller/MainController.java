package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class MainController extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("fxml/MWindow.fxml"));
        Parent fxmlMain = fxmlLoader.load();
        MainWindow mainWindow = fxmlLoader.getController();
        mainWindow.setMainStage(primaryStage);
        primaryStage.setTitle("TASK MANAGER");
        primaryStage.setScene(new Scene(fxmlMain,300, 600));
        primaryStage.show();
    }
}
