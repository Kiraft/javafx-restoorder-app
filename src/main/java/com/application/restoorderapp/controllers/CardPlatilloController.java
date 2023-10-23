package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.ElementoMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardPlatilloController implements Initializable {

    @FXML
    private Label labelAgregar;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelPrecio;

    private ElementoMenu elementoMenu;

    public void setElementoMenu(ElementoMenu elementoMenu) {
        this.elementoMenu = elementoMenu;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                labelNombre.setText(elementoMenu.getNombre());
                labelPrecio.setText(String.valueOf(elementoMenu.getPrecio()));
            });
        });

        hilo.start();
    }
}

