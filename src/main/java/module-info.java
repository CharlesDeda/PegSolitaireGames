module com.example.pegsolitairegames {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.pegsolitairegames to javafx.fxml;
    exports com.example.pegsolitairegames;
}