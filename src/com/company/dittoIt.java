package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dittoIt extends Application {
    Stage window;
    Button button,hashTagButton;
    TextField userInput;
    Label textLabel,outputLabel;
    Scene scene;
    Text output;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("dittoIt");

        textLabel=new Label("Enter your text here");
        userInput=new TextField("Enter your text");
        button=new Button("Turn text to all CAPS");
        hashTagButton=new Button("#");
        output=new Text();
        button.setOnAction(e->{CAPSbutton();
        });
        hashTagButton.setOnAction(e->hashTagFunction());



        VBox layout=new VBox(20);

        layout.getChildren().addAll(textLabel,userInput,output,button,hashTagButton);

        scene=new Scene(layout,500,300);

        window.setScene(scene);
        window.show();

    }
    public String CAPSbutton(){
       String capsString=userInput.getText().toUpperCase();
       output.setText(capsString);

       System.out.println(capsString);
       return capsString;
    }
    public void hashTagFunction(){
        String sentence=userInput.getText();
        String [] arrayOfStrings=sentence.split(" ");
        String hashString="#";
        String modifiedText = "";
        String stringOutput="";
        List<String> stringList=new ArrayList<>();
        for(String word:arrayOfStrings) {
            stringOutput = hashString + word;
            stringList.add(stringOutput);
        }
        System.out.println(stringList);
            for (int i = 0; i < stringList.size(); i++) {
                modifiedText+=stringList.get(i)+" ";


            }
            output.setText(modifiedText);
            System.out.println(modifiedText);
        }
    }

