package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;

import java.io.IOException;

public class AlunoSuperiorManagementeUI {
    public void DeletarAluno(ActionEvent actionEvent) {
    }

    public void novoAluno(ActionEvent actionEvent) throws IOException {
        App.setRoot("AlunoSuperiorUI");
    }

    public void btnVoltar(ActionEvent actionEvent) throws IOException {
        App.setRoot("TelaInicialUI");
    }

    public void txtBuscarAlunoSuperior(ActionEvent actionEvent) {
    }

    public void btnBuscarAlunoSuperior(ActionEvent actionEvent) {
    }

    public void cID(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cName(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void cCreditos(TableColumn.CellEditEvent cellEditEvent) {
    }
}
