package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.creditos.Credits;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.deleteCreditsUseCases;
import static br.edu.ifsp.application.main.Main.findCreditsUseCases;


public class CreditsManagementeUI {

    @FXML
    private TextField txtPesquisarCreditos;
    @FXML
    private TableView<Credits> tableView;
    @FXML
    private TableColumn<Credits, Integer> cID;
    @FXML
    private TableColumn<Credits, String> cNome;
    @FXML
    private TableColumn<Credits, Integer> cValor;

    private ObservableList<Credits> tableData;

    @FXML
    private void initialize() {
        bindTableViewToItemsList();
        bindColumnsToValueSource();
        loadDataAndShow();
    }

    private void bindTableViewToItemsList() {
        tableData = FXCollections.observableArrayList();
        tableView.setItems(tableData);
    }

    private void bindColumnsToValueSource() {
        cID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        cValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
    }

    private void loadDataAndShow() {
        List<Credits> participantList = findCreditsUseCases.findAll();
        tableData.clear();
        tableData.addAll(participantList);
    }


    public void btnSalvar(ActionEvent actionEvent) throws IOException {
        App.setRoot("CreditosUI");
    }

    public void btnDeletar(ActionEvent actionEvent) {
        Credits selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            deleteCreditsUseCases.remove(selectedItem);
            loadDataAndShow();
        }
    }


    public void btnBuscar(ActionEvent actionEvent) {
    }

    public void btnVoltar(ActionEvent actionEvent) throws IOException {
        App.setRoot("TelaInicialUI");
    }

    private void showParticipantInMode(UImode mode) throws IOException {
        Credits selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            App.setRoot("CreditosUI");
            CreditosUI controller = (CreditosUI) App.getController();
            controller.setCredits(selectedItem, mode);
        }
    }
}
