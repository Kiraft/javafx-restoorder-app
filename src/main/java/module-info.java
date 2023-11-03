module com.application.restoorderapp {
    opens com.application.restoorderapp.models;
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.application.restoorderapp to javafx.fxml;
    exports com.application.restoorderapp;
    exports com.application.restoorderapp.controllers;
    opens com.application.restoorderapp.controllers to javafx.fxml;
}