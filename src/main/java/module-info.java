module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires sqlite.jdbc;

    opens br.edu.ifsp.application.view to javafx.fxml;
    opens br.edu.ifsp.domain.entities.aluno to javafx.base;
    opens br.edu.ifsp.domain.entities.creditos to javafx.base;
    opens br.edu.ifsp.domain.entities.servicos to javafx.base;
    exports br.edu.ifsp.application.view;
    exports br.edu.ifsp.application.controller;
    opens br.edu.ifsp.application.controller to javafx.fxml;
}