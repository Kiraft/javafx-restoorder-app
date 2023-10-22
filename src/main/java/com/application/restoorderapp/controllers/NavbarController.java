package com.application.restoorderapp.controllers;


import com.application.restoorderapp.models.Cuenta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class NavbarController {
    @FXML
    private Button btnMenu;
    private Cuenta cuenta;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}

