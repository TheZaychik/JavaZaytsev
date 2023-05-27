package com.example.frontend;

import com.example.frontend.schemas.Film;
import com.example.frontend.utils.FilmRequests;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MainController {
    @FXML
    private TableView<Film> mainTable;

    @FXML
    protected void initialize() throws UnirestException {
        List<Film> films = FilmRequests.executeGet();
        mainTable.setItems(FXCollections.observableArrayList(films));


        TableColumn<Film, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Film, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Film, String> genreColumn = new TableColumn<>("Genre");
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));

        TableColumn<Film, Integer> durationColumn = new TableColumn<>("Duration");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        TableColumn<Film, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        mainTable.getColumns().add(idColumn);
        mainTable.getColumns().add(nameColumn);
        mainTable.getColumns().add(genreColumn);
        mainTable.getColumns().add(durationColumn);
        mainTable.getColumns().add(yearColumn);


    }
}