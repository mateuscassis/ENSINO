package br.edu.ifsp.application.controller;

import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.aluno.Superior;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

import static br.edu.ifsp.application.main.Main.findAlunoUseCases;

public class AlunoSuperiorManagementeUI {

    @FXML
    private TableView<Superior> tableView;
    @FXML
    private TableColumn<Superior, Integer> cID;
    @FXML
    private TableColumn<Superior, String> cNome;
    @FXML
    private TableColumn<Superior, Integer> cCreditos;

    private ObservableList<Superior> tableData;

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
        cCreditos.setCellValueFactory(new PropertyValueFactory<>("Mensalidade"));
    }

    private void loadDataAndShow() {
        List<Superior> aluno = findAlunoUseCases.findAll();
        tableData.clear();
        tableData.setAll(aluno);
    }

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
