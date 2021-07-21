module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens br.edu.ifsp.application.view to javafx.fxml;
    exports br.edu.ifsp.application.view;
    exports br.edu.ifsp.application.controller;
    opens br.edu.ifsp.application.controller to javafx.fxml;
}