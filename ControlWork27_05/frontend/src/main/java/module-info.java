module com.example.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.google.gson;
    requires unirest.java;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.frontend to javafx.fxml;
    opens com.example.frontend.schemas to com.google.gson;
    exports com.example.frontend;
}