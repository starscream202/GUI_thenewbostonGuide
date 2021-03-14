package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {

    Button button, button2, button3,button4;
    Stage window;
    Scene scene1,scene2;

    public static void main(String[] args) {
	// first step extend Application
        launch(args);//method in Application class where it calls start method
    }


    @Override//automatically overides when u make start method
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;//sets title of window

        Label label=new Label("Welcome to dittoIT");

        //making checkboxes thenewboston video 11
        CheckBox box1=new CheckBox("Beignets");
        CheckBox box2=new CheckBox("Cafe Au Lait");
        CheckBox box3=new CheckBox("Hot Chocolate");
        box1.setSelected(true);
        box2.setSelected(true);

        button=new Button("Magic button!!");//creating button
        button3=new Button("Holy Button!!");
        button4=new Button("Order Now");//thenewboston video 11
        button4.setOnAction(e->handleCheckbox(box1,box2,box3));



        //this will call handle method for button to have action
        button.setOnAction(e-> {
            AlertBox.display("Alert","Are you sure u want to go to other page?");
            window.setScene(scene2);

        });
        button3.setOnAction(e-> closeProgeam());
        HBox topMenu=new HBox();
        Button tipShare=new Button("tipShare");
        Button inventory= new Button("Inventory");
        Button cashReport=new Button("cashReport");
        topMenu.getChildren().addAll(tipShare,cashReport,inventory);

        VBox layout1=new VBox(20);
        layout1.getChildren().addAll(label,button,button3,box1,box2,box3,button4);



        button2=new Button("Ordinary Button");
        button2.setOnAction(e-> {
            boolean result=ConfirmBox.display("Confirmation","Am I good kisser?");
            System.out.println(result);
            window.setScene(scene1);
        });
        BorderPane borderPane=new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(layout1);
        scene1=new Scene(borderPane,500,600);


        StackPane layout2= new StackPane();
        layout2.getChildren().add(button2);
        scene2= new Scene(layout2,300,400);

        window.setScene(scene1);
        window.setTitle("dittoIT");
        window.setOnCloseRequest(e->{
            e.consume();
            closeProgeam();
        });
        window.show();
        //ended with video 5 thenewboston


    }
    //video 7 the new boston how to properly close your program depending on type of app
    private void closeProgeam(){
        Boolean answer=ConfirmBox.display("Leaving?","Are you sure you want to go?");
        if(answer){
            window.close();
        }
    };
    //going to make button 4 handle checkboxes thenewboston video 11
    private void handleCheckbox(CheckBox box1,CheckBox box2,CheckBox box3){
        String order="Customer Order:\n";
        if(box1.isSelected()){
            order+="Beignets\n";
        }
        if(box2.isSelected()){
            order+="Cafe Au Lait\n";
        }
        if(box3.isSelected()){
            order+="Hot Chocolate\n";
        }
        System.out.println(order);
    }


}
