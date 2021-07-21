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
        cID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        cNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        cMensalidade.setCellValueFactory(new PropertyValueFactory<>("Mensalidade"));
    }

    private void loadDataAndShow() {
      //  List<Basic> basics = findAlunoUseCases.findAll();
        tableData.clear();
      //  tableData.addAll(basics);
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
          //  deleteAlunoUseCases.remove(selectedItem);
            loadDataAndShow();
        }
    }

    public void txtBuscarAlunoMedio(ActionEvent actionEvent) {
    }

    public void btnBuscarAlunoMedio(ActionEvent actionEvent) {
    }
}
