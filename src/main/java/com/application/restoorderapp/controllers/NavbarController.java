package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Cuenta;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NavbarController implements Initializable {

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



    @FXML
    void exit(ActionEvent event) {

    }

    @FXML
    void navbarChange(ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        switch (source.getId()) {
            case "btnMenu":
//                StageLoaderCuenta.load("view_menu.fxml", event, cuenta);

                FXMLLoader menuLoader = new FXMLLoader(App.class.getResource("view_menu.fxml"));

                try {
                    Parent menuRoot = menuLoader.load();
                    MenuController menuController = menuLoader.getController();
                    menuController.setCuenta(cuenta);
                    containerLeft.getChildren().clear();
                    containerLeft.getChildren().add(menuRoot);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                break;
            case "btnTickets":

                FXMLLoader ticketsLoader = new FXMLLoader(App.class.getResource("view_tickets.fxml"));

                try {
                    Parent ticketsRoot = ticketsLoader.load();
                    TicketsController ticketsController = ticketsLoader.getController();
                    ticketsController.setCuenta(cuenta);
                    containerLeft.getChildren().clear();
                    containerLeft.getChildren().add(ticketsRoot);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case "btnSettings":

                FXMLLoader settingsLoader = new FXMLLoader(App.class.getResource("view_settings.fxml"));

                try {
                    Parent settingsRoot = settingsLoader.load();
                    SettingsController settingsController = settingsLoader.getController();
                    settingsController.setCuenta(cuenta);
                    containerLeft.getChildren().clear();
                    containerLeft.getChildren().add(settingsRoot);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            default:
                break;
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
                labelNombre.setText(cuenta.getEmpleado().getNombre() + " " + cuenta.getEmpleado().getApellidoMaterno());

                FXMLLoader menuLoader = new FXMLLoader(App.class.getResource("view_menu.fxml"));

                try {

                    Parent menuRoot = menuLoader.load();

                    MenuController menuController = menuLoader.getController();

                    menuController.setCuenta(cuenta);

                    containerLeft.getChildren().clear();
                    containerLeft.getChildren().add(menuRoot);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });

        hilo.start();
    }
}


