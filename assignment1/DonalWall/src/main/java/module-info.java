module com.example.donalwall {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires xstream;
    exports com.example.donalwall.Models;

    opens com.example.donalwall to javafx.fxml;
    exports com.example.donalwall;
    exports com.example.donalwall.Controllers;
    opens com.example.donalwall.Controllers to javafx.fxml;
}