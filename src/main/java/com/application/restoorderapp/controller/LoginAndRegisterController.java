package com.application.restoorderapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class LoginAndRegisterController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLogin1;

    @FXML
    private Button btnLogin11;

    @FXML
    private Button btnLogin2;

    @FXML
    private Button btnRecoverBack1;

    @FXML
    private Button btnRecoverBack11;

    @FXML
    private Button btnRecoverBack111;

    @FXML
    private Button btnSwitchLogin;

    @FXML
    private Button btnSwitchRegister;

    @FXML
    private Button btnSwitchRegister1;

    @FXML
    private Pane containerLogin;

    @FXML
    private Pane containerLogin111;

    @FXML
    private Pane containerRecuperar;

    @FXML
    private Pane containerRecuperarPassword;

    @FXML
    private Pane containerRegister;

    @FXML
    private Label labelRecover;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private PasswordField txtPassword1;

    @FXML
    private PasswordField txtPassword11;

    @FXML
    private PasswordField txtPassword2;

    @FXML
    private PasswordField txtPassword21;

    @FXML
    private PasswordField txtPassword22;

    @FXML
    private PasswordField txtPassword23;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtUser1;

    @FXML
    private TextField txtUser11;

    @FXML
    private TextField txtUser2;

    @FXML
    void LoginAndRegister(ActionEvent event) {


    }

    @FXML
    void backLogin(ActionEvent event) {

    }

    @FXML
    void inOverMouse(MouseEvent event) {

    }

    @FXML
    void labelRecover(MouseEvent event) {

    }

    @FXML
    void outOverMouse(MouseEvent event) {

    }

    @FXML
    void switchForm(ActionEvent event) {

        Node source = (Node) event.getSource();
        switch (source.getId()) {
            case "btnSwitchRegister":
                showRegisterForm();
                break;
            case "btnSwitchLogin":
                showLoginForm();
                break;
            default:
                break;
        }
    }

    private void showLoginForm() {
        containerRegister.setVisible(false);
        containerLogin.setVisible(true);
        btnSwitchLogin.setStyle("-fx-background-color: #1B396A;");
        btnSwitchRegister.setStyle("-fx-background-color: #343131;");
    }

    private void showRegisterForm() {
        containerLogin.setVisible(false);
        containerRegister.setVisible(true);
        btnSwitchRegister.setStyle("-fx-background-color: #1B396A;");
        btnSwitchLogin.setStyle("-fx-background-color: #343131;");
        loadCarrerasInComboBox();
    }

}
