package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.ElementoMenu;
import com.application.restoorderapp.models.repositories.ElementoMenuRepositoryImplement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class MenuController {

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
    private VBox containerAsiaticaNodes;

    @FXML
    private ScrollPane containerCafe;

    @FXML
    private VBox containerCafeNodes;

    @FXML
    private ScrollPane containerInternacional;

    @FXML
    private VBox containerInternacionalNodes;

    @FXML
    private ScrollPane containerPostres;

    @FXML
    private VBox containerPostresNodes;

    private List<ElementoMenu> internacional;
    private List<ElementoMenu> postres;

    private List<ElementoMenu> asiatica;

    private List<ElementoMenu> cafe;

    ElementoMenuRepositoryImplement elementoMenuRepositoryImplement = new ElementoMenuRepositoryImplement();
    private Cuenta cuenta;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @FXML
    void changeMenu(ActionEvent event) {
        Node source = (Node) event.getSource();

        switch (source.getId()) {
            case "btnInternacional":
                showAndHiddenMenu(false, false, false, true);
                break;
            case "btnAsiatica":
                showAndHiddenMenu(true, false, false, false);
                loadAsiatica();


                containerAsiaticaNodes.getChildren().clear();

                for (ElementoMenu em : asiatica) {
                    try {
                        FXMLLoader cardPlatilloLoader = new FXMLLoader(App.class.getResource("view_card_platillo.fxml"));
                        Parent cardPlatilloRoot = cardPlatilloLoader.load();

                        CardPlatilloController cardPlatilloController = cardPlatilloLoader.getController();

                        cardPlatilloController.setElementoMenu(em);

                        containerAsiaticaNodes.getChildren().add(cardPlatilloRoot);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

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

    public void loadInternacional(){
        internacional = elementoMenuRepositoryImplement.listarPorCategoria("INTERNACIONAL");
    }

    public void loadAsiatica(){
        asiatica = elementoMenuRepositoryImplement.listarPorCategoria("ASIATICA");
    }

    public void loadPostres(){
        postres = elementoMenuRepositoryImplement.listarPorCategoria("POSTRES");
    }

    public void loadCafe(){
        cafe = elementoMenuRepositoryImplement.listarPorCategoria("CAFE");
    }

    private void showAndHiddenMenu(boolean asiatica, boolean postre, boolean cafe, boolean internacional) {
        containerAsiatica.setVisible(asiatica);
        containerPostres.setVisible(postre);
        containerCafe.setVisible(cafe);
        containerInternacional.setVisible(internacional);
    }

}


