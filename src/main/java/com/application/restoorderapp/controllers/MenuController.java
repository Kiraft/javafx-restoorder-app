package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.ElementoMenu;
import com.application.restoorderapp.models.repositories.ElementoMenuRepositoryImplement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static com.application.restoorderapp.controllers.NavbarController.elementsMenu;

public class MenuController implements Initializable {

    @FXML
    private TableView<ElementoMenu> tableMainRecibo;

    @FXML
    private TableColumn<ElementoMenu, String> tableColNombre;

    @FXML
    private Button btnPagar;

    @FXML
    private Button btnAsiatica;

    @FXML
    private Button btnCafe;

    @FXML
    private Button btnInternacional;

    @FXML
    private Button btnPostres;

    @FXML
    private ScrollPane containerPlatillos;

    @FXML
    private VBox containerPlatillosNodes;

    ElementoMenuRepositoryImplement elementoMenuRepositoryImplement = new ElementoMenuRepositoryImplement();
    private Cuenta cuenta;

    private MenuController menuController;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setMenuController(MenuController menuController){
        this.menuController = menuController;
    }


    @FXML
    void pagar(MouseEvent event) {
        elementsMenu.clear();
    }

    @FXML
    void changeMenu(ActionEvent event) {    Node source = (Node) event.getSource();

        containerPlatillosNodes.getChildren().clear();

        switch (source.getId()) {
            case "btnInternacional":
                cargarYMostrarPlatillos("INTERNACIONAL");
                break;
            case "btnAsiatica":
                cargarYMostrarPlatillos("ASIATICA");
                break;
            case "btnPostres":
                cargarYMostrarPlatillos("POSTRES");
                break;
            case "btnCafe":
                cargarYMostrarPlatillos("CAFE");
                break;
            default:
                break;
        }
    }

    public void cargarPlatillosATable(){
        tableMainRecibo.setItems(elementsMenu);
    }

    private void cargarYMostrarPlatillos(String categoria) {
        List<ElementoMenu> elementos = elementoMenuRepositoryImplement.listarPorCategoria(categoria);

        for (ElementoMenu em : elementos) {
            try {
                FXMLLoader cardPlatilloLoader = new FXMLLoader(App.class.getResource("view_card_platillo.fxml"));
                Parent cardPlatilloRoot = cardPlatilloLoader.load();

                CardPlatilloController cardPlatilloController = cardPlatilloLoader.getController();
                cardPlatilloController.setElementoMenu(em);
                cardPlatilloController.setMenuController(menuController);

                containerPlatillosNodes.getChildren().add(cardPlatilloRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableMainRecibo.setItems(elementsMenu);

        // Añadir observador para el evento ELEMENTO_AGREGADO
        tableMainRecibo.addEventHandler(CardPlatilloController.ELEMENTO_AGREGADO, event -> {
            cargarPlatillosATable();
        });
    }
}


