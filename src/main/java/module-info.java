module com.application.restoorderapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.application.restoorderapp to javafx.fxml;
    exports com.application.restoorderapp;
    exports com.application.restoorderapp.controller;
    opens com.application.restoorderapp.controller to javafx.fxml;
}