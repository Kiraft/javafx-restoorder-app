package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.ElementoMenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.application.restoorderapp.controllers.NavbarController.elementsMenu;

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

    public static final EventType<ActionEvent> ELEMENTO_AGREGADO = new EventType<>(ActionEvent.ANY, "ELEMENTO_AGREGADO");
    private MenuController menuController;

    public void setElementoMenu(ElementoMenu elementoMenu) {
        this.elementoMenu = elementoMenu;
    }

    public void setMenuController(MenuController menuController){
        this.menuController = menuController;
    }

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
        elementsMenu.add(elementoMenu);
        labelAgregar.fireEvent(new ActionEvent(ELEMENTO_AGREGADO, null));
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
                labelPrecio.setText("$ " + String.valueOf(elementoMenu.getPrecio()));
            });
        });

        hilo.start();
    }
}

