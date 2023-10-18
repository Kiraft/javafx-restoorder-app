package com.application.restoorderapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

public class Menu {

    @FXML
    private Button btnAsiatica;

    @FXML
    private Button btnCafe;

    @FXML
    private Button btnInternacional;

    @FXML
    private Button btnPostres;

    @FXML
    private ScrollPane containerAsiatica;

    @FXML
    private ScrollPane containerCafe;

    @FXML
    private ScrollPane containerInternacional;

    @FXML
    private ScrollPane containerPostres;

    @FXML
    void changeMenu(ActionEvent event) {
        Node source = (Node) event.getSource();

        switch (source.getId()) {
            case "btnInternacional":
                showAndHiddenMenu(false, false, false, true);
                break;
            case "btnAsiatica":
                showAndHiddenMenu(true, false, false, false);

                break;
            case "btnPostres":
                showAndHiddenMenu(false, true, false, false);
                break;
            case "btnCafe":
                showAndHiddenMenu(false, false, true, false);
                break;
            default:
                break;
        }
    }

    private void showAndHiddenMenu(boolean asiatica, boolean postre, boolean cafe, boolean internacional) {
        containerAsiatica.setVisible(asiatica);
        containerPostres.setVisible(postre);
        containerCafe.setVisible(cafe);
        containerInternacional.setVisible(internacional);
    }

}


