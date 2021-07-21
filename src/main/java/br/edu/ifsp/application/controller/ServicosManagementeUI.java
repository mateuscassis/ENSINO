package br.edu.ifsp.application.controller;
import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.servicos.Services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.deleteServicesUseCase;
import static br.edu.ifsp.application.main.Main.findServicesUseCases;


public class ServicosManagementeUI {
    @FXML
    private TextField txtPesquisarCreditos;
    @FXML
    private TableView<Services> tableView;
    @FXML
    private TableColumn<Services, Integer> cID;
    @FXML
    private TableColumn<Services, String> cNome;
    @FXML
    private TableColumn<Services, Integer> cHoras;
    @FXML
    private TableColumn<Services, Integer> cValor;

    private ObservableList<Services> tableData;

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
        cID.setCellValueFactory(new PropertyValueFactory<>("id"));
        cNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        cHoras.setCellValueFactory(new PropertyValueFactory<>("Horas"));
        cValor.setCellValueFactory(new PropertyValueFactory<>("Valor"));
    }

    public void btnNovo(ActionEvent actionEvent) throws IOException {
        App.setRoot("ServicosUI");
    }

    public void btnVoltar(ActionEvent actionEvent) throws IOException {
        App.setRoot("TelaInicialUI");
    }

    public void btnDeletarServico(ActionEvent actionEvent) {
        Services selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            deleteServicesUseCase.remove(selectedItem);
            loadDataAndShow();
        }
    }

    private void loadDataAndShow() {
        List<Services> services = findServicesUseCases.findAll();
        tableData.clear();
        tableData.addAll(services);
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