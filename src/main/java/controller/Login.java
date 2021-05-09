package controller;

import domain.AbstractUser;
import domain.User;
import domain.AutoService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.Service;

import java.io.IOException;


public class Login {
    private Service service;

    @FXML
    TextField textfieldUsername;
    @FXML
    PasswordField passswordField;
    public void buttonlogincliked(MouseEvent mouseEvent) throws IOException {
        //iau date
        String username = this.textfieldUsername.getText();
        String password = this.passswordField.getText();
        //trimit datele la service
        AbstractUser abstractUser = this.service.getUserByUsername(username);
        if(abstractUser != null){
            if(password.hashCode()==abstractUser.getHashing()) {
                if (abstractUser instanceof User) {
                    //

                } else if (abstractUser instanceof AutoService) {
                    //
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Wrong password!");
                alert.setContentText("Wrong password!");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Wrong username!");
            alert.showAndWait();
        }
    }

    public void buttonsignupclicked(MouseEvent mouseEvent) throws IOException {

    }

    public void setService(Service service) {
        this.service = service;
    }
}