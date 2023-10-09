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
    private Button btnForgetBackToData;

    @FXML
    private Button btnForgetBackToLogin;

    @FXML
    private Button btnForgetConfirm;

    @FXML
    private Button btnForgetMain;

    @FXML
    private Button btnForgetQuestion;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private Button btnSwitchLogin;

    @FXML
    private Button btnSwitchRegister;

    @FXML
    private Pane containerForget;

    @FXML
    private Pane containerForgetPassword;

    @FXML
    private Pane containerForgetReady;

    @FXML
    private Pane containerLogin;

    @FXML
    private Pane containerRegister;

    @FXML
    private Label labelForgetBackToLogin;

    @FXML
    private Label labelToForget;

    @FXML
    private PasswordField txtCodeForget;

    @FXML
    private TextField txtEmailRegister;

    @FXML
    private TextField txtIdEmployedRegister;

    @FXML
    private PasswordField txtNewPasswordEncoreForget;

    @FXML
    private PasswordField txtNewPasswordForget;

    @FXML
    private PasswordField txtPasswordEncoreRegister;

    @FXML
    private PasswordField txtPasswordLogin;

    @FXML
    private PasswordField txtPasswordRegister;

    @FXML
    private TextField txtTypeRegister;

    @FXML
    private TextField txtUserForget;

    @FXML
    private TextField txtUserLogin;

    @FXML
    void LoginAndRegister(ActionEvent event) {

    }

    @FXML
    void btnForgetActionBack(ActionEvent event) {
        Node source = (Node) event.getSource();

        switch (source.getId()) {
            case "btnForgetBackToData":

                break;
            case "btnForgetBackToLogin":
                btnForgetQuestion.setVisible(false);
                containerForget.setVisible(false);
                containerLogin.setVisible(true);
                btnSwitchLogin.setVisible(true);
                btnSwitchRegister.setVisible(true);
                break;
            default:
                break;
        }
    }


    @FXML
    void labelAction(MouseEvent event) {
        Node source = (Node) event.getSource();

        switch (source.getId()) {
            case "labelForgetBackToLogin":

                break;
            case "labelToForget":
                btnSwitchLogin.setVisible(false);
                btnSwitchRegister.setVisible(false);
                btnForgetQuestion.setVisible(true);
                containerLogin.setVisible(false);
                containerForget.setVisible(true);
                break;
            default:
                break;
        }
    }
    @FXML
    void inOverMouse(MouseEvent event) {
        labelToForget.setUnderline(true);
    }

    @FXML
    void outOverMouse(MouseEvent event) {
        labelToForget.setUnderline(false);
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

        btnSwitchLogin.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000;");
        btnSwitchRegister.setStyle("-fx-background-color: #b12d33;");
    }

    private void showRegisterForm() {
        containerLogin.setVisible(false);
        containerRegister.setVisible(true);

        btnSwitchRegister.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #000000;");
        btnSwitchLogin.setStyle("-fx-background-color: #b12d33; -fx-text-fill: #FFFFFF;");
//        loadCarrerasInComboBox();
    }


}

