/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * Represents an action to show a dialog with a specific message.
 * Implements the Action interface.
 * Provides methods to execute the action and obtain a description of the action.
 */
public class ShowDialogAction implements Action {
    String specificstring;
    
     /**
     * Executes the action by showing a dialog with the specified message.
     * Uses Platform.runLater to execute the dialog operation on the JavaFX application thread.
     *
     * 
     */
    @Override
    public boolean execute() {
        Platform.runLater(() -> {
        Alert alert = new Alert (Alert.AlertType.WARNING,specificstring);
        alert.showAndWait();
        });
        return true;
    }

    public ShowDialogAction(String specificstring) {
        this.specificstring = specificstring;
    }

    public String getSpecificstring() {
        return specificstring;
    }

    @Override
    public String description() {
       return ShowDialogAction.class.getSimpleName()+"\n"+"message: "+specificstring;
    }

    public void setSpecificstring(String specificstring) {
        this.specificstring = specificstring;
    }

   
    
}
