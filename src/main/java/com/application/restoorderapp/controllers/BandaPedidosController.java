package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Orden;
import com.application.restoorderapp.models.repositories.DetallePedidoRepositoryImplement;
import com.application.restoorderapp.models.repositories.OrdenRepositoryImplement;
import com.application.restoorderapp.util.StageLoaderCuenta;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BandaPedidosController implements Initializable {

    @FXML
    private Button btnExit;

    @FXML
    private HBox containerPedidos;

    public static List<Orden> ordenes;
    OrdenRepositoryImplement ordenRepositoryImplement = new OrdenRepositoryImplement();
    DetallePedidoRepositoryImplement detallePedidoRepositoryImplement = new DetallePedidoRepositoryImplement();

    @FXML
    void reloadOrdenes(MouseEvent event) {
        containerPedidos.getChildren().clear();
        cargarOrdenes();
    }

    @FXML
    void exit(ActionEvent event) throws IOException {
        StageLoaderCuenta.load("view_login_and_register.fxml", event, null);
    }

    private void cargarOrdenes(){
        ordenes = ordenRepositoryImplement.listar();

        for (Orden o : ordenes) {
            o.setDetallePedidos(detallePedidoRepositoryImplement.listarPorIdOrden(o));
        }

        for (Orden o : ordenes) {
            try {
                FXMLLoader cardPedidoLoader = new FXMLLoader(App.class.getResource("view_card_pedido.fxml"));
                Parent cardPedidoRoot = cardPedidoLoader.load();

                CardPedidoController cardPedidoController = cardPedidoLoader.getController();
                cardPedidoController.setOrden(o);

                containerPedidos.getChildren().add(cardPedidoRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
                cargarOrdenes();
            });
        });

        hilo.start();
    }
}
