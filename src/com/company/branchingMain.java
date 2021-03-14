package com.company;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class branchingMain extends Application{
    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Ash's Application");

        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        //setting field for username
        Label nameLabel=new Label("Username");
        GridPane.setConstraints(nameLabel,0,0);
        TextField nameInput= new TextField("Ash");
        GridPane.setConstraints(nameInput,1,0);

        //setting field for password
        Label passLabel=new Label("Password");
        GridPane.setConstraints(passLabel,0,1);
        TextField passInput= new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(passInput,1,1);

        Button loginButton= new Button("Login");
        GridPane.setConstraints(loginButton,1,2);
        loginButton.setOnAction(e-> getCreds(nameInput,passInput));


        gridPane.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton);

        Scene scene=new Scene(gridPane,500,500);

        window.setScene(scene);
        window.show();



    }
    private boolean isInt(TextField input,String message){
        try{
            int age=Integer.parseInt(input.getText());
            System.out.println("User is "+age);
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error ");
        }return true;
    }
    public String getCreds(TextField username,TextField password){
        String cred=username.getText();
        String cred2=password.getText();
        String credentials=cred+" "+cred2;
        System.out.println(credentials);
        return credentials;
    }
}
