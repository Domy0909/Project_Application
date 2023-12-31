/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author aless
 * This class, ErrorDialogController, manages the display of an error dialog.
 * When an error occurs, the showErrorDialog method is called, which creates and shows an 
 * Alert-type dialog window
 * containing the specified error message.
 */
public class ErrorDialogController {

    public ErrorDialogController() {
    }
    
    public void showErrorDialog(String error){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(error);
        alert.showAndWait();
        
    }
}
