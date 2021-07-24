package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class kalkulatorController implements Initializable {

    Float data = 0f;
    int operation = -1;

    @FXML
    private Button minus;

    @FXML
    private Button nine;

    @FXML
    private Button six;

    @FXML
    private Button mult;

    @FXML
    private Button one;

    @FXML
    private TextField display;

    @FXML
    private Button clear;

    @FXML
    private Button seven;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button eight;

    @FXML
    private Button zero;

    @FXML
    private Button div;

    @FXML
    private Button four;

    @FXML
    private Button equals;

    @FXML
    private Button five;

    @FXML
    private Button kembaliButton;

    @FXML
    private Button exitButton;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == one) {
            display.setText(display.getText() + "1");
        } else if (event.getSource() == two) {
            display.setText(display.getText() + "2");
        } else if (event.getSource() == three) {
            display.setText(display.getText() + "3");
        } else if (event.getSource() == four) {
            display.setText(display.getText() + "4");
        } else if (event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if (event.getSource() == six) {
            display.setText(display.getText() + "6");
        } else if (event.getSource() == seven) {
            display.setText(display.getText() + "7");
        } else if (event.getSource() == eight) {
            display.setText(display.getText() + "8");
        } else if (event.getSource() == nine) {
            display.setText(display.getText() + "9");
        } else if (event.getSource() == zero) {
            display.setText(display.getText() + "0");
        } else if (event.getSource() == clear) {
            display.setText("");
        } else if (event.getSource() == plus) {
            data = Float.parseFloat(display.getText());
            operation = 1; //Addition
            display.setText("");
        } else if (event.getSource() == minus) {
            data = Float.parseFloat(display.getText());
            operation = 2; //Substraction
            display.setText("");
        } else if (event.getSource() == mult) {
            data = Float.parseFloat(display.getText());
            operation = 3; //Mul
            display.setText("");
        } else if (event.getSource() == div) {
            data = Float.parseFloat(display.getText());
            operation = 4; //Division
            display.setText("");
        } else if (event.getSource() == equals) {
            Float secondOperand = Float.parseFloat(display.getText());
            switch (operation) {
                case 1: //Addition
                    Float ans = data + secondOperand;
                    display.setText(String.valueOf(ans));break;
                case 2: //Subtraction
                    ans = data - secondOperand;
                    display.setText(String.valueOf(ans));break;
                case 3: //Mul
                    ans = data * secondOperand;
                    display.setText(String.valueOf(ans));break;
                case 4: //Div
                    ans = 0f;
                    try {
                        ans = data / secondOperand;
                    }catch(Exception e){display.setText("Error");}
                    display.setText(String.valueOf(ans));break;
            }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
