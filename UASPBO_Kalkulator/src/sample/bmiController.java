package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;



public class bmiController {

    @FXML
    private Button kembaliButton;
    @FXML
    private Button exitButton;

    public TextField txtHeightInMeters;
    public TextField txtWeightInKg;

    public Label labelBmiValue;
    public Label labelBmiResult;

    public void calculateBMI() {

        double height;
        double weight;
        double bmi;

        String result = "";

        height = Double.parseDouble(txtHeightInMeters.getText());
        weight = Double.parseDouble(txtWeightInKg.getText());

        bmi = Math.round(weight / Math.pow(height, 2));

        labelBmiValue.setText("BMI Anda: " + bmi);


        if (bmi < 18.5) {
            result = "Underweight";
            labelBmiResult.setStyle("-fx-background-color: lightblue");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            result = "Healthy";
            labelBmiResult.setStyle("-fx-background-color: lightgreen");
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            result = "Overweight";
            labelBmiResult.setStyle("-fx-background-color: pink");
        } else if (bmi >= 30.0 && bmi <= 39.9) {
            result = "Obese";
            labelBmiResult.setStyle("-fx-background-color: orange");
        } else {
            result = "Extremely Obese";
            labelBmiResult.setStyle("-fx-background-color: red");
        }


        labelBmiResult.setText("Kategori: " + result);

        //SETTING THE HIDDEN LABELS TO VISIBLE

        labelBmiValue.setVisible(true);
        labelBmiResult.setVisible(true);


    }
    public void enterKeyPress(KeyEvent keyEvent) {

        if (keyEvent.getCode() == KeyCode.ENTER) {
            calculateBMI();
        }
    }

    @FXML
    public void kembaliButtonOnAction(ActionEvent event) throws IOException {
        Parent homePage = FXMLLoader.load(getClass().getResource("homePage.fxml"));
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

}
