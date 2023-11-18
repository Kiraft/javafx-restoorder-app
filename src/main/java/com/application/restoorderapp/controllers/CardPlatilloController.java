package com.application.restoorderapp.controllers;

import com.application.restoorderapp.models.DetallePedido;
import com.application.restoorderapp.models.ElementoMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.application.restoorderapp.controllers.MenuController.detallePedido;

public class CardPlatilloController implements Initializable {

    @FXML
    private ImageView imgPlatillo;

    @FXML
    private Spinner<Integer> spinnerCantidad;

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

    SpinnerValueFactory<Integer> spinner;

//    public static final EventType<ActionEvent> ELEMENTO_AGREGADO = new EventType<>(ActionEvent.ANY, "ELEMENTO_AGREGADO");

    @FXML
    void inOver(MouseEvent event) {
        labelAgregar.setUnderline(true);
    }

    @FXML
    void outOver(MouseEvent event) {
        labelAgregar.setUnderline(false);
    }


    @FXML
    void agregar(MouseEvent event) {

        DetallePedido dp = new DetallePedido();

        dp.setCantidad(spinnerCantidad.getValue());
        dp.setPrecio_unitario(elementoMenu.getPrecio());
        dp.setPrecio_total(spinnerCantidad.getValue() * elementoMenu.getPrecio());
        dp.setElementoMenu(elementoMenu);
        dp.setOrden(null);

        detallePedido.add(dp);
//        labelAgregar.fireEvent(new ActionEvent(ELEMENTO_AGREGADO, null));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        spinner = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, 0);
        spinnerCantidad.setValueFactory(spinner);

        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                Image img;
                try {
                    img = new Image(new FileInputStream(elementoMenu.getImg()));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                labelNombre.setText(elementoMenu.getNombre());
                labelPrecio.setText("$ " + String.valueOf(elementoMenu.getPrecio()));
                imgPlatillo.setImage(img);
                labelDescripcion.setText(elementoMenu.getDescripcion());
            });
        });

        hilo.start();
    }
}

