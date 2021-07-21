package br.edu.ifsp.application.controller;
import br.edu.ifsp.application.view.App;
import br.edu.ifsp.domain.entities.servicos.Services;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.List;


public class ServicosManagementeUI {

    @FXML
    private TableView<Services> tableView;

    private ObservableList<Services> tableData;

    @FXML
    private void initialize() {
       // bindTableViewToItemsList();
        //bindColumnsToValueSource();
        // loadDataAndShow();
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
            // deleteServicesUseCase.remove(selectedItem);
            //loadDataAndShow();
        }
    }

    private void loadDataAndShow() {
        //  List<Services> services = findServicesUseCases.findAll();
        tableData.clear();
        //  tableData.addAll(services);
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
