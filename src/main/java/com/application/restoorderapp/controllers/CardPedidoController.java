package com.application.restoorderapp.controllers;

import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.DetallePedido;
import com.application.restoorderapp.models.Orden;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class CardPedidoController implements Initializable {

    @FXML
    private Label btnCompleted;

    @FXML
    private Label labelCliente;

    @FXML
    private Label labelDate;

    @FXML
    private Label labelIdOrden;

    private Orden orden;

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @FXML
    void completar(MouseEvent event) {

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
//                labelDate.setText("Hola wapo");
//                labelIdOrden.getId();
            });
        });

        hilo.start();
    }
}

