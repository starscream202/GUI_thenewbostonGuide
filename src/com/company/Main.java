package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button button, button2, button3;
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

        button=new Button("Magic button!!");//creating button
        button3=new Button("Holy Button!!");

        //this will call handle method for button to have action
        button.setOnAction(e-> {
            AlertBox.display("Alert","Are you sure u want to go to other page?");
            window.setScene(scene2);

        });
        button3.setOnAction(e-> closeProgeam());
        HBox topMenu=new HBox();
        Button tipShare=new Button("tipShare");
        Button inventory= new Button("inventory");
        Button cashReport=new Button("cashReport");
        topMenu.getChildren().addAll(tipShare,cashReport,inventory);

        VBox layout1=new VBox(20);
        layout1.getChildren().addAll(label,button,button3);



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


}
