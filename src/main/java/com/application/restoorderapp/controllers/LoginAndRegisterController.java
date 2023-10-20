package com.application.restoorderapp.controllers;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.Empleado;
import com.application.restoorderapp.models.repositories.CuentaRepositoryImplement;
import com.application.restoorderapp.models.repositories.EmpleadoRepositoryImplement;
import com.application.restoorderapp.util.StageLoaderCuenta;
import javafx.scene.control.Alert.AlertType;
import com.application.restoorderapp.util.AlertUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.io.IOException;

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
    private TextField txtCodeRegister;

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
    private TextField txtUserEmployedRegister;

    @FXML
    private TextField txtUserForget;

    @FXML
    private TextField txtUserLogin;

    CuentaRepositoryImplement cuentaRepositoryImplement = new CuentaRepositoryImplement();
    EmpleadoRepositoryImplement empleadoRepositoryImplement = new EmpleadoRepositoryImplement();
    @FXML
    private void LoginAndRegister(ActionEvent event) {

        Node source = (Node) event.getSource();
        switch (source.getId()) {
            case "btnLogin":
                handleLogin(event);
                break;
            case "btnRegister":
                handleRegister();
                break;

            default:
                break;
        }

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

    //Esta funcion se encarga de contener la logica que verifica si un usuario existe
    private void handleLogin(ActionEvent event) {
        if (!txtUserLogin.getText().isEmpty() && !txtPasswordLogin.getText().isEmpty()) {

            String usuario = txtUserLogin.getText();
            String pass = txtPasswordLogin.getText();

            int state = cuentaRepositoryImplement.login(usuario, pass);

            if (state != -1) {
                if (state == 1) {
                    try {
                        Cuenta cuenta = cuentaRepositoryImplement.porUsuario(usuario);
                        if (cuenta.getEmpleado().getTipoEmpleado().getTipo().equals("MESERO")){
                            StageLoaderCuenta.load("view_navbar_mesero.fxml", event, cuentaRepositoryImplement.porUsuario(usuario));
                        }else{
                            StageLoaderCuenta.load("view_banda_pedidos.fxml", event, cuentaRepositoryImplement.porUsuario(usuario));
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {

                    AlertUtil.showAlert(AlertType.ERROR, "Error inicio de sesion", "Datos incorrectos intentalo de nuevo");
                }
            }else {

                AlertUtil.showAlert(AlertType.ERROR, "Error inicio de sesion", "Problema servidores intentelo mas tarde");
            }

        } else {
            AlertUtil.showAlert(AlertType.ERROR, "Error inicio de sesion", "Campos vacios porfavor llenarlos");
        }
    }

    private void handleRegister() {
        //Esta if verifica si los textfiel estan vacios o no
        if (!txtUserEmployedRegister.getText().isEmpty() && !txtPasswordRegister.getText().isEmpty() && !txtPasswordEncoreRegister.getText().isEmpty()
                && !txtCodeRegister.getText().isEmpty()) {
            //Este if verifica si el largo de la contraseñá es valido
            if (txtPasswordRegister.getText().length() > 5 && txtPasswordEncoreRegister.getText().length() > 5) {
                //Este if verifica si las dos contraseñas son iguales
                if (txtPasswordRegister.getText().equals(txtPasswordEncoreRegister.getText())){
                    System.out.println(empleadoRepositoryImplement.porCode(txtCodeRegister.getText()));
                    //Este if verifica si existe un empleado con el codigo ingresado
                    if (empleadoRepositoryImplement.porCode(txtCodeRegister.getText()) != null) {

                        //Este if verifica si el usuario que se quiere registrar ua existe
                        if (cuentaRepositoryImplement.porUsuario(txtUserEmployedRegister.getText()) == null) {
                            Cuenta c = new Cuenta();
                            c.setUsuario(txtUserEmployedRegister.getText());
                            c.setPassword(txtPasswordRegister.getText());
                            Empleado e = empleadoRepositoryImplement.porCode(txtCodeRegister.getText());
                            e.setHas_account(true);
                            c.setEmpleado(e);

                            empleadoRepositoryImplement.update(e);
                            cuentaRepositoryImplement.guardar(c);

                            AlertUtil.showAlert(AlertType.INFORMATION, "Congratulations", "Te has registrado exitosamente");
                        } else {
                            AlertUtil.showAlert(AlertType.ERROR, "Error registro", "Este nombre de usuario ya existe tio");
                        }
                    } else {
                        AlertUtil.showAlert(AlertType.ERROR, "Error registro", "Codigo de seguridad no pertenece a un empleado");
                    }

                    clearFields();
                }else{
                    AlertUtil.showAlert(AlertType.ERROR, "Error de Registro", "Las contraseñas no conciden");
                    txtPasswordRegister.clear();
                    txtPasswordEncoreRegister.clear();
                }

            } else {
                AlertUtil.showAlert(AlertType.ERROR, "Error de Registro", "Tu contraseña debe ser mayor a 5");
            }

        } else {
            AlertUtil.showAlert(AlertType.ERROR, "Error de Registro", "Llena todos los campos");

            clearFields();

        }
    }

    private void clearFields() {
        txtUserEmployedRegister.clear();
        txtPasswordRegister.clear();
        txtPasswordEncoreRegister.clear();
        txtCodeRegister.clear();
    }

}

