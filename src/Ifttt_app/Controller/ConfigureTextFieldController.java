/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Controller;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author aless
 */
public class ConfigureTextFieldController {

    public ConfigureTextFieldController() {
    }
    
        
    /*
    This function configures a TextField to accept negative numeric input only.
    This function sets up a TextFormatter for the provided TextField, allowing the entry of negative numeric values.
    It uses a regular expression to ensure that the entered text represents a valid negative numeric state.
    */
    
    public void configureNegativeNumericTextField(TextField textField) {
        Pattern validEditingState = Pattern.compile("-?\\d*");

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getControlNewText();
            if (validEditingState.matcher(text).matches()) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        textField.setTextFormatter(textFormatter);
    }
    
//this function is designed to configure a JavaFX TextField to accept only positive numeric input.
   public void configurePositiveNumericTextField(TextField textField) {
      // Define a regular expression pattern for valid input (allowing only digits).
    Pattern validEditingState = Pattern.compile("\\d*");

    // Check if the new text matches the defined pattern.
   // If it does, allow the change; otherwise, return null to prevent the change.
    UnaryOperator<TextFormatter.Change> filter = change -> {
        String text = change.getControlNewText();
        if (validEditingState.matcher(text).matches()) {
            return change;
        }
        return null;
    };
    
    // Create a TextFormatter using the defined filter.
    TextFormatter<String> textFormatter = new TextFormatter<>(filter);
    // Associate the TextFormatter with the provided TextField.
    textField.setTextFormatter(textFormatter);
}
}
