module com.example.beadndo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.beadndo to javafx.fxml;
    exports com.example.beadndo;
}