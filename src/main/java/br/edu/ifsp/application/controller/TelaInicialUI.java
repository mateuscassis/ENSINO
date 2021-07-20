package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;


public class TelaInicialUI {
    public void creditos(ActionEvent actionEvent) throws IOException {
        App.setRoot("CreditsManagementeUI");
    }

    public void servicos(ActionEvent actionEvent) throws IOException {
        App.setRoot("ServicosManagementeUI");
    }

    public void superior(ActionEvent actionEvent) throws IOException {
        App.setRoot("AlunoSuperiorManagementeUI");
    }

    public void medio(ActionEvent actionEvent) throws IOException {
        App.setRoot("AlunoMedioManagementeUI");
    }
}
