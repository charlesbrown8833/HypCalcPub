/*
Charles Brown
CITC-1311-C01
Chapter 12
Sept. 16, 2023
*/

package com.murach.hypotenusecalculator;
//Imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HypotenuseCalculator extends Application {
    //Intitialize variables
    private TextField side_a;
    private TextField side_b;
    private TextField side_c;

    public HypotenuseCalculator() {
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hypotenuse Calculator");
        
        //Create GridPane and set alignment and padding
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25.0, 25.0, 25.0, 25.0));
        grid.setHgap(10.0);
        grid.setVgap(10.0);
        
        //Create scene object and pass GridPane object to scene
        Scene scene = new Scene(grid);
        
        //Create text fields to accept user input
        grid.add(new Label("Side A:"), 0, 0);
        this.side_a = new TextField();
        grid.add(this.side_a, 1, 0);
        grid.add(new Label("Side B:"), 0, 1);
        this.side_b = new TextField();
        grid.add(this.side_b, 1, 1);
        grid.add(new Label("Side C:"), 0, 2);
        this.side_c = new TextField();
        this.side_c.setEditable(false);
        grid.add(this.side_c, 1, 2);
        
        //Create Button objects and set alignment in HBox
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction((event) -> {
            this.calculateButtonClicked();
        });
        Button exitButton = new Button("Exit");
        exitButton.setOnAction((event) -> {
            this.exitButtonClicked();
        });
        HBox buttonBox = new HBox(10.0);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        grid.add(buttonBox, 0, 4, 2, 1);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateButtonClicked() {
        
        //Create validation object
        Validation v = new Validation();
        
        //Initialize errorMsg and assign new values if needed.
        String errorMsg = "";
        errorMsg = errorMsg + v.isDouble(this.side_a.getText(), "Side A:");
        errorMsg = errorMsg + v.isDouble(this.side_b.getText(), "Side B:");
        
        //Accept  valid user input and calculate hypotenuse
        if (errorMsg.isEmpty()) {
            double aSide = Double.parseDouble(this.side_a.getText());
            double bSide = Double.parseDouble(this.side_b.getText());
            double cSide = aSide * aSide + bSide * bSide;
            double hyp = Math.sqrt(cSide);
            this.side_c.setText(String.format("%.3f", hyp));
        }
        
        //Alert for invalid data
        else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Invalid Data");
            alert.setContentText(errorMsg);
            alert.showAndWait();
        }

    }

    private void exitButtonClicked() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}