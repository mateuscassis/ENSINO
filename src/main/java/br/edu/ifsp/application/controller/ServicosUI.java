package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.servicos.Services;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static br.edu.ifsp.application.main.Main.createServicesUseCases;
import static br.edu.ifsp.application.main.Main.updateServiceUseCase;

public class ServicosUI {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtValor;
    @FXML
    private TextField txtHoras;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnCancelar;

    private Services services;

    public void btnSalvar(ActionEvent actionEvent) throws IOException {
        getEntityToView();
        if (services.getId() == null)
            createServicesUseCases.insert(services);
        else {
            updateServiceUseCase.update(services);
        }
        App.setRoot("ServicosManagementeUI");
    }

    private void getEntityToView() {
        if (services == null) {
            services = new Services();
        }
        services.setNome(txtNome.getText());
        services.setValor(Integer.valueOf(txtValor.getText()));
        services.setHoras(Integer.valueOf(txtHoras.getText()));
    }
    public void btnCancelar(ActionEvent actionEvent) throws IOException {
        App.setRoot("ServicosManagementeUI");
    }

    public void setServices(Services services, UImode mode) {
        if (services == null) {
            throw new IllegalArgumentException("Services can not be null.");
        }

        this.services = services;
        setEntityToView();

        if (mode == UImode.VIEW) {
            configureViewMode();
        }
    }

    private void setEntityToView() {
        txtNome.setText(services.getNome());
        txtValor.setText(String.valueOf(services.getValor()));
        txtHoras.setText(String.valueOf(services.getHoras()));
    }

    private void configureViewMode() {
        btnCancelar.setLayoutX(btnSalvar.getLayoutX());
        btnCancelar.setLayoutY(btnSalvar.getLayoutY());
        btnCancelar.setText("Fechar");

        btnSalvar.setVisible(false);

        txtNome.setDisable(true);
        txtValor.setDisable(true);
        txtHoras.setDisable(true);
    }

}
