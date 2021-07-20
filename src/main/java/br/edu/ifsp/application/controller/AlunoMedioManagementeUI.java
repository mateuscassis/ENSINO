package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class AlunoMedioManagementeUI {
    public void cID(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cName(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cCreditos(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void DeletarAluno(ActionEvent actionEvent) {
    }

    public void novoAluno(ActionEvent actionEvent) {
    }

    public void txtBuscarAlunoMedio(ActionEvent actionEvent) {
    }

    public void btnBuscarAlunoMedio(ActionEvent actionEvent) {
    }

    public void btnVoltar(ActionEvent actionEvent) throws IOException {
        App.setRoot("TelaInicialUI");
    }
}
