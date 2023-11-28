/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Platform;

/**
 *
 * @author aless
 */
public class SpecifiedStringAction implements Action {
    String filePath;
    String contentToAppend;
    @Override
    public boolean execute() {
       Platform.runLater(() -> {
        try {
              // Create a BufferedWriter with FileWriter in append mode
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            // Write the string to the file
            bufferedWriter.write(contentToAppend);
            // Close the BufferedWriter
            bufferedWriter.close();
               } catch (IOException e) {
                  e.printStackTrace();
        }
        }); 
       return true;
    }

    public SpecifiedStringAction(String filePath, String contentToAppend) {
        this.filePath = filePath;
        this.contentToAppend = contentToAppend;
    }
    
}
