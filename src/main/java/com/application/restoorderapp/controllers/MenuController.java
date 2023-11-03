package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.Cuenta;
import com.application.restoorderapp.models.DetallePedido;
import com.application.restoorderapp.models.ElementoMenu;
import com.application.restoorderapp.models.repositories.ElementoMenuRepositoryImplement;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    @FXML
    private Label labelTotal;

    @FXML
    private TableColumn<DetallePedido, Integer> tableColCantidad;

    @FXML
    private TableColumn<DetallePedido, Double> tableColPrecioUnitario;

    @FXML
    private TableColumn<DetallePedido, Double> tableColTotal;

    @FXML
    private TableView<DetallePedido> tableMainRecibo;

    @FXML
    private TableColumn<DetallePedido, String> tableColNombre;

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

    public static ObservableList<DetallePedido> detallePedido = FXCollections.observableArrayList();

    ElementoMenuRepositoryImplement elementoMenuRepositoryImplement = new ElementoMenuRepositoryImplement();
    private Cuenta cuenta;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }


    @FXML
    void pagar(MouseEvent event) {
        detallePedido.clear();
    }

    @FXML
    void changeMenu(ActionEvent event) {
        Node source = (Node) event.getSource();

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

    private void cargarYMostrarPlatillos(String categoria) {
        List<ElementoMenu> elementos = elementoMenuRepositoryImplement.listarPorCategoria(categoria);

        for (ElementoMenu em : elementos) {
            try {
                FXMLLoader cardPlatilloLoader = new FXMLLoader(App.class.getResource("view_card_platillo.fxml"));
                Parent cardPlatilloRoot = cardPlatilloLoader.load();

                CardPlatilloController cardPlatilloController = cardPlatilloLoader.getController();
                cardPlatilloController.setElementoMenu(em);
//                cardPlatilloController.setMenuController(menuController);

                containerPlatillosNodes.getChildren().add(cardPlatilloRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateLabelTotal() {
        double total = detallePedido.stream()
                .mapToDouble(DetallePedido::getPrecio_total)
                .sum();
        labelTotal.setText("$" + total);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getElementoMenu().getNombre()));
        tableColCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tableColPrecioUnitario.setCellValueFactory(new PropertyValueFactory<>("precio_unitario"));
        tableColTotal.setCellValueFactory(new PropertyValueFactory<>("precio_total"));
        tableMainRecibo.setItems(detallePedido);

//        // Añadir observador para el evento ELEMENTO_AGREGADO
//        tableMainRecibo.addEventHandler(CardPlatilloController.ELEMENTO_AGREGADO, event -> {
//            cargarPlatillosATable();
//        });

        detallePedido.addListener((ListChangeListener<DetallePedido>) change -> {
            while (change.next()) {
                if (change.wasAdded() || change.wasRemoved() || change.wasReplaced() || change.wasUpdated()) {
                    updateLabelTotal();
                }
            }
        });


        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Platform.runLater(() -> {
                List<ElementoMenu> elementos = elementoMenuRepositoryImplement.listarPorCategoria("INTERNACIONAL");

                for (ElementoMenu em : elementos) {
                    try {
                        FXMLLoader cardPlatilloLoader = new FXMLLoader(App.class.getResource("view_card_platillo.fxml"));
                        Parent cardPlatilloRoot = cardPlatilloLoader.load();

                        CardPlatilloController cardPlatilloController = cardPlatilloLoader.getController();
                        cardPlatilloController.setElementoMenu(em);

                        containerPlatillosNodes.getChildren().add(cardPlatilloRoot);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        });

        hilo.start();
    }
}


