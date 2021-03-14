package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.LinkedList;

import static javafx.application.Application.launch;

public class Choicebox_vid12 extends Application {
    Button button;
    Stage window;

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primarystage){
        window=primarystage;
        window.setTitle("Order Now");
        button= new Button("Place Order?");


        LinkedList<String> menu=new LinkedList<String>();
        menu.add("Beignets");
        menu.add("Hot Chocolate");
        menu.add("Cafe Au Lait");
        menu.add("Frozen Cafe Au Lait");
        menu.add("Iced Cafe Au Lait");
        menu.add("Heignets");

        ChoiceBox<String> choiceBox=new ChoiceBox<>();
        choiceBox.getItems().addAll(menu);
        choiceBox.setValue("Heignets");
        button.setOnAction(e->getChoice(choiceBox));

        //listen for selection
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)-> System.out.println(newValue));

        VBox layout=new VBox(20);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(choiceBox,button);

        Scene scene=new Scene(layout,350,250);
        window.setScene(scene);
        window.show();
    }
    //method to handle choicebox
    private void getChoice(ChoiceBox<String> choiceBox){
        String order=choiceBox.getValue();
        System.out.println(order);
    }

}
