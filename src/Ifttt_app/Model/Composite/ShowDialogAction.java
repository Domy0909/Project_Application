/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import javafx.application.Platform;
import javafx.scene.control.Alert;


public class ShowDialogAction implements Action {
    String specificstring;
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
