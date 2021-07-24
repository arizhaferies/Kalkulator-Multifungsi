package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homePageController implements Initializable {

    @FXML
    private Button kalkulatorButton;
    @FXML
    private Button bmiButton;
    @FXML
    private Button konversiButton;
    @FXML
    private Button exitButton;

    @FXML
    public void kalkulatorButtonOnAction(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("kalkulator.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage homePageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homePageStage.hide();
        homePageStage.setScene(homePageScene);
        homePageStage.show();
    }

    @FXML
    public void bmiButtonOnAction(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("bmi.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage homePageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homePageStage.hide();
        homePageStage.setScene(homePageScene);
        homePageStage.show();
    }

    @FXML
    public void konversiButtonOnAction(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("konversi.fxml"));
        Scene homePageScene = new Scene(homePage);
        Stage homePageStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        homePageStage.hide();
        homePageStage.setScene(homePageScene);
        homePageStage.show();
    }

    @FXML
    public void exitButtonOnAction(ActionEvent event) {
        Stage primarystage = (Stage) exitButton.getScene().getWindow();
        primarystage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
