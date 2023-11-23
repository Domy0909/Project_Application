/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import javafx.scene.control.Alert;

/**
 *
 * @author aless
 */
public class ShowDialogAction implements Action {
    String specificstring;
    @Override
    public boolean execute() {
        Alert alert = new Alert (Alert.AlertType.WARNING,specificstring);
        alert.showAndWait();
        return true;
    }

    public ShowDialogAction(String specificstring) {
        this.specificstring = specificstring;
    }

    public String getSpecificstring() {
        return specificstring;
    }
    
    
}
