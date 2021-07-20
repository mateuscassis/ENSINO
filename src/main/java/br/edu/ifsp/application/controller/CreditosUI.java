package br.edu.ifsp.application.controller;
import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.creditos.Credits;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createCreditsUseCases;
import static br.edu.ifsp.application.main.Main.updateCreditsUseCase;


public class CreditosUI {
    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtValor;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnCancelar;

    private Credits credits;


    public void btnSalvar(ActionEvent actionEvent) throws IOException {
        getEntityToView();
        if (credits.getId() == null) {
            createCreditsUseCases.insert(credits);
        } else {
            updateCreditsUseCase.update(credits);
        }
        App.setRoot("CreditsManagementeUI");
    }

    private void getEntityToView() {
        if (credits == null) {
            credits = new Credits();
        }
        credits.setNome(txtNome.getText());
        credits.setValor(Integer.valueOf(txtValor.getText()));
    }

    public void btnCancelar(ActionEvent actionEvent) throws IOException {
        App.setRoot("CreditsManagementeUI");
    }

    public void setCredits(Credits participant, UImode mode) {
        if (participant == null) {
            throw new IllegalArgumentException("Participant can not be null.");
        }

       this.credits = credits;
        setEntityToView();

        if (mode == UImode.VIEW) {
            configureViewMode();
        }
    }

    private void setEntityToView() {
        txtNome.setText(credits.getNome());
        txtValor.setText(String.valueOf(credits.getValor()));
    }

    private void configureViewMode() {
        btnCancelar.setLayoutX(btnSalvar.getLayoutX());
        btnCancelar.setLayoutY(btnSalvar.getLayoutY());
        btnCancelar.setText("Fechar");

        btnSalvar.setVisible(false);

        txtNome.setDisable(true);
        txtValor.setDisable(true);
    }
    public void txtNome(ActionEvent actionEvent) {
    }

    public void txtValor(ActionEvent actionEvent) {
    }
}
