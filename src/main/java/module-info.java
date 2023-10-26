module com.example.beadndo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;


    opens com.example.beadndo to javafx.fxml;
    exports com.example.beadndo;
}