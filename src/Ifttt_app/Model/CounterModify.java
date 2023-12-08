/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

/**
 *
 * @author Asus
 */
/**
 * Class that handles the modification of a Counter object's value through a dialog window.
 * The modifyValue method displays a dialog window prompting the user to enter a new value.
 * If the input is a valid integer, it sets the new value in the provided Counter.
 * If the input is not a valid integer, an error dialog window is displayed.
 */
public class CounterModify {
    
     public static void modifyValue(Counter selectedCounter) {
         TextInputDialog dialog = new TextInputDialog(selectedCounter.getValue().toString());
            dialog.setTitle("Modifica valore del contatore");
            dialog.setHeaderText(null);
            dialog.setContentText("Inserisci il nuovo valore:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(newValue -> {
                try {
                    int intValue = Integer.parseInt(newValue);
                    selectedCounter.setValue(intValue);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Errore");
                    alert.setHeaderText("Valore non valido");
                    alert.setContentText("Inserisci un numero intero valido.");
                    alert.showAndWait();
                }
            });
        }
}
