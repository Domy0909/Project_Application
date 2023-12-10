/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;

/**
 * Represents an action to append a specified string to a file.
 * Implements the Action interface.
 * Provides methods to execute the action and obtain a description of the action.
 */
public class SpecifiedStringAction implements Action {
    String filePath;
    private String contentToAppend;
    
    /**
     * Executes the action by appending the specified content to the specified file.
     * Uses Platform.runLater to execute the file append operation on the JavaFX application thread.
     *
     * 
     */
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

    @Override
    public String description() {
        Path path=Paths.get(filePath);
        String filename=path.getFileName().toString();
        return SpecifiedStringAction.class.getSimpleName()+"\n"+"append this: "+contentToAppend+"\non:"+filename;
    }

    public String getContentToAppend() {
        return contentToAppend;
    }

    public void setContentToAppend(String contentToAppend) {
        this.contentToAppend = contentToAppend;
    }
    
    
}
