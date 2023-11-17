module com.example.beadndo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;
    requires httpclient;
    requires gson;
    requires httpcore;
    requires java.xml.bind;
    requires java.jws;
    requires java.xml.ws;
    //requires javax.xml.ws;


    opens com.oanda.v20.account to gson;
    opens com.oanda.v20.primitives to gson;
    opens com.oanda.v20.transaction to gson;
    opens com.example.beadndo to javafx.fxml;
    exports com.example.beadndo;
}