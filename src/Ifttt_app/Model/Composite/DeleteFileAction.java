/*
This class implemetns the Delete file action that delete a file choosen by the user 
in a directory also choosed by the user. 
*/
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.application.Platform;

/**
 *
 * @author marco
 */

/**
 * Represents an action to delete a file.
 * Implements the Action interface.
 * 
 */
public class DeleteFileAction implements Action{
    private final String filePath;
    
    public DeleteFileAction(String filePath){
        this.filePath = filePath;
    }
    
    public String getFilePath(){
        return this.filePath;
    }
    
    
      /**
     * Executes the action by deleting the specified file.
     * Uses Platform.runLater to execute the file deletion operation on the JavaFX application thread.
     *
     * @return True if the action was executed successfully, false otherwise.
     */
    @Override
    public boolean execute() {
        Platform.runLater( () -> {
            try{
                Path file = Paths.get(this.getFilePath());
                Files.delete(file);
            }catch (IOException e){
                e.printStackTrace();
            }
        
        });
        return true;
    }
   
    @Override
    public String description() {
        return DeleteFileAction.class.getSimpleName() + "\n" + "delete this file:";
    }
    
    
}
