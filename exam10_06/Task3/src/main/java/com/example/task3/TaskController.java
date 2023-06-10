package com.example.task3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TaskController {
    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;

    @FXML
    private TextField ans;

    @FXML
    private Label error;

    private Double v1;
    private Double v2;

    protected boolean GetValues() {
        try {
            v1 = Double.valueOf(tf1.getText());
            v2 = Double.valueOf(tf2.getText());
            error.setVisible(false);
            return true;
        } catch (Exception e) {
            error.setVisible(true);
            return false;
        }
    }

    @FXML
    protected void PlusButtonClick() {
        if (GetValues()) {
            ans.setText(String.valueOf(v1 + v2));
        }
    }

    @FXML
    protected void MinusButtonClick() {
        if (GetValues()) {
            ans.setText(String.valueOf(v1 - v2));
        }
    }

    @FXML
    protected void MulButtonClick() {
        if (GetValues()) {
            ans.setText(String.valueOf(v1 * v2));
        }
    }

    @FXML
    protected void DivButtonClick() {
        if (GetValues()) {
            ans.setText(String.valueOf(v1 / v2));
        }
    }
}