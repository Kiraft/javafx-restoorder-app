package com.application.restoorderapp.controllers;

import com.application.restoorderapp.App;
import com.application.restoorderapp.models.*;
import com.application.restoorderapp.models.repositories.DetallePedidoRepositoryImplement;
import com.application.restoorderapp.models.repositories.ElementoMenuRepositoryImplement;
import com.application.restoorderapp.models.repositories.MesaRepositoryImplement;
import com.application.restoorderapp.models.repositories.OrdenRepositoryImplement;
import com.application.restoorderapp.util.AlertUtil;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class MenuController implements Initializable {

    @FXML
    private JFXComboBox<?> xd;

    @FXML
    private ComboBox<?> boxMesas;

    @FXML
    private TextField txtCliente;
    @FXML
    private Button btnEliminar;

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
    OrdenRepositoryImplement ordenRepositoryImplement = new OrdenRepositoryImplement();
    DetallePedidoRepositoryImplement detallePedidoRepositoryImplement = new DetallePedidoRepositoryImplement();
    MesaRepositoryImplement mesaRepositoryImplement = new MesaRepositoryImplement();
    private Cuenta cuenta;

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    private String styleSelect = "-fx-background-color: #cf454b;\n" +
            " -fx-border-color: #FFFFFF;\n" +
            " -fx-border-width: 0 0 4 0;\n" +
            " -fx-background-radius: 0;\n" +
            " -fx-border-radius: 0;";
    private String styleReset = "-fx-background-color: #b12d33;\n" +
            " -fx-background-radius: 0;\n" +
            " -fx-border-radius: 0;";

    @FXML
    void eliminar(ActionEvent event) {
        detallePedido.clear();
    }
    @FXML
    void pagar(MouseEvent event) {

        if(!detallePedido.isEmpty()){

            if(!txtCliente.getText().isEmpty()){
                if(xd.getValue() != null){
                    Orden o = new Orden();
                    o.setFecha(new Date());
                    o.setEstado_preparacion("PREPARANDO");
                    o.setEmpleado(cuenta.getEmpleado());
                    o.setCliente(txtCliente.getText());
                    o.setMesa((Mesa) xd.getValue());

                    Long idOrden = ordenRepositoryImplement.guardarReturndId(o);
                    o.setId(idOrden);

                    for (DetallePedido dp: detallePedido) {
                        dp.setOrden(o);
                    }

                    for (DetallePedido dp: detallePedido) {
                        detallePedidoRepositoryImplement.guardar(dp);
                    }

                    detallePedido.clear();
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, "PEDIDO REALIZADO CON EXITO", "TU PEDIDO SE HA REALIZADO CON EXITO Y SE HA MANDADO A COCINA");
                    txtCliente.clear();
                }else{
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, "ERROR AL REALIZAR PEDIDO", "DEBES AGREGAR OBLIGATORIAMENTE SELECCIONAR UNA MESA");
                }
            }else{
                AlertUtil.showAlert(Alert.AlertType.INFORMATION, "ERROR AL REALIZAR PEDIDO", "DEBES AGREGAR OBLIGATORIAMENTE UN NOMBRE AL CLIENTE");
            }

        }else{
            AlertUtil.showAlert(Alert.AlertType.INFORMATION, "ERROR AL REALIZAR PEDIDO", "DEBES AGREGAR POR LO MENOS UN PLATILLO O BEBIDA");
        }



    }

    @FXML
    void changeMenu(ActionEvent event) {
        Node source = (Node) event.getSource();

        containerPlatillosNodes.getChildren().clear();

        switch (source.getId()) {
            case "btnInternacional":
                cargarYMostrarPlatillos("INTERNACIONAL");
                btnInternacional.setStyle(styleSelect);
                btnCafe.setStyle(styleReset);
                btnPostres.setStyle(styleReset);
                btnAsiatica.setStyle(styleReset);
                break;
            case "btnAsiatica":
                cargarYMostrarPlatillos("ASIATICA");
                btnAsiatica.setStyle(styleSelect);
                btnInternacional.setStyle(styleReset);
                btnCafe.setStyle(styleReset);
                btnPostres.setStyle(styleReset);
                break;
            case "btnPostres":
                cargarYMostrarPlatillos("POSTRES");
                btnPostres.setStyle(styleSelect);

                btnInternacional.setStyle(styleReset);
                btnCafe.setStyle(styleReset);
                btnAsiatica.setStyle(styleReset);
                break;
            case "btnCafe":
                cargarYMostrarPlatillos("CAFE");
                btnCafe.setStyle(styleSelect);

                btnInternacional.setStyle(styleReset);
                btnPostres.setStyle(styleReset);
                btnAsiatica.setStyle(styleReset);
                break;
            default:
                break;
        }
    }

    public void loadMesasInComboBox(){

        ObservableList ObservableListCarrera = FXCollections.observableArrayList(mesaRepositoryImplement.listarPorEmpleado(cuenta.getEmpleado()));
        xd.setItems(ObservableListCarrera);
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
                        loadMesasInComboBox();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        });

        hilo.start();
    }
}


