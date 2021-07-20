package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class ServicosManagementeUI {

    public void btnNovo(ActionEvent actionEvent) throws IOException {
        App.setRoot("ServicosUI");
    }

    public void btnVoltar(ActionEvent actionEvent) throws IOException {
        App.setRoot("TelaInicialUI");
    }

    public void btnDeletarServico(ActionEvent actionEvent) {
    }

    public void txtBuscarServicos(ActionEvent actionEvent) {
    }

    public void btnBuscarServicos(ActionEvent actionEvent) {
    }

    public void cId(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cNome(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cHoras(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cValor(TableColumn.CellEditEvent cellEditEvent) {
    }
}
