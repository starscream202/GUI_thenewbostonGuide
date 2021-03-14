package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.Window;


public class ComboBox_vid14 extends Application {
    Button button;
    Scene scene;
    Stage window;
    ComboBox<String> comboBox;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("ComboBox");
        button=new Button("Submit");

        comboBox=new ComboBox<>();
        comboBox.getItems().addAll(
                "Rasengan",
                "Chidori",
                "Amateratsu",
                "Susano",
                "Flying Raijin",
                "Sage Mode",
                "Tsukyomi"
        );
        comboBox.setPromptText("Choose a Ninjutsu");
        comboBox.setEditable(true);
        comboBox.setOnAction(e-> System.out.println(comboBox.getValue()));

        VBox layout=new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox,button);

        scene=new Scene(layout,500,500);
        window.setScene(scene);
        window.show();

    }
}
