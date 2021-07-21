package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.aluno.Basic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createAlunoUseCases;

public class AlunoMedioUIController {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtMensalidade;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;

    private Basic basic;

    public void btnSalvar(ActionEvent actionEvent) throws IOException {

        getEntityToView();
        if (basic.getId() == null)
            createAlunoUseCases.insert(basic);

        App.setRoot("AlunoMedioManagementeUI");

    }

    private void getEntityToView() {
        if (basic == null) {
            basic = new Basic();
        }
        basic.setNome(txtNome.getText());
        basic.setMensalidade(Float.parseFloat(txtMensalidade.getText()));
    }

    public void btnCancelar(ActionEvent actionEvent) throws IOException {
        App.setRoot("AlunoMedioManagementeUI");
    }

    public void setParticipant(Basic basic, UImode mode) {
        if (basic == null) {
            throw new IllegalArgumentException("Participant can not be null.");
        }

        this.basic = basic;

        setEntityToView();

        if (mode == UImode.VIEW) {
            configureViewMode();
        }
    }

    private void setEntityToView() {
        txtNome.setText(basic.getNome());
        txtMensalidade.setText(String.valueOf(basic.getMensalidade()));

    }

    private void configureViewMode() {
        btnCancelar.setLayoutX(btnSalvar.getLayoutX());
        btnCancelar.setLayoutY(btnSalvar.getLayoutY());
        btnCancelar.setText("Fechar");

        btnSalvar.setVisible(false);

        txtNome.setDisable(true);
        txtMensalidade.setDisable(true);
    }


    public void txtnome(ActionEvent actionEvent) {
    }

    public void txtMensalidade(ActionEvent actionEvent) {
    }
}
