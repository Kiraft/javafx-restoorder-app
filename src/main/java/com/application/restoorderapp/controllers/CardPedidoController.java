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
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class CardPedidoController implements Initializable {


    @FXML
    private VBox containerDetallesPedido;

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
                System.out.println(orden.getFecha());
                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm"); // Formato de hora:minutos
                String horaYMinutos = formatter.format(orden.getFecha());
                labelDate.setText(horaYMinutos);
                labelIdOrden.setText("#" + orden.getId());
                labelCliente.setText(orden.getCliente());

                for (DetallePedido dp :orden.getDetallePedidos()) {
                    Label label = new Label();
                    label.setStyle("-fx-font-size: 22; -fx-text-fill: black; -fx-font-weight: bold;");
                    label.setText(dp.getCantidad() + " " + dp.getElementoMenu().getNombre());
                    containerDetallesPedido.getChildren().add(label);
                }
            });
        });

        hilo.start();
    }
}

