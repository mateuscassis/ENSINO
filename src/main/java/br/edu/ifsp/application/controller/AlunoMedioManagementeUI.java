package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.aluno.Basic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;
import static br.edu.ifsp.application.main.Main.deleteAlunoUseCases;
import static br.edu.ifsp.application.main.Main.findAlunoUseCases;

public class AlunoMedioManagementeUI {

    @FXML
    private TableView<Basic> tableView;
    @FXML
    private TableColumn<Basic, Integer> cID;
    @FXML
    private TableColumn<Basic, String> cNome;
    @FXML
    private TableColumn<Basic, Integer> cMensalidade;

    private ObservableList<Basic> tableData;

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
        cMensalidade.setCellValueFactory(new PropertyValueFactory<>("Mensalidade"));
    }

    private void loadDataAndShow() {
        List<Basic> aluno = findAlunoUseCases.findAll();
        tableData.clear();
        tableData.setAll(aluno);
    }

    public void novoAluno(ActionEvent actionEvent) throws IOException {
        App.setRoot("AlunoMedioUI");
    }

    public void btnVoltar(ActionEvent actionEvent) throws IOException {
        App.setRoot("TelaInicialUI");
    }

    public void DeletarAluno(ActionEvent actionEvent) {
        Basic selectedItem = tableView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            deleteAlunoUseCases.remove(selectedItem);
            loadDataAndShow();
        }
    }

    public void txtBuscarAlunoMedio(ActionEvent actionEvent) {
    }

    public void btnBuscarAlunoMedio(ActionEvent actionEvent) {
    }

    public void cID(TableColumn.CellEditEvent<Basic, Integer> basicIntegerCellEditEvent) {
    }

    public void cName(TableColumn.CellEditEvent<Basic, String> basicStringCellEditEvent) {
    }

    public void cCreditos(TableColumn.CellEditEvent<Basic, Integer> basicIntegerCellEditEvent) {
    }
}
