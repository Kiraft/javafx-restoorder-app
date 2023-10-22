package com.application.restoorderapp.controllers;

import com.application.restoorderapp.models.Cuenta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class NavbarController {

    @FXML
    private Button btnExit;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnTickets;

    @FXML
    private AnchorPane containerLeft;

    @FXML
    private Text labelNombre;

    private Cuenta cuenta;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}


