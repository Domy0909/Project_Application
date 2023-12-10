/*
This class implemetns the Move file action that move a file choosen by the user 
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
 * Represents an action to move a file to a specified directory.
 * Implements the Action interface.
 * 
 */
public class MoveFileAction implements Action{
    private final String filePath;
    private final String directoryPath;
    
    public MoveFileAction(String filePath, String directoryPath){
        this.directoryPath = directoryPath;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }
    
    /**
     * Executes the action by moving the specified file to the specified directory.
     * Uses Platform.runLater to execute the file move operation on the JavaFX application thread.
     *
     * @return True if the action was executed successfully
     */
    

    @Override
    public boolean execute() {
                Platform.runLater( () -> {
            try{
                Path file = Paths.get(this.getFilePath());
                Path directory = Paths.get(this.getDirectoryPath(), file.getFileName().toString());
                Files.move(file, directory,StandardCopyOption.REPLACE_EXISTING);
            }catch (IOException e){
                e.printStackTrace();
            }
        
        });
        return true;
    }

    @Override
    public String description() {
        return MoveFileAction.class.getSimpleName() + "\n" + "move this file:" + this.getFilePath() + "\n" + "to this directory" + this.getDirectoryPath();
    }
    
    
}
