package com.example.frontend;

import com.example.frontend.schemas.Film;
import com.example.frontend.utils.FilmRequests;
import com.mashape.unirest.http.exceptions.UnirestException;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class MainController {
    @FXML
    private TableView<Film> mainTable;

    @FXML
    protected void initialize() throws UnirestException {
        System.out.println(FilmRequests.executeGet());
    }
    @FXML
    protected void onHelloButtonClick() {

    }
}