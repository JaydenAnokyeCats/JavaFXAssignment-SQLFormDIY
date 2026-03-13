package com.example.shirtsandshirts;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.sql.SQLException;
import java.util.List;

public class FormController {
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField phoneInput;
    @FXML
    private TextField addressInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField shirtInput;
    @FXML
    private ComboBox<String> colorDropdown;
    @FXML
    private TextField sizeInput;
    @FXML
    private ComboBox<String> paymentDropdown;

    @FXML
    private ComboBox<String> deliveryInput;
    @FXML
    private Button submitButton;

    @FXML
    public void submitB(ActionEvent event) throws SQLException {
        Window owner = submitButton.getScene().getWindow();


        List<TextField> checker = List.of(firstNameInput, lastNameInput, phoneInput, addressInput,
                emailInput, shirtInput, sizeInput);
        for (TextField field : checker) {
            if (field.getText().isEmpty()) {
                System.out.println("Nothing in here bro");
                return;
            }
        }

        //Variables
        String firstName = firstNameInput.getText();
        System.out.println(firstName);
        String lastName = lastNameInput.getText();
        System.out.println(lastName);
        String phone = phoneInput.getText();
        System.out.println(phone);
        String address = addressInput.getText();
        System.out.println(address);
        String email = emailInput.getText();
        System.out.println(email);

        //Use the orderRecord Method to add the information into the table
        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.orderRecord(firstName, lastName, email, address, phone);

    }
}










//        System.out.println(firstNameInput.getText());
//        System.out.println(lastNameInput.getText());
//        System.out.println(phoneInput.getText());
//        System.out.println(addressInput.getText());
//        System.out.println(emailInput.getText());
//        System.out.println(shirtInput.getText());
//        System.out.println(sizeInput.getText());
//        System.out.println(colorDropdown.getText());
//        System.out.println(paymentDropdown.getText());
//        System.out.println(deliveryDropdown.getText());