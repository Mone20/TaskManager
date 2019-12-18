package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    private Stage mainStage;

    public void setMainStage (Stage mainStage) { this.mainStage = mainStage;}

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void actionButtonPressed(javafx.event.ActionEvent actionEvent) {
        Object sourse = actionEvent.getSource();
        if(!(sourse instanceof Button)) return;

        Button clickButton = (Button) sourse;
        String title = "";
        switch (clickButton.getId()){
            case "btnAddTask":

                break;
            case "btnDelTask":


                break;
            case "btnAllTask":

                break;
        }
    }
}
