package Ifttt_app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import Ifttt_app.Model.RuleSet;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author User
 */
public class IftttApp extends Application {
   
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("View/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("IFTTT APP");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        RuleSet.getInstance().runRuleChecking();
    }
    
     @Override
    public void stop() throws Exception {
        //Chiudi l'applicazione e arresta il thread di controllo dei trigger
       RuleSet.getInstance().stopRuleChecking();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
