package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class konversiController implements Initializable {

    //Radio Buttons and Group
    @FXML private RadioButton dec2Bin;
    @FXML private RadioButton dec2Hex;
    @FXML private RadioButton bin2Dec;
    @FXML private RadioButton hex2Dec;
    @FXML private ToggleGroup radioGroup;

    @FXML
    private Button kembaliButton;
    @FXML private Button exitButton;

    // Output Field
    @FXML private TextField outputField;

    // Calculate Button
    @FXML private Button calculateButton;

    // Clear all Button
    @FXML private Button clearButton;

    // TextField Button
    @FXML private TextField numberField;




    // Method untuk menentukan operasi mana yang dipilih ** Jalankan pada Kalkulator **
    public void radioButtonSelection() {

        if (this.radioGroup.getSelectedToggle().equals(this.dec2Bin))
            outputField.setText(" ");
        numberField.clear();
        //outputField.setText("dec2Bin Output");

        if (this.radioGroup.getSelectedToggle().equals(this.dec2Hex))
            outputField.setText(" ");
        numberField.clear();
        //outputField.setText("dec2Hex Output");

        if (this.radioGroup.getSelectedToggle().equals(this.bin2Dec))
            outputField.setText(" ");
        numberField.clear();
        //outputField.setText("bin2Dec Output");

        if (this.radioGroup.getSelectedToggle().equals(this.hex2Dec))
            outputField.setText(" ");
        numberField.clear();
        //outputField.setText("hex2Dec Output");

    }

    // Method untuk menghapus semua dan mengatur ulang matikan ** jalankan juga ketika berbeda beralih dipilih
    public void clearAllButtonClick() {
        radioGroup.selectToggle(null);
        outputField.setText(" ");
        numberField.clear();
    }

    // menangani tombol Enter diklik
    @FXML
    public void handleEnterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            outputField.setText("Worth a try - Hit \"Convert\" ");
            // calculateConversion();
        } }


    // Method untuk menghitung konversi
    public void calculateConversion() {

        // Dapatkan input dari bidang teks - konversikan ke integer - proses - kirim ke bidang output
        if (this.radioGroup.getSelectedToggle().equals(this.dec2Bin))
            outputField.setText(dec2Bin(Integer.parseInt(numberField.getText()))); // 120 Should output 1111000

        // Dapatkan input dari bidang teks - konversikan ke integer - proses - kirim ke bidang output
        if (this.radioGroup.getSelectedToggle().equals(this.dec2Hex))
            outputField.setText(dec2Hex(Integer.parseInt(numberField.getText()))); // 59305 should output E7A9

        // Dapatkan input dari bidang teks - konversikan ke integer - proses - kirim ke bidang output
        if (this.radioGroup.getSelectedToggle().equals(this.bin2Dec))
            outputField.setText(String.valueOf(bin2Dec(numberField.getText()))); //should output 120

        // Dapatkan input dari bidang teks - konversikan ke integer - proses - kirim ke bidang output
        if (this.radioGroup.getSelectedToggle().equals(this.hex2Dec))
            outputField.setText(String.valueOf(hex2Dec(numberField.getText()))); //should output 59305

    }

    public static String dec2Bin(int value){

        // ketika hasil bagi adalah nol mengembalikan berhenti
        if(value <= 0)
        {
            return "";
        }
        else
        {
            if  (value%2 != 0) // lihat apakah sisanya ganjil atau genap. 1 atau 0
            {
                return dec2Bin(value/2) + '1'; // jika sisanya adalah 1 maka kirim kembali dan tambahkan 1 ke String
            }
            else
            {
                return  dec2Bin(value/2) + '0'; // jika sisanya 0 menambahkan nol ke String
            }
        }
    }

    public static String dec2Hex(int value) {

        int remainder = value%16;

        // ketika hasil bagi adalah nol mengembalikan berhenti
        if(value <= 0)
        {
            return "";
        }

        else
        {
            if  (remainder >= 10)
            {
                String hexLetter = "Z";
                switch (remainder) {
                    case 10: hexLetter = "A"; break;
                    case 11: hexLetter = "B"; break;
                    case 12: hexLetter = "C"; break;
                    case 13: hexLetter = "D"; break;
                    case 14: hexLetter = "E"; break;
                    case 15: hexLetter = "F"; break;
                }
                return dec2Hex(value/16) + hexLetter;
            }
            else
            {
                return  dec2Hex(value/16) + Integer.toString(remainder);
            }
        }
    }

    public static int bin2Dec(String binaryValue){

        // temukan panjang angka biner
        int numberDigits = binaryValue.length();

        // hapus digit pertama untuk diproses
        String leadDigit = binaryValue.substring(0,1);

        // hapus digit sisa untuk rekursi
        String remDigits = binaryValue.substring(1);

        // Base Case untuk berhenti
        if (numberDigits == 1) {
            return Integer.parseInt(leadDigit); // return the lead digit either 0 or 1
        }

        else
        {
            // Konversikan digit pertama ke nilai desimal berdasarkan posisinya dan kirim kembali digit yang tersisa
            return Integer.parseInt(leadDigit) * (int)Math.pow(2, numberDigits-1) + bin2Dec(remDigits);
        }
    }

    public static int hex2Dec(String hexValue) {

        // temukan panjang angka biner
        int numberDigits = hexValue.length();

        // Base Case untuk berhenti
        if (numberDigits == 0) {
            return 0;
        }

        // hapus digit pertama untuk diproses
        String leadDigit = hexValue.substring(0,1);

        // hapus digit sisa untuk rekursi
        String remDigits = hexValue.substring(1);

        // Gunakan try catch untuk memutuskan cara memproses
        // Jika ada pengecualian, itu adalah surat
        // Jika tidak diproses sebagai konversi digit
        try {
            Integer.parseInt(leadDigit);
        } catch (NumberFormatException e) { // if an exception is caught convert hex letter to dec value
            int hexLetterValue = 0;
            switch (leadDigit) {
                case "A": hexLetterValue = 10; break;
                case "B": hexLetterValue = 11; break;
                case "C": hexLetterValue = 12; break;
                case "D": hexLetterValue = 13; break;
                case "E": hexLetterValue = 14; break;
                case "F": hexLetterValue = 15; break;
            }
            return hex2Dec(remDigits) + hexLetterValue * (int)Math.pow(16, numberDigits-1);
        }
        // jika tidak ada pengecualian tertangkap konversi hex digit ke desimal
        return Integer.parseInt(leadDigit) * (int)Math.pow(16, numberDigits-1) + hex2Dec(remDigits);
    }



    // Inisialisasi Method
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Inisialisasi Toggle Group dan tambahkan tombol radio
        radioGroup = new ToggleGroup();
        this.dec2Bin.setToggleGroup(radioGroup);
        this.dec2Hex.setToggleGroup(radioGroup);
        this.bin2Dec.setToggleGroup(radioGroup);
        this.hex2Dec.setToggleGroup(radioGroup);
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
