/*
This class implemetns the Copy file action that copy a file choosen by the user 
in a directory also choosed by the user. 
*/
package Ifttt_app.Model.Composite;

import Ifttt_app.Model.Composite.Action;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javafx.application.Platform;

/**
 *
 * @author marco
 */

/**
 * Represents an action to copy a file to a specified directory.
 * Implements the Action interface.
 * Provides methods to get the file path and directory path.
 */
public class CopyFileAction implements Action{
    private final String filePath;
    private final String directoryPath;
    

    public String getFilePath() {
        return filePath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
    
    
    public CopyFileAction(String filePath, String directoryPath){
        this.directoryPath = directoryPath;
        this.filePath = filePath;
    }
    
    
    /**
     * Executes the action by copying the specified file to the specified directory.
     * Uses Platform.runLater to execute the file copy operation on the JavaFX application thread.
     *
     * @return True if the action was executed successfully, false otherwise.
     */
    @Override
    public boolean execute() {
        Platform.runLater( () -> {
            try{
                Path file = Paths.get(this.getFilePath());
                Path directory = Paths.get(this.getDirectoryPath(), file.getFileName().toString());
                Files.copy(file, directory,StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException e){
                e.printStackTrace();
            }
        
        });
        return true;

    }
    //Provides a description of the CopyFileAction.
    @Override
    public String description() {
        return CopyFileAction.class.getSimpleName() + "\n" + "copy this file:" + this.getFilePath() + "\n" + "to this directory" + this.getDirectoryPath();
    }
    
    
}
